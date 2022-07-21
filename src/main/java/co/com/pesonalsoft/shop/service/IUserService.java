package co.com.pesonalsoft.shop.service;

import co.com.pesonalsoft.shop.models.User;
import reactor.core.publisher.Mono;

/**
 * @author William Johan Novoa Melendrez
 * @date 18/07/2022
 */
public interface IUserService {
    Mono<User> findByUsername(String username);
}