package com.learning.todo.Todo_Manager.services;

import com.learning.todo.Todo_Manager.models.Todo;

import java.util.List;

public interface TodoServices {
    public Todo adding(Todo todo);
    public List<Todo> getList();
    public Todo single(Integer id);
    public Todo update(Todo newtodo,Integer id);
    public Boolean delete(Integer id);

}
