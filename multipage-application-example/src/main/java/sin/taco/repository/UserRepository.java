package sin.taco.repository;

import org.springframework.data.repository.CrudRepository;
import sin.taco.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

  User findUserByUsername(String username);

}
