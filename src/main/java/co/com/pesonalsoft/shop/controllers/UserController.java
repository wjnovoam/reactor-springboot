package co.com.pesonalsoft.shop.controllers;

import co.com.pesonalsoft.shop.models.User;
import co.com.pesonalsoft.shop.repository.RoleRepository;
import co.com.pesonalsoft.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author William Johan Novoa Melendrez
 * @date 18/07/2022
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public Flux<User> usuarios(){
        userRepository.findAll().subscribe(item -> System.out.println(item));

        roleRepository.findAll().subscribe(item -> System.out.println(item));

        return userRepository.findAll();
    }
}