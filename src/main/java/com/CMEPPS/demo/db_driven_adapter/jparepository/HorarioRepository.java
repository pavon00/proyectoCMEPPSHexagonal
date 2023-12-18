package com.CMEPPS.demo.db_driven_adapter.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CMEPPS.demo.db_driven_adapter.domain.HorarioEntity;

public interface HorarioRepository extends JpaRepository < HorarioEntity, Long > {
    List < HorarioEntity > findByUserName(String user);
}