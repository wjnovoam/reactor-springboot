package co.com.pesonalsoft.shop.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author William Johan Novoa Melendrez
 * @date 13/07/2022
 */
@Configuration
public class BeanModelMapper {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}