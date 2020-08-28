package net.todoapp.dao;

import java.util.List;

import net.todoapp.model.Todo;

public interface TodoDao {

	List<Todo> selectAllTodos();
}
