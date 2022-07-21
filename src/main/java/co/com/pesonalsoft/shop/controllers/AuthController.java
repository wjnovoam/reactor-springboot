package co.com.pesonalsoft.shop.controllers;

import co.com.pesonalsoft.shop.dto.AuthRequest;
import co.com.pesonalsoft.shop.dto.AuthResponse;
import co.com.pesonalsoft.shop.security.JWTUtil;
import co.com.pesonalsoft.shop.security.PBKDF2Encoder;
import co.com.pesonalsoft.shop.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author William Johan Novoa Melendrez
 * @date 18/07/2022
 */
@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private JWTUtil jwtUtil;
    private PBKDF2Encoder passwordEncoder;
    private IUserService iUserService;

    @PostMapping("/login")
    public Mono<ResponseEntity<AuthResponse>> login(@RequestBody AuthRequest authRequest) {
        return iUserService.findByUsername(authRequest.getUsername())
                .filter(userDetails -> passwordEncoder.encode(authRequest.getPassword()).equals(userDetails.getPassword()))
                .map(userDetails -> ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails))))
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()));
    }
}