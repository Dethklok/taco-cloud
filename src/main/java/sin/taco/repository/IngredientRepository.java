package sin.taco.repository;

import org.springframework.data.repository.CrudRepository;
import sin.taco.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
