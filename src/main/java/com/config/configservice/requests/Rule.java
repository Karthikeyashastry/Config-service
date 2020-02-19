package com.config.configservice.requests;

import java.util.List;

import lombok.Data;

@Data
public class Rule {
	private String rule;
	
	private List<Attributes> attributes;
	
	private int priority;
}
