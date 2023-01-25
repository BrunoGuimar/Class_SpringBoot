package App.demo.controllers;

import App.demo.model.entities.Discipline;
import App.demo.model.entities.Teacher;
import App.demo.model.entities.repositories.TeacherRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    Discipline discipline = new Discipline();

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
    public Teacher updateTeacher(@Valid @RequestParam String name, @RequestParam int id){
        Teacher teacher = new Teacher();
        teacher = repository.findById(id).get();
        teacher.setName(name);
        return repository.save(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable @Valid int id){
        repository.deleteById(id);
    }

    @PutMapping("/discipline/{id}")
    public Object addDiscipline(@Valid Discipline discipline, @PathVariable int id){
        Optional<Teacher> teacherOpt = repository.findById(id);
        Teacher teacher = teacherOpt.get();
        teacher.getDisciplines().add(discipline);
        repository.save(teacher);
        return teacher;
    }
}
