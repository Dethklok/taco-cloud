package sin.taco.repository;

import org.springframework.data.repository.CrudRepository;
import sin.taco.model.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}
