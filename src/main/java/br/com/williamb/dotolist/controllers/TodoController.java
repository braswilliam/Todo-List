package br.com.williamb.dotolist.controllers;

import br.com.williamb.dotolist.dtos.TodoDto;
import br.com.williamb.dotolist.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoDto create(@RequestBody @Valid TodoDto todoDto) {
        return todoService.create(todoDto);
    }

    @GetMapping
    public List<TodoDto> list() {
        return todoService.list();
    }

    @PutMapping("/{id}")
    public Optional<TodoDto> update(@PathVariable("id") Long id, @RequestBody TodoDto todoDto) {
        return todoService.update(id, todoDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        return todoService.delete(id);
    }
}
