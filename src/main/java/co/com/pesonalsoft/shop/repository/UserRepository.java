package co.com.pesonalsoft.shop.repository;

import co.com.pesonalsoft.shop.models.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author William Johan Novoa Melendrez
 * @date 18/07/2022
 */
@Repository
public interface UserRepository extends ReactiveCrudRepository<User, String> {
}