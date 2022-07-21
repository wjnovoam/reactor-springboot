package co.com.pesonalsoft.shop.repository;

import co.com.pesonalsoft.shop.models.Roles;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author William Johan Novoa Melendrez
 * @date 21/07/2022
 */
@Repository
public interface RoleRepository extends ReactiveCrudRepository<Roles, String> {
}