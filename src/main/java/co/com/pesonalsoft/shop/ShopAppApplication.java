package co.com.pesonalsoft.shop;

import co.com.pesonalsoft.shop.models.Category;
import co.com.pesonalsoft.shop.models.Product;
import co.com.pesonalsoft.shop.repository.CategoryRepository;
import co.com.pesonalsoft.shop.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.util.Arrays;

@SpringBootApplication
public class ShopAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopAppApplication.class, args);
	}


	@Bean
	public CommandLineRunner demoCategory(CategoryRepository repository) {
		return args-> repository.saveAll(Arrays.asList(
						new Category("Frutas"),
						new Category("Electrodomesticos"),
						new Category("Tecnologia")
				))
				.blockLast(Duration.ofSeconds(10));
	}

	@Bean
	public CommandLineRunner demo(ProductRepository repository) {
		return args-> repository.saveAll(Arrays.asList(
					new Product("manzana", 2000.0, "Manzana Grande"),
					new Product("Mango", 5000.0, "Mango verde"),
					new Product("Cicla", 1000000.0, "Cicla numero 27"),
					new Product("Moto", 4000000.0, "Moto negra"),
					new Product("Portatil", 3000000.0, "Portatil hp"),
					new Product("Mouse", 40000.0, "Mouse inalambrico"),
					new Product("Pantalla", 600000.0, "Pantalla LG"),
					new Product("Cuaderno", 6000.0, "mcuaderno 100 hojas"),
					new Product("Teclado", 35000.0, "Teclado inalambrico"),
					new Product("Calculadora", 80000.0, "Es de 24 cm y economica")))
					.blockLast(Duration.ofSeconds(10));
	}

}