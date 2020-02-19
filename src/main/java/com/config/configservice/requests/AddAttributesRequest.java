package com.config.configservice.requests;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AddAttributesRequest {
	private List<String> attributes;
}
