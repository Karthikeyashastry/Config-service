package com.config.configservice.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rules")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Rules.findByValue",query = "from Rules r where r.value = :value")
public class Rules extends EntityWithUUID {
	@Column(name = "rulename", unique = true)
	private String rulename;
	
	@Column(name = "value")
	private String value;
	
	@Column(name = "priority")
	private int priority;

}
