package co.com.pesonalsoft.shop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author William Johan Novoa Melendrez
 * @date 12/07/2022
 */
@Getter
@Setter
public class ListProductsIdDto {

    private List<Long> idsProducts;

    public ListProductsIdDto(List<Long> idsProducts) {
        this.idsProducts = idsProducts;
    }
}