package co.com.pesonalsoft.shop.models;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author William Johan Novoa Melendrez
 * @date 12/07/2022
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String description;
    private Long categoryId;

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product(String name, double price, String description, Long categoryId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
    }
}