
package com.CMEPPS.demo.core.driven_ports;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CMEPPS.demo.db_driven_adapter.domain.RepartoEntity;
import com.CMEPPS.demo.db_driven_adapter.domain.TodoEntity;
import com.CMEPPS.demo.db_driven_adapter.jparepository.RepartoRepository;

@Service
public class RepartoService implements IRepartoService {

	@Autowired
	private RepartoRepository repartoRepository;

	@Override
	public List<RepartoEntity> getRepartosByUser(String user) {
		return repartoRepository.findByUserName(user);
	}

	@Override
	public Optional<RepartoEntity> getRepartoById(long id) {
		return repartoRepository.findById(id);
	}

	@Override
	public void updateReparto(RepartoEntity reparto) {
		repartoRepository.save(reparto);
	}

	@Override
	public void addReparto(String name, LocalDate fecha, int horas, long idTtodo, boolean isDone) {
		repartoRepository.save(new RepartoEntity(name, fecha, horas, idTtodo, isDone));
	}

	@Override
	public void deleteReparto(long id) {
		Optional<RepartoEntity> reparto = repartoRepository.findById(id);
		if (reparto.isPresent()) {
			repartoRepository.delete(reparto.get());
		}
	}

	@Override
	public void saveReparto(RepartoEntity reparto) {
		repartoRepository.save(reparto);
	}
}
