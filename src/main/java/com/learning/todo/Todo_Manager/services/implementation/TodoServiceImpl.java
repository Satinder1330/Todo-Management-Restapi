package com.learning.todo.Todo_Manager.services.implementation;

import com.learning.todo.Todo_Manager.exceptionHandler.ResourceNotFoundExp;
import com.learning.todo.Todo_Manager.models.Todo;
import com.learning.todo.Todo_Manager.services.TodoServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TodoServiceImpl implements TodoServices {

    Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);
    Random random = new Random();
    List<Todo>todoList = new ArrayList<>();

    public Todo adding(Todo todo){
        int id = random.nextInt(100);
        todo.setId(id);                  // set random id
        LocalDate currentDate = LocalDate.now();
        todo.setAddedDate(Date.valueOf(LocalDate.now() ));  // set addedDate automatically
        logger.info("added date of {} is {} ",todo.getTitle(),currentDate);   // to check in the logs
        todoList.add(todo);
        logger.info("New ToDo {}",todo);
        return todo;
    }

    public List<Todo> getList(){
        logger.info("list is {} ",todoList);
        return todoList;
    }

    public Todo single(Integer id){
        Todo todo1=todoList.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new ResourceNotFoundExp(("Resource not found"),       //Custom exception
                        HttpStatus.NOT_FOUND));
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
       boolean bool = todoList.removeIf(todo -> todo.getId().equals(id));
        return bool;
    }

}
