package com.learning.todo.Todo_Manager.services;

import com.learning.todo.Todo_Manager.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TodoService {

    Logger logger = LoggerFactory.getLogger(TodoService.class);
    Random random = new Random();
    List<Todo>todoList = new ArrayList<>();

    public Todo adding(Todo todo){
        int id = random.nextInt(100);
        todo.setId(id);
        todoList.add(todo);
        logger.info("Todos {}",this.todoList);
        return todo;
    }

    public List<Todo> getList(){
        logger.info("list is {} ",todoList);
        return todoList;
    }
    public Todo single(Integer id){
        Todo todo1=todoList.stream()
                .filter(todo -> todo.getId()==id)
                .findFirst()
                .orElse(null);
        return todo1;
    }
    public Todo update(Todo newtodo,Integer id){
        for (Todo todo : todoList) {
            if(todo.getId().equals(id)){
                todo.setContent(newtodo.getContent());
                todo.setTitle(newtodo.getTitle());
                todo.setStatus(newtodo.getStatus());
                newtodo.setId(id);
                logger.info("element is updated successfully");
                return newtodo;
            }
        }return null;

    }
    public Boolean delete(Integer id){
       Boolean bool = todoList.removeIf(todo -> todo.getId().equals(id));
       if(bool){return true;}
       return false;
    }




}
