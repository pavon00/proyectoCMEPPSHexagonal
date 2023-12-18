
package com.CMEPPS.demo.core.driven_ports;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.CMEPPS.demo.db_driven_adapter.domain.TodoEntity;

public interface ITodoService {

	List<TodoEntity> getTodosByUser(String user);
	
	List<TodoEntity> getTodosPendientesByUser(String user);

	Optional<TodoEntity> getTodoById(long id);

	void updateTodo(TodoEntity todo);

	void addTodo(String name, String desc, Date targetDate, int horasEstimadas, int prioridad, boolean introducidaEnProximaSemana, boolean isDone);

	void deleteTodo(long id);

	void saveTodo(TodoEntity todo);
}