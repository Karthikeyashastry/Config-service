package com.config.configservice.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.config.configservice.entities.Rules;

public interface RulesRepository extends CrudRepository<Rules, UUID> {
	Rules findByValue(@Param("value") String value);
}
