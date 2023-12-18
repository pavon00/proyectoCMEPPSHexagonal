package com.CMEPPS.demo.core.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String userName;
	private String description;
	private Date targetDate;
	private int horasEstimadas;
	private int prioridad;
	private boolean introducidaEnProximaSemana;

	public Todo() {
		super();
	}

	public Todo(String user, String desc, Date targetDate, int horasEstimadas, int prioridad, boolean introducidaEnProximaSemana) {
		super();
		this.userName = user;
		this.description = desc;
		this.targetDate = targetDate;
		this.horasEstimadas = horasEstimadas;
		this.prioridad = prioridad;
		this.introducidaEnProximaSemana = introducidaEnProximaSemana;
	}

	public Todo(long id, String user, String desc, Date targetDate, int horasEstimadas, int prioridad , boolean introducidaEnProximaSemana) {
		super();
		this.id = id;
		this.userName = user;
		this.description = desc;
		this.targetDate = targetDate;
		this.horasEstimadas = horasEstimadas;
		this.prioridad = prioridad;
		this.introducidaEnProximaSemana = introducidaEnProximaSemana;
	}

	public void cambiarIntroduccion() {
		if (introducidaEnProximaSemana) {
			introducidaEnProximaSemana = false;
		} else {
			introducidaEnProximaSemana = true;
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	// devuelve true si esta clase tiene el atributo targetDate mayor a la fecha
	// actual
	public boolean esPendiente() {
		Date fechaActual = new Date();
		return this.targetDate.after(fechaActual);
	}

	public boolean isIntroducidaEnProximaSemana() {
		return introducidaEnProximaSemana;
	}

	public void setIntroducidaEnProximaSemana(boolean introducidaEnProximaSemana) {
		this.introducidaEnProximaSemana = introducidaEnProximaSemana;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "TODO: "+this.id;
	}

}