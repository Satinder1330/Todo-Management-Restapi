package com.learning.todo.Todo_Manager.services.implementation;

import com.learning.todo.Todo_Manager.exceptionHandler.ResourceNotFoundExp;
import com.learning.todo.Todo_Manager.models.Todo;
import com.learning.todo.Todo_Manager.repository.TodoRepositoryJpa;
import com.learning.todo.Todo_Manager.services.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class TodoJpaServiceImp implements TodoServices {

    @Autowired
    private TodoRepositoryJpa todoRepositoryJpa;

    @Override
    public Todo adding(Todo todo) {
        System.out.println(todoRepositoryJpa.save(todo));
        return todoRepositoryJpa.save(todo);
    }

    @Override
    public List<Todo> getList() {
        return todoRepositoryJpa.findAll();
    }

    @Override
    public Todo single(Integer id) {
        Todo todo = todoRepositoryJpa.findById(id).orElseThrow(()-> new ResourceNotFoundExp("Todo not found with given id", HttpStatus.NOT_FOUND));
        return todo;
    }

    @Override
    public Todo update(Todo newtodo, Integer id) {
        Todo todo = todoRepositoryJpa.findById(id).orElseThrow(()-> new ResourceNotFoundExp("Todo not found with given id", HttpStatus.NOT_FOUND));
        if(newtodo.getTitle()!=null)todo.setTitle(newtodo.getTitle());
        if(newtodo.getContent()!=null)todo.setContent(newtodo.getContent());
        if(newtodo.getStatus()!=null)todo.setStatus(newtodo.getStatus());
        if(newtodo.getAddedDate()!=null)todo.setAddedDate(newtodo.getAddedDate());
        if(newtodo.getCompleteBefore()!=null)todo.setCompleteBefore(newtodo.getCompleteBefore());
        Todo updatedTodo = todoRepositoryJpa.save(todo);
        return updatedTodo;
    }

    @Override
    public void delete(Integer id) {
        Todo todo = todoRepositoryJpa.findById(id).orElseThrow(()-> new ResourceNotFoundExp("Todo not found with given id", HttpStatus.NOT_FOUND));
         todoRepositoryJpa.deleteById(id);


    }
}
