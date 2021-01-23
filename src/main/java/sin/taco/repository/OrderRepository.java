package sin.taco.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import sin.taco.model.Order;
import sin.taco.model.User;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

  List<Order> findByUserOrderByCreatedAtDesc(User user, Pageable pageable);
}
