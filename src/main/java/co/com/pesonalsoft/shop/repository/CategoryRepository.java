package co.com.pesonalsoft.shop.repository;

import co.com.pesonalsoft.shop.models.Category;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author William Johan Novoa Melendrez
 * @date 13/07/2022
 */
@Repository
public interface CategoryRepository extends ReactiveCrudRepository<Category, Long> {
}