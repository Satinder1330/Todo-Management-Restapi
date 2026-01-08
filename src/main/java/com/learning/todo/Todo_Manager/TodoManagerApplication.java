package com.learning.todo.Todo_Manager;

import com.learning.todo.Todo_Manager.models.Todo;
import com.learning.todo.Todo_Manager.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class TodoManagerApplication implements CommandLineRunner {

@Autowired
TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Todo todo = new Todo(3,"Weekend","watch a movie",
//				      "pending", Date.from(Instant.now()),Date.from(Instant.now()));
//		System.out.println(todoRepository.insert(todo));
//		 todoRepository.getSingle(1);
	//	System.out.println(todoRepository.fullList());
//		Todo newtodo= new Todo();
//		newtodo.setContent("Job search");
//		//newtodo.setStatus("pending");
//		//newtodo.setTitle("search job");
//		newtodo.setCompleteBefore(Date.from(Instant.now()));

	//	System.out.println(todoRepository.update(1,newtodo));
//		System.out.println(todoRepository.delete(4));
//		todoRepository.multiDelete(3);

	}
}
