# Getting Started

Creation of DB:

	create user config with login superuser password 'config';
	CREATE DATABASE config WITH OWNER = postgres;
	GRANT ALL ON DATABASE config TO postgres;
	GRANT ALL ON DATABASE config TO config;
	GRANT TEMPORARY, CONNECT ON DATABASE config TO PUBLIC;


API :

localhost:8080/addProperties
	-H 'Content-Type: application/json'
	{
		"properties" : [
			{
				"property" : "welcomeMsg",
				"value" : "Welcome User",
				"rulename" : "default"
			},
			{
				"property" : "speedLimit",
				"value" : "40 km/hr",
				"rulename" : "default"
			},
			{
				"property" : "femaleRestriction",
				"value" : "No Restriction",
				"rulename" : "default"
			},
			{
				"property" : "welcomeMsg",
				"value" : "Welcome CA Employee",
				"rulename" : "ca"
			},
			{
				"property" : "femaleRestriction",
				"value" : "No female after 8",
				"rulename" : "ca"
			},
			{
				"property" : "welcomeMsg",
				"value" : "Welcome Broadcom Employee",
				"rulename" : "broadcom"
			},
			{
				"property" : "speedLimit",
				"value" : "No speed limit",
				"rulename" : "broadcom"
			}
			]
	}

localhost:8080/addRules

	-H 'Content-Type: application/json'
	{
	"rules" : [
				 {
				 	"rule" : "ca",
				 	"priority" : -1,
				 	"attributes" : [ {
				 		"attributeName" : "company",
				 		"attributeValue" : "ca"
				 	}]
				 },
				 {
				 	"rule" : "broadcom",
				 	"priority" : -1,
				 	"attributes" : [ {
				 		"attributeName" : "company",
				 		"attributeValue" : "ca"
				 	},
				 	{
				 		"attributeName" : "changed",
				 		"attributeValue" : "broadcom"
				 	}]
				 }
				]
	}

localhost:8080/addAttributes

	-H 'Content-Type: application/json'
	{
	"attributes" : ["company","user-agent","country","changed"]
	}

localhost:9080/getConfig

	-H 'Content-Type: application/json'
	{
	"attributes" : []
	}

Limitations:

	* The attributes should be in the same order as entered in rules to match.