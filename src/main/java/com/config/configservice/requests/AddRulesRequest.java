package com.config.configservice.requests;

import java.util.List;

import lombok.Data;

@Data
public class AddRulesRequest {
	List<Rule> rules;
}
