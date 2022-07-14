package co.com.pesonalsoft.shop.service;

import co.com.pesonalsoft.shop.dto.ProductDto;
import co.com.pesonalsoft.shop.models.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author William Johan Novoa Melendrez
 * @date 12/07/2022
 */
public interface IProductService {
    Flux<Product> findAllProduct();
    Mono<Product> createProduct(ProductDto productDto);
    Mono<Product> updateProduct(Long id, Product product);
    Mono<Product> findByIdProduct(Long id);
    Mono<Void> deleteProductById(Long id);
    Flux<Product> findAllProductByIds(List<Long> listIds);
    Flux<Product> findAllProductByIdsMethodFindById(List<Long> listIds);
    Flux<Product> findAllProductByMaxPrice(Double minPrice, Double maxPrice);
    Flux<Product> findAllProductByName(String name);
    Flux<Product> findAllProductsAndOrderByName();


}