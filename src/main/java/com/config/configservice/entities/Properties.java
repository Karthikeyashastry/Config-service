package com.config.configservice.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "properties", uniqueConstraints = @UniqueConstraint(columnNames = {"property","rulename"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Properties.findByRuleName",query = "from Properties p where p.rulename = :rulename")
public class Properties extends EntityWithUUID {
	@Column(name = "property")
	@NotNull
	private String property;
	
	@Column(name = "value")
	private String value;
	
	@Column(name = "rulename")
	private String rulename;
}
