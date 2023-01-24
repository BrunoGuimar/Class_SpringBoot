package App.demo.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @NotBlank
        private String name;

        @NotBlank
        @Min(11)
        @Column(unique = true)
        private String cpf;

        @ManyToMany
        List<Discipline> disciplines = new ArrayList<>();


        public Student() {
        }

        public Student(String name, String cpf) {
            this.name = name;
            this.cpf = cpf;
        }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
}
