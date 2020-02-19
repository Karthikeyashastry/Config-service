package com.config.configservice.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.config.configservice.entities.Properties;

public interface PropertiesRepository extends CrudRepository<Properties, UUID> {
	List<Properties> findByRuleName(@Param("rulename") String rulename);
}
