package com.learning.todo.Todo_Manager;
import com.learning.todo.Todo_Manager.models.Todo;
import com.learning.todo.Todo_Manager.repository.TodoRepository;
import com.learning.todo.Todo_Manager.repository.TodoRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TodoManagerApplication implements CommandLineRunner {

//@Autowired
//TodoRepository todoRepository;
	@Autowired
	private TodoRepositoryJpa todoRepositoryJpa;


	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
