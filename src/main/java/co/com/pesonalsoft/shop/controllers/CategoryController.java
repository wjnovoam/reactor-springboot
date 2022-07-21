package co.com.pesonalsoft.shop.controllers;

import co.com.pesonalsoft.shop.models.Category;
import co.com.pesonalsoft.shop.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author William Johan Novoa Melendrez
 * @date 13/07/2022
 */
@RestController
@RequestMapping("/api/categorys")
public class CategoryController {

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping
    public Flux<Category> findAllProduct(){
        return iCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Category>> findProductById(@PathVariable(name = "id") Long id){
        return iCategoryService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}