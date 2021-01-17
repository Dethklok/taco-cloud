package sin.taco.repository;

import org.springframework.data.repository.CrudRepository;
import sin.taco.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
