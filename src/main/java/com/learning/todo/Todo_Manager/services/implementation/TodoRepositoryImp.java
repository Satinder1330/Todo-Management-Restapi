package com.learning.todo.Todo_Manager.services.implementation;

import com.learning.todo.Todo_Manager.models.Todo;
import com.learning.todo.Todo_Manager.repository.TodoRepository;
import com.learning.todo.Todo_Manager.services.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
//@Primary
public class TodoRepositoryImp implements TodoServices {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo adding(Todo todo) {
        return todoRepository.insert(todo);
    }

    @Override
    public List<Todo> getList() {
        return todoRepository.fullList();
    }

    @Override
    public Todo single(Integer id) {
        return todoRepository.getSingle(id);
    }

    @Override
    public Todo update(Todo newtodo, Integer id) {
        return todoRepository.update(id,newtodo);
    }

    @Override
    public void delete(Integer id) {
        todoRepository.delete(id);
    }
}
