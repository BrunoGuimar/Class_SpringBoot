package App.demo.model.entities.repositories;

import App.demo.model.entities.Discipline;
import org.springframework.data.repository.CrudRepository;

public interface DisciplineRepository extends CrudRepository<Discipline, Integer> {
}
