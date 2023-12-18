package com.CMEPPS.demo.db_driven_adapter.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CMEPPS.demo.db_driven_adapter.domain.RepartoEntity;

public interface RepartoRepository extends JpaRepository < RepartoEntity, Long > {
    List < RepartoEntity > findByUserName(String user);
}