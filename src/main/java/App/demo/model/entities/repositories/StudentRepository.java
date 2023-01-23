package App.demo.model.entities.repositories;

import App.demo.model.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    public Iterable<Student> searchByNameLike(String name);
}
