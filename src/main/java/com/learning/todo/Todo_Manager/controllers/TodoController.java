package com.learning.todo.Todo_Manager.controllers;

import com.learning.todo.Todo_Manager.models.Todo;
import com.learning.todo.Todo_Manager.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/todos")
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoService todoService;

    @PostMapping("/add")
    public ResponseEntity<Todo> add(@RequestBody Todo todo){
        logger.info("Creating the todo ");
        Todo todo1 = todoService.adding(todo);
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }

    @GetMapping("/fullList")
    public ResponseEntity<List<Todo>> getList(){
        List<Todo> list1 = todoService.getList();
        return new ResponseEntity<>(list1,HttpStatus.OK);
    }

    @GetMapping("/single/{id}")
    public  ResponseEntity<Todo> getSingle(@PathVariable Integer id){
        Todo todo=todoService.single(id);
        return new ResponseEntity<>(todo,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Todo> update(@RequestBody Todo newtodo,@PathVariable Integer id){
        if(todoService.update(newtodo, id) == null){
            logger.error("can not find the id ");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else
            todoService.update(newtodo,id);
        return new ResponseEntity<>(newtodo,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        if (todoService.delete(id)){
            return new ResponseEntity<>("Your Element is deleted Successfully",HttpStatus.OK);
        }else
            return new ResponseEntity<>("Unable to delete your element please double check your id ",HttpStatus.OK);
    }


}
