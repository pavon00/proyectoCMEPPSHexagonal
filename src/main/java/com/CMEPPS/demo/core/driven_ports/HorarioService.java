
package com.CMEPPS.demo.core.driven_ports;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CMEPPS.demo.db_driven_adapter.domain.HorarioEntity;
import com.CMEPPS.demo.db_driven_adapter.jparepository.HorarioRepository;

@Service
public class HorarioService implements IHorarioService {

	@Autowired
	private HorarioRepository horarioRepository;

	@Override
	public List<HorarioEntity> getHorariosByUser(String user) {
		return horarioRepository.findByUserName(user);
	}

	@Override
	public Optional<HorarioEntity> getHorarioById(long id) {
		return horarioRepository.findById(id);
	}

	@Override
	public void updateHorario(HorarioEntity horario) {
		horarioRepository.save(horario);
	}

	@Override
	public void addHorario(String name, LocalDate fecha, boolean disponible, int horas, boolean isDone) {
		horarioRepository.save(new HorarioEntity(name, fecha, disponible, horas, isDone));
	}

	@Override
	public void deleteHorario(long id) {
		Optional<HorarioEntity> horario = horarioRepository.findById(id);
		if (horario.isPresent()) {
			horarioRepository.delete(horario.get());
		}
	}

	@Override
	public void saveHorario(HorarioEntity horario) {
		horarioRepository.save(horario);
	}
}
