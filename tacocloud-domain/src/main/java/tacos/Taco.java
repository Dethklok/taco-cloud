package tacos;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Data
@RestResource(rel = "tacos", path = "tacos")
public class Taco {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull
  @Size(min = 5, message = "Name must be at least 5 characters long")
  private String name;

  @ManyToMany(targetEntity = Ingredient.class)
  @Size(min = 1, message = "You must choose at least 1 ingredient")
  private List<Ingredient> ingredients;

  private Date createdAt;

  private Date updatedAt;

  @PrePersist
  private void createdAt() {
    this.createdAt = new Date();
  }

}
