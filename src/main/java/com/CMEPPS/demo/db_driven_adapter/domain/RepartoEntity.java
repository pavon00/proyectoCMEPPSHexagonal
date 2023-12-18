package com.CMEPPS.demo.db_driven_adapter.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.CMEPPS.demo.core.domain.Reparto;

@Entity
@Table(name = "repartos")
public class RepartoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String userName;
	private int horas;
	private long idTodo;
	private LocalDate fecha;

	@Transient
	private TodoEntity todo;

	public RepartoEntity() {
		super();
	}
	

	public RepartoEntity(String userName, LocalDate fecha, int horas, long idTodo, boolean isDone) {
		// TODO Auto-generated constructor stub
		super();
		this.userName = userName;
		this.fecha = fecha;
		this.horas = horas;
		this.idTodo = idTodo;
	}

	public Reparto toReparto() {
		return new Reparto(this.id, this.userName, this.fecha, this.horas, this.idTodo);
	}

	public void setUserName(String userName) {
		Reparto r = toReparto();
		r.setUserName(userName);
		this.userName = r.getUserName();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getHoras() {
		return horas;
	}


	public void setHoras(int horas) {
		this.horas = horas;
	}


	public long getIdTodo() {
		return idTodo;
	}


	public void setIdTodo(long idTodo) {
		this.idTodo = idTodo;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public TodoEntity getTodo() {
		return todo;
	}


	public void setTodo(TodoEntity todo) {
		this.todo = todo;
	}


	public String getUserName() {
		return userName;
	}
	
	

}
