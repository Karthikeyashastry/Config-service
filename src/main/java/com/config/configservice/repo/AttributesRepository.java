package com.config.configservice.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.config.configservice.entities.AttributesTable;

public interface AttributesRepository extends CrudRepository<AttributesTable, UUID>{

}
