package br.com.williamb.dotolist.service;

import br.com.williamb.dotolist.dtos.TodoDto;
import br.com.williamb.dotolist.entities.Todo;
import br.com.williamb.dotolist.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public TodoDto create(TodoDto todoDto) {
        Todo todo = new Todo();
        todo.setName(todoDto.name());
        todo.setDescription(todoDto.description());
        todo.setPriority(todoDto.priority());
        Todo savedTodo = todoRepository.save(todo);
        return convertToDto(savedTodo);
    }

    public List<TodoDto> list() {
        Sort sort = Sort.by("priority").descending().and(Sort.by("name").descending());
        return todoRepository.findAll(sort).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<TodoDto> update(Long id, TodoDto todoDto) {
        return todoRepository.findById(id).map(existingTodo -> {
            existingTodo.setName(todoDto.name());
            existingTodo.setDescription(todoDto.description());
            existingTodo.setPriority(todoDto.priority());
            Todo updatedTodo = todoRepository.save(existingTodo);
            return convertToDto(updatedTodo);
        });
    }

    public String delete(Long id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            return "Todo deleted successfully";
        } else {
            return "Todo not found";
        }
    }

    private TodoDto convertToDto(Todo todo) {
        return new TodoDto(todo.getId(), todo.getName(), todo.getDescription(), todo.getPriority());
    }
}
