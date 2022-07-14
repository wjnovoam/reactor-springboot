package co.com.pesonalsoft.shop.dto;

import co.com.pesonalsoft.shop.models.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author William Johan Novoa Melendrez
 * @date 13/07/2022
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductDto {

    private String name;
    private double price;
    private String description;
    private Long categoryId;
}