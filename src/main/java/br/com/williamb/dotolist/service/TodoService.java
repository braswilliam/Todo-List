package br.com.williamb.dotolist.service;

import br.com.williamb.dotolist.entity.Todo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.williamb.dotolist.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {
    
    private final TodoRepository todoRepository;

    //recomendável utilizar: Inject
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list(); //don't repeat yourself
    }

    public List<Todo> list() {
        Sort sort = Sort.by("priority").descending().and(Sort.by("name").descending());
        return todoRepository.findAll(sort);
    }


    public List<Todo> update(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }


}
