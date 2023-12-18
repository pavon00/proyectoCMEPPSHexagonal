package com.CMEPPS.demo.db_driven_adapter.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.CMEPPS.demo.core.domain.Horario;

@Entity
@Table(name = "horarios")
public class HorarioEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String userName;
	private LocalDate fecha;
	private boolean disponible;
	private int horas;

	public HorarioEntity() {
		super();
	}

	public HorarioEntity(String userName, LocalDate fecha, boolean disponible, int horas, boolean isDone) {
		// TODO Auto-generated constructor stub
		super();
		this.userName = userName;
		this.fecha = fecha;
		this.horas = horas;
		this.disponible = disponible;
	}

	public Horario toHorario() {
		return new Horario(this.id, this.userName, this.fecha, this.disponible,this.horas);
	}

	public void cambiarDisponibilidad() {
		Horario h = this.toHorario();
		h.cambiarDisponibilidad();
		this.disponible = h.isDisponible();
	}

	public void setUserName(String loggedInUserName) {
		Horario h = this.toHorario();
		h.setUserName(loggedInUserName);
		this.userName = h.getUserName();
	}

	public int getHoras() {
		// TODO Auto-generated method stub
		return this.horas;
	}

	public void setHoras(int horas) {
		Horario h = toHorario();
		h.setHoras(horas);
		this.horas=h.getHoras();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getUserName() {
		return userName;
	}
	
	

}
