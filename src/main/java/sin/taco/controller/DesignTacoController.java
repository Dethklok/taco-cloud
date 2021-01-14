package sin.taco.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.SessionAttributes;
import sin.taco.model.Ingredient;
import sin.taco.model.Ingredient.Type;
import sin.taco.model.Taco;
import sin.taco.repository.IngredientRepository;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

  private final IngredientRepository ingredientRepository;

  @Autowired
  public DesignTacoController(IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }

  @GetMapping
  public String showDesignForm(Model model) {
    List<Ingredient> ingredients = new ArrayList<>();
    ingredientRepository.findAll().forEach(ingredients::add);

    for (Type type : Type.values()) {
      List<Ingredient> ingredientsByType = ingredients.stream()
              .filter(ingredient -> ingredient.getType().equals(type))
              .collect(Collectors.toList());
      model.addAttribute(type.toString().toLowerCase(), ingredientsByType);
    }

    model.addAttribute("design", new Taco());

    return "design";
  }

  @PostMapping
  public String processDesign(@Valid Taco taco, Errors errors) {
    if (errors.hasErrors()) {
      return "design";
    }

    log.info("Processing design: " + taco);
    return "redirect:/orders/current";
  }
}
