package sin.taco.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import sin.taco.model.Ingredient;
import sin.taco.model.Ingredient.Type;
import sin.taco.model.Order;
import sin.taco.model.Taco;
import sin.taco.repository.IngredientRepository;
import sin.taco.repository.TacoRepository;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

  private final IngredientRepository ingredientRepository;

  private final TacoRepository tacoRepository;

  @Autowired
  public DesignTacoController(IngredientRepository ingredientRepository, TacoRepository tacoRepository) {
    this.ingredientRepository = ingredientRepository;
    this.tacoRepository = tacoRepository;
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

    model.addAttribute("taco", new Taco());

    return "design";
  }

  @ModelAttribute(name = "order")
  public Order order() {
    return new Order();
  }

  @ModelAttribute(name = "taco")
  public Taco taco() {
    return new Taco();
  }

  @PostMapping
  public String processDesign(@Valid Taco taco, Errors errors, @ModelAttribute Order order) {
    if (errors.hasErrors()) {
      errors.getAllErrors().forEach(objectError -> log.info(objectError.toString()));
      return "design";
    }

    Taco saved = tacoRepository.save(taco);
    order.addTaco(saved);
    return "redirect:/orders/current";
  }
}
