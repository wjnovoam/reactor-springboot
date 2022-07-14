package co.com.pesonalsoft.shop.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

/**
 * @author William Johan Novoa Melendrez
 * @date 13/07/2022
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Category {

    @Id
    private Long id;
    private String nameCategory;

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Category(Long id, String nameCategory) {
        this.id = id;
        this.nameCategory = nameCategory;
    }
}