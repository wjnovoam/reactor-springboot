package co.com.pesonalsoft.shop.controllers;

import co.com.pesonalsoft.shop.dto.ProductDto;
import co.com.pesonalsoft.shop.models.Product;
import co.com.pesonalsoft.shop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author William Johan Novoa Melendrez
 * @date 12/07/2022
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping
    public Flux<Product> findAllProduct(){
        return iProductService.findAllProduct();
    }

    @PostMapping
    public Mono<Product> createProduct(@RequestBody ProductDto productDto){
        return iProductService.createProduct(productDto);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Product>> updateProduct(@PathVariable(name = "id") Long id, @RequestBody Product product){
        return iProductService.updateProduct(id, product)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Product>> findProductById(@PathVariable(name = "id") Long id){
        return iProductService.findByIdProduct(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable(name = "id") Long id){
        return iProductService.deleteProductById(id);
    }

    @PostMapping("/lista/webclient")
    public Flux<Product> findProductListIdsWebClient(@RequestBody List<Long> listIds){
        return iProductService.findAllProductByIds(listIds);
    }


    @PostMapping("/lista/findById")
    public Flux<Product> findProductListIdsFindById(@RequestBody List<Long> listIds){
        return iProductService.findAllProductByIdsMethodFindById(listIds);
    }

    @GetMapping("/price")
    public Flux<Product> findAllProductForRangePrice(@RequestParam(value = "max", required = false) Double maxPrice,
                                                     @RequestParam(value = "min", required = false) Double minPrice){
        return iProductService.findAllProductByMaxPrice(minPrice, maxPrice);
    }

    @GetMapping("/name")
    public Flux<Product> findAllProductForName(@RequestParam(value = "name") String name){
        return iProductService.findAllProductByName(name);
    }

    @GetMapping("/orderProducts")
    public Flux<Product> findAllProductAndOrderForName(){
        return iProductService.findAllProductsAndOrderByName();
    }

}