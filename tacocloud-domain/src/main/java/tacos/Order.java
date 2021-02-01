package tacos;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ManyToOne(targetEntity = User.class)
  private User user;

  @NotBlank(message = "Delivery name is required")
  private String deliveryName;

  @NotBlank(message = "Street is required")
  private String street;

  @NotBlank(message = "City is required")
  private String city;

  @NotBlank(message = "State is required")
  private String state;

  @NotBlank(message = "Zip code is required")
  private String deliveryZip;

  @CreditCardNumber(message = "Not a valid credit card number")
  private String ccNumber;

  @Pattern(regexp = "^(0[1-9]|1[0-2])([/])([1-9][0-9]$)",
    message = "Must be formatted MM/YY")
  private String ccExpiration;

  @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
  private String ccCVV;

  @ManyToMany(targetEntity = Taco.class)
  private List<Taco> tacos = new ArrayList<>();

  private Date placedAt;

  public void addDesign(Taco design) {
    this.tacos.add(design);
  }

  @PrePersist
  private void placedAt() {
    this.placedAt = new Date();
  }

}