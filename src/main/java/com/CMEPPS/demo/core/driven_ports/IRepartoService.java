
package com.CMEPPS.demo.core.driven_ports;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.CMEPPS.demo.db_driven_adapter.domain.RepartoEntity;
import com.CMEPPS.demo.db_driven_adapter.domain.TodoEntity;

public interface IRepartoService {

	List<RepartoEntity> getRepartosByUser(String user);

	Optional<RepartoEntity> getRepartoById(long id);

	void updateReparto(RepartoEntity reparto);

	void addReparto(String name, LocalDate fecha, int horas, long idTodo, boolean isDone);

	void deleteReparto(long id);

	void saveReparto(RepartoEntity reparto);
}