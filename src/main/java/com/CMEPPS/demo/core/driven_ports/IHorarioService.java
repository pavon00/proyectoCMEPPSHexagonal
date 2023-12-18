
package com.CMEPPS.demo.core.driven_ports;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.CMEPPS.demo.db_driven_adapter.domain.HorarioEntity;

public interface IHorarioService {

	List<HorarioEntity> getHorariosByUser(String user);

	Optional<HorarioEntity> getHorarioById(long id);

	void updateHorario(HorarioEntity horario);

	void addHorario(String name, LocalDate fecha, boolean disponible, int horas, boolean isDone);

	void deleteHorario(long id);

	void saveHorario(HorarioEntity horario);
}