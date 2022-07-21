package co.com.pesonalsoft.shop.service;

import co.com.pesonalsoft.shop.models.Role;
import co.com.pesonalsoft.shop.models.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author William Johan Novoa Melendrez
 * @date 18/07/2022
 */
@Service
public class UserServiceImpl implements IUserService{

    private Map<String, User> data;

    @PostConstruct
    public void init() {
        data = new HashMap<>();

        //username:passwowrd -> user:user
        data.put("user",
                new User("user", "cBrlgyL2GI2GINuLUUwgojITuIufFycpLG4490dhGtY=", true, List.of(Role.ROLE_USER,
                Role.ROLE_ADMIN)));

        //username:passwowrd -> admin:admin
        data.put("admin",
        new User("admin", "dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w=", true, List.of(Role.ROLE_ADMIN)));
    }

    @Override
    public Mono<User> findByUsername(String username) {
        return Mono.justOrEmpty(data.get(username));
    }
}