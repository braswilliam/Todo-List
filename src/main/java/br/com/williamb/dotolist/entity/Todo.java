package br.com.williamb.dotolist.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "todos")

public class Todo {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @NotBlank
    private String name;

    @Getter
    @Setter
    @NotBlank
    private String description;


    @Getter
    @Setter
    private boolean carriedOut; //Realizado

    @Getter
    @Setter
    private String priority; //prioridade


    public Todo(String name, String description, boolean carriedOut, String priority) {
        this.name = name;
        this.description = description;
        this.carriedOut = carriedOut;
        this.priority = priority;
    }


}
