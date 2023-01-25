package App.demo.controllers;

import App.demo.model.entities.Discipline;
import App.demo.model.entities.repositories.DisciplineRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/discipline")
public class DisciplineController {


    @Autowired
    private DisciplineRepository repository;

    @PostMapping
    public Discipline newDiscipline(@Valid Discipline discipline){
        repository.save(discipline);
        return discipline;
    }

    @GetMapping
    public Iterable<Discipline> getDiscipline(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Discipline> getDisciplineById(@PathVariable @Valid int id){
        return repository.findById(id);
    }

    @PutMapping
    public Discipline updateDiscipline(@Valid Discipline discipline){
        return repository.save(discipline);
    }

    @DeleteMapping("/{id}")
    public void deleteDiscipline(@PathVariable @Valid int id){
        repository.deleteById(id);
    }
}
