package com.config.configservice.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "attributestable")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttributesTable extends EntityWithUUID {
	@Column(name = "attributename",unique = true)
	@NotNull
	private String attributeName;
}
