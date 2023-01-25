package App.demo.controllers;

import App.demo.model.entities.Discipline;
import App.demo.model.entities.Student;
import App.demo.model.entities.repositories.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @PostMapping
    public Student newStudent(@Valid Student student){
        repository.save(student);
        return student;
    }

    @GetMapping
    public Iterable<Student> getStudent(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable @Valid int id){
        return repository.findById(id);
    }

    @GetMapping("/search/{name}")
    public Iterable<Student> getStudentByName(@PathVariable @Valid String name){
        return repository.searchByNameLike(name);
    }

    @PutMapping
    public Student updateStudent(@Valid @RequestParam String name, @Valid @RequestParam String cpf, @Valid @RequestParam int id){
        Student student = new Student();
        student = repository.findById(id).get();
        student.setName(name);
        student.setCpf(cpf);
        return repository.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable @Valid int id){
        repository.deleteById(id);
    }

    @PutMapping("/discipline/{id}")
    public Object addDiscipline(@Valid Discipline discipline, @PathVariable int id){
        Optional<Student> studentOpt = repository.findById(id);
        Student student = studentOpt.get();
        var disciplineFiltered = student.getDisciplines().stream().filter(data -> data.getId() == discipline.getId());
        if(disciplineFiltered.toList().isEmpty()) {
            student.getDisciplines().add(discipline);
            repository.save(student);
            return student;
        }
        return student;
    }

}
