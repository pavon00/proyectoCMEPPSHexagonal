package com.CMEPPS.demo.db_driven_adapter.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CMEPPS.demo.db_driven_adapter.domain.TodoEntity;

public interface TodoRepository extends JpaRepository < TodoEntity, Long > {
    List < TodoEntity > findByUserName(String user);
}