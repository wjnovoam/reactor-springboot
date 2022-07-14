package co.com.pesonalsoft.shop.service;

import co.com.pesonalsoft.shop.models.Category;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author William Johan Novoa Melendrez
 * @date 13/07/2022
 */
public interface ICategoryService {
    Flux<Category> findAll();
    Mono<Category> findById(Long id);
}