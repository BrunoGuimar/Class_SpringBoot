package App.demo.controllers;

import App.demo.model.entities.Teacher;
import App.demo.model.entities.repositories.TeacherRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    DisciplineController discipline = new DisciplineController();

    @Autowired
    private TeacherRepository repository;

    @PostMapping
    public Teacher newTeacher(@Valid Teacher teacher){
        repository.save(teacher);
        return teacher;
    }

    @GetMapping
    public Iterable<Teacher> getTeacher(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Teacher> getTeacherById(@PathVariable @Valid int id){
        return repository.findById(id);
    }

    @GetMapping("/search/{name}")
    public Iterable<Teacher> getTeacherByName(@PathVariable @Valid String name){
        return repository.searchByNameLike(name);
    }

    @PutMapping
    public Teacher updateTeacher(@Valid Teacher teacher){
        return repository.save(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable @Valid int id){
        repository.deleteById(id);
    }

    @GetMapping("/discipline/{name}")
    public List addDiscipline(@PathVariable String name){
        Teacher teacher1 = new Teacher();
        teacher1.getDisciplines().add(name);
        repository.save(teacher1);
        return teacher1.getDisciplines();
    }
}
