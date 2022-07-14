package co.com.pesonalsoft.shop.service;

import co.com.pesonalsoft.shop.models.Category;
import co.com.pesonalsoft.shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author William Johan Novoa Melendrez
 * @date 13/07/2022
 */

@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Flux<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Mono<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }
}