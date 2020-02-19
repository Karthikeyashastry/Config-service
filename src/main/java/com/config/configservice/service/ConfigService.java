package com.config.configservice.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.config.configservice.requests.Attributes;
import com.config.configservice.requests.Property;
import com.config.configservice.requests.Rule;
import com.config.configservice.entities.AttributesTable;
import com.config.configservice.entities.Properties;
import com.config.configservice.entities.Rules;
import com.config.configservice.repo.AttributesRepository;
import com.config.configservice.repo.PropertiesRepository;
import com.config.configservice.repo.RulesRepository;

@Service
public class ConfigService {

	@Autowired
	private PropertiesRepository propertiesRepo;

	@Autowired
	private AttributesRepository attributesRepo;

	@Autowired
	private RulesRepository rulesRepo;

	MessageDigest md;

	public ConfigService() {
		try {
			this.md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {

		}
	}

	public HashMap<String, String> getConfig(List<Attributes> attributes) {
		HashMap<String, String> properties = new HashMap<String, String>();
		List<Properties> lp = propertiesRepo.findByRuleName("default");
		for(Properties p : lp) {
			properties.put(p.getProperty(), p.getValue());
		}
		try {
			String value = computeHash(attributes);
			Rules r = rulesRepo.findByValue(value);
			lp = propertiesRepo.findByRuleName(r.getRulename());
			for(Properties p : lp) {
				properties.put(p.getProperty(), p.getValue());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return properties;
	}

	public String addAttributes(List<String> attributes) {
		for (String attribute : attributes) {
			AttributesTable a = new AttributesTable();
			a.setAttributeName(attribute);
			try {
				attributesRepo.save(a);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return "OK";
	}

	public String addProperties(List<Property> properties) {
		for (Property property : properties) {
			Properties p = new Properties();
			p.setProperty(property.getProperty());
			p.setValue(property.getValue());
			p.setRulename(property.getRulename());
			try {
				propertiesRepo.save(p);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return "OK";
	}

	public String addRules(List<Rule> rules) {
		for (Rule rule : rules) {
			Rules r = new Rules();
			r.setRulename(rule.getRule());
			String value = computeHash(rule.getAttributes());
			r.setValue(value);
			r.setPriority(rule.getPriority());
			rulesRepo.save(r);
		}
		return "OK";
	}

	public String computeHash(List<Attributes> attributes) {
		StringBuilder attr = new StringBuilder();
		for(Attributes attribute : attributes) {
			attr.append(attribute.getAttributeName().toLowerCase()+attribute.getAttributeValue().toLowerCase());
		}
		String parseAttribute = attr.toString();
		return DatatypeConverter.printHexBinary(md.digest(parseAttribute.getBytes()));
	}
}
