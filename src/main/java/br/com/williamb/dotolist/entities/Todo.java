package br.com.williamb.dotolist.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "todos")
public class Todo {

    public Todo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotBlank
    @NotBlank(message = "não deve estar em branco")
    private String name;

    @Setter
    @NotBlank
    @NotBlank(message = "não deve estar em branco")
    private String description;

    @Setter
    private boolean carriedOut; // Realizado

    @Setter
    private Integer priority; // Prioridade

    public Todo(String name, String description, boolean carriedOut, Integer priority) {
        this.name = name;
        this.description = description;
        this.carriedOut = carriedOut;
        this.priority = priority;
    }
}
