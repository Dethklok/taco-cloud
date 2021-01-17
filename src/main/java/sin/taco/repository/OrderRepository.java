package sin.taco.repository;

import sin.taco.model.Order;

public interface OrderRepository {

  Order save(Order order);

}
