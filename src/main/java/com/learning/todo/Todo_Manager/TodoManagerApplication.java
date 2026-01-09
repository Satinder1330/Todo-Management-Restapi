package com.learning.todo.Todo_Manager;

import com.learning.todo.Todo_Manager.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TodoManagerApplication  {

@Autowired
TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}


}
