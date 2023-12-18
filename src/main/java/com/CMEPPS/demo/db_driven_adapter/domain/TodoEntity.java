package com.CMEPPS.demo.db_driven_adapter.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.CMEPPS.demo.core.domain.Todo;

@Entity
@Table(name = "todos")
public class TodoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String userName;
	private String description;
	private Date targetDate;
	private int horasEstimadas;
	private int prioridad;
	private boolean introducidaEnProximaSemana;

	public TodoEntity() {
		super();
	}
	
	public TodoEntity(String user, String desc, Date targetDate, int horasEstimadas, int prioridad, boolean introducido, boolean isDone) {
		super();
		this.userName = user;
		this.description = desc;
		this.targetDate = targetDate;
		this.horasEstimadas = horasEstimadas;
		this.prioridad = prioridad;
		this.introducidaEnProximaSemana = introducido;
	}

	public Todo toTodo() {
		return new Todo(this.id, this.userName, this.description, this.targetDate, this.horasEstimadas, this.prioridad, this.introducidaEnProximaSemana);
	}

	public void setUserName(String user) {
		this.userName = user;
	}
	
	public void cambiarIntroduccion() {
		Todo t = this.toTodo();
		t.cambiarIntroduccion();
		this.introducidaEnProximaSemana=t.isIntroducidaEnProximaSemana();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public int getHorasEstimadas() {
		return horasEstimadas;
	}

	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public boolean isIntroducidaEnProximaSemana() {
		return introducidaEnProximaSemana;
	}

	public void setIntroducidaEnProximaSemana(boolean introducidaEnProximaSemana) {
		this.introducidaEnProximaSemana = introducidaEnProximaSemana;
	}

	public String getUserName() {
		return userName;
	}
	
	
	
}