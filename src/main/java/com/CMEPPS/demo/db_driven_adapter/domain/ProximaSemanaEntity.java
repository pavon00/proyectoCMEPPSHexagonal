package com.CMEPPS.demo.db_driven_adapter.domain;

import java.util.ArrayList;
import java.util.List;

import com.CMEPPS.demo.core.domain.Horario;
import com.CMEPPS.demo.core.domain.ProximaSemana;
import com.CMEPPS.demo.core.domain.Reparto;
import com.CMEPPS.demo.core.domain.Todo;


public class ProximaSemanaEntity {

	private List<TodoEntity> todosUsuario;
	private List<RepartoEntity> reparto;
	private List<HorarioEntity> horario;
	private String userName;
	private ProximaSemana prox;

	public ProximaSemanaEntity(String userName, List<TodoEntity> todosUsuario, List<RepartoEntity> repartos, List<HorarioEntity> horarios) {
		this.userName = userName;
		this.todosUsuario = todosUsuario;
		this.reparto = repartos;
		this.horario = horarios;
	}
	
	public ProximaSemana toProximaSemana() {
		ArrayList<Todo> listaTodos = new ArrayList<Todo>();
		ArrayList<Horario> listaHorario = new ArrayList<Horario>();
		ArrayList<Reparto> listaReparto = new ArrayList<Reparto>();
		for (TodoEntity t : this.todosUsuario) {
			listaTodos.add(t.toTodo());
		}
		for (HorarioEntity h : this.horario) {
			listaHorario.add(h.toHorario());
		}
		for (RepartoEntity r : this.reparto) {
			listaReparto.add(r.toReparto());
		}
		ProximaSemana ps =  new ProximaSemana(this.userName);
		ps.setTodosUsuario(listaTodos);
		ps.setReparto(listaReparto);
		ps.setHorarios(listaHorario);
		return ps;
	}

	public List<Horario> getHorarios() {
		// TODO Auto-generated method stub
		return toProximaSemana().getHorarios();
	}

	public boolean addTodo(TodoEntity todo) {
		// TODO Auto-generated method stub
		return toProximaSemana().addTodo(todo.toTodo());
		
	}

	public HorarioEntity getHorario(String date) {
		// TODO Auto-generated method stub
		Horario h= toProximaSemana().getHorario(date);
		return new HorarioEntity(h.getUserName(), h.getFecha(), h.isDisponible(), h.getHoras(), true);
	}

	public void deleteTodo(TodoEntity todo) {
		// TODO Auto-generated method stub
		toProximaSemana().deleteTodo(todo.toTodo());
	}
	
	

}
