package com.config.configservice.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.config.configservice.requests.AddAttributesRequest;
import com.config.configservice.requests.AddPropertiesRequest;
import com.config.configservice.requests.AddRulesRequest;
import com.config.configservice.requests.ConfigRequest;
import com.config.configservice.requests.Property;
import com.config.configservice.service.ConfigService;

@RestController
public class ConfigController {
	
	@Autowired
	ConfigService configService;
	
	@PostMapping(value = "/getConfig", consumes = {"application/json"})
	public HashMap<String, String> getConfig(@RequestBody ConfigRequest request, HttpServletRequest httpServletRequest) {
		return configService.getConfig(request.getAttributes());
	}
	
	@PostMapping(value = "/addAttributes",consumes = {"application/json"})
	public String addAttributes(@RequestBody AddAttributesRequest request,HttpServletRequest httpServletRequest) {
		String status = configService.addAttributes(request.getAttributes());
		return status;
	}
	
	@PostMapping(value = "/addProperties", consumes = {"application/json"})
	public String addProperties(@RequestBody AddPropertiesRequest request, HttpServletRequest httpServletRequest) {
		return configService.addProperties(request.getProperties());
	}
	
	@PostMapping(value = "/addRules", consumes = {"application/json"})
	public String addRules(@RequestBody AddRulesRequest request,HttpServletRequest httpServletRequest) {
		return configService.addRules(request.getRules());
	}
}
