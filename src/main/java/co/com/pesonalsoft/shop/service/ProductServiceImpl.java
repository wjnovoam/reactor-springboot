package co.com.pesonalsoft.shop.service;

import co.com.pesonalsoft.shop.dto.ProductDto;
import co.com.pesonalsoft.shop.exceptions.NotFountException;
import co.com.pesonalsoft.shop.models.Category;
import co.com.pesonalsoft.shop.models.Product;
import co.com.pesonalsoft.shop.repository.CategoryRepository;
import co.com.pesonalsoft.shop.repository.ProductRepository;
import co.com.pesonalsoft.shop.utils.ConverterDtoToEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

/**
 * @author William Johan Novoa Melendrez
 * @date 12/07/2022
 */
@Service
public class ProductServiceImpl implements IProductService {

    private static final String  EL_ID_NO_EXISTE ="El id no existe";

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    ConverterDtoToEntity converterDtoToEntity = new ConverterDtoToEntity();

    @Override
    public Flux<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> createProduct(ProductDto productDto) {

        return categoryRepository.findById(productDto.getCategoryId())
                .switchIfEmpty(Mono.error(new NotFountException(EL_ID_NO_EXISTE)))
                .flatMap(category -> converterDtoToEntity.convertToEntity(productDto, category))
                .flatMap(entity -> productRepository.save(entity));

    }


    @Override
    public Mono<Product> updateProduct(Long id, Product product) {

        return productRepository.findById(id)
                .flatMap(existingProduct ->{
                    existingProduct.setName(product.getName());
                    existingProduct.setDescription(product.getName());
                    existingProduct.setPrice(product.getPrice());
                    return productRepository.save(existingProduct);
                });
    }

    @Override
    public Mono<Product> findByIdProduct(Long id) {
        return productRepository.findById(id)
                .switchIfEmpty(Mono.error(new NotFountException(EL_ID_NO_EXISTE)));
    }

    @Override
    public Mono<Void> deleteProductById(Long id) {
        return this.productRepository.findById(id)
                .flatMap(this.productRepository::delete)
                .switchIfEmpty(Mono.error(new NotFountException(EL_ID_NO_EXISTE)));
    }

    @Override
    public Flux<Product> findAllProductByIds(List<Long> listIds){
        Flux<Mono<Product>> productFlux = Flux.fromIterable(listIds)
                .mapNotNull(item -> WebClient
                        .create()
                        .get()
                        .uri("http://localhost:8090/api/products/"+ item)
                        .retrieve()
                        .bodyToMono(Product.class)
                )
                .doOnNext(Mono::subscribe);

        return Flux.mergeSequential(productFlux);
    }

    @Override
    public Flux<Product> findAllProductByIdsMethodFindById(List<Long> listIds) {

        Flux<Mono<Product>> productFlux = Flux.fromIterable(listIds)
                .map(this::findByIdProduct)
                .doOnNext(Mono::subscribe);
        return Flux.mergeSequential(productFlux);
    }

    @Override
    public Flux<Product> findAllProductByMaxPrice(Double minPrice, Double maxPrice) {

        Predicate<Product> productPredicate = (product -> {
            if(minPrice != null && maxPrice != null)
                return product.getPrice() >= minPrice && product.getPrice() <= maxPrice;
            if(minPrice != null)
                return product.getPrice() >= minPrice;
            return (maxPrice != null)?product.getPrice() <= maxPrice : product.getPrice() >= 0;
        });

        return productRepository.findAll()
                .filter(productPredicate);
    }

    @Override
    public Flux<Product> findAllProductByName(String name) {
        return productRepository.findAll()
                .filter(product -> (product.getName().toUpperCase(Locale.ROOT))
                                            .contains(name.toUpperCase()));
    }

    @Override
    public Flux<Product> findAllProductsAndOrderByName() {
        return productRepository.findAll()
                .sort(Comparator.comparing(Product::getName));
    }


}