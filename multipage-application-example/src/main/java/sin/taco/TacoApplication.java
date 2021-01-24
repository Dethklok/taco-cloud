package sin.taco;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sin.taco.model.Ingredient;
import sin.taco.model.Ingredient.Type;
import sin.taco.repository.IngredientRepository;

@SpringBootApplication
public class TacoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(IngredientRepository ingredientRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				ingredientRepository.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
				ingredientRepository.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
				ingredientRepository.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
				ingredientRepository.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
				ingredientRepository.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
				ingredientRepository.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
				ingredientRepository.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
				ingredientRepository.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
				ingredientRepository.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
				ingredientRepository.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
			}
		};
	}

}
