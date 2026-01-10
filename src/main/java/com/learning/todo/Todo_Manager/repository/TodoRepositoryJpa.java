package com.learning.todo.Todo_Manager.repository;

import com.learning.todo.Todo_Manager.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepositoryJpa extends JpaRepository<Todo,Integer> {

}
