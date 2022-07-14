package co.com.pesonalsoft.shop.utils;

import co.com.pesonalsoft.shop.dto.ProductDto;
import co.com.pesonalsoft.shop.models.Category;
import co.com.pesonalsoft.shop.models.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author William Johan Novoa Melendrez
 * @date 13/07/2022
 */
@Component
public class ConverterDtoToEntity {

    ModelMapper modelMapper = new ModelMapper();

    public ProductDto convertToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    public Mono<Product> convertToEntity(ProductDto productDto,Category category){

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Product product = modelMapper.map(productDto, Product.class);
        product.setCategoryId(category.getId());
        //product.setId(null);

        return Mono.just(product);
    }

        /*public Mono<Product> convertToEntity(ProductDto productDto, Mono<Category> category){
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        Mono<Product> product = Mono.just(
                modelMapper.map(productDto, Product.class)
        );

        return product.map(product1 -> {
            Category categor = category.block();
            //product1.setCategory(categor);

            return  product1;
        });

    }*/
}