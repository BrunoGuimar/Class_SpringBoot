package App.demo.model.entities.repositories;

import App.demo.model.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    public Iterable<Teacher> searchByNameLike(String name);
}
