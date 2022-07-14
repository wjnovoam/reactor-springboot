package co.com.pesonalsoft.shop.repository;

import co.com.pesonalsoft.shop.models.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author William Johan Novoa Melendrez
 * @date 12/07/2022
 */
@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
    Flux<Product> findAll();
}