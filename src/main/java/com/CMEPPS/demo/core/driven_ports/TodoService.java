
package com.CMEPPS.demo.core.driven_ports;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CMEPPS.demo.db_driven_adapter.domain.TodoEntity;
import com.CMEPPS.demo.db_driven_adapter.jparepository.TodoRepository;

@Service
public class TodoService implements ITodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List < TodoEntity > getTodosByUser(String user) {
        return todoRepository.findByUserName(user);
    }
    
    @Override
    public List < TodoEntity > getTodosPendientesByUser(String user) {
    	ArrayList<TodoEntity> listaAux = new ArrayList<TodoEntity>();
    	for (TodoEntity t : todoRepository.findByUserName(user)) {
    		if (t.toTodo().esPendiente()) {
    			listaAux.add(t);
			}
		}
        return listaAux;
    }

    @Override
    public Optional < TodoEntity > getTodoById(long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void updateTodo(TodoEntity todo) {
        todoRepository.save(todo);
    }

    @Override
    public void addTodo(String name, String desc, Date targetDate, int horasEstimadas, int prioridad, boolean introducidaEnProximaSemana, boolean isDone) {
        todoRepository.save(new TodoEntity(name, desc, targetDate, horasEstimadas, prioridad, introducidaEnProximaSemana,  isDone));
    }

    @Override
    public void deleteTodo(long id) {
        Optional < TodoEntity > todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            todoRepository.delete(todo.get());
        }
    }

    @Override
    public void saveTodo(TodoEntity todo) {
        todoRepository.save(todo);
    }
}
