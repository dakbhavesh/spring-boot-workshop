# Spring Boot Workshop - Java Meetup - Ahmedabad

![Spring Boot User] (/images/spring-boot.png)

## Getting Started - Prerequisites

1. [JDK 8] (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) latest stable version installed
    * Make sure JAVA_HOME is pointing to JDK 8
2. Latest [Maven] (https://maven.apache.org/download.cgi) plugin installed
    * Make sure maven binaries path set in system path variable

Generate spring project through spring hosted web based quick starter service: [Spring Initializr] (http://start.spring.io/) 

## Application in less than 140 characters

## Auto Configuration & Sensible Defaults

Spring Boot auto configures majority portion of your application based on content of its classpath. Following annotation triggers auto-configuration of entire spring context.
    
     @EnableAutoConfiguration
     @SpringBootApplication = @EnableAutoConfiguration + @ComponentScan

**For example:** If spring-boot finds Apache DBCP jar in classpath it will enable connection pooling with defaults (). 
 
Exaustive set of configuration properties can be found [Here] (http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#common-application-properties)

## Integration testing with MockMVC
## Non-functional production services

**Production Endpoints**

[health](http://localhost:8585/health) - Information on whether application, db and dependent services are up along with disk usage

[info] (http://localhost:8585/info) - Applcation version and other arbitrary information

[logfile] (http://localhost:8585/logfile) - Application logs

[metrics] (http://localhost:8585/metrics) - Shows metrics information about current application

* System metrics
* Datasource metrics
* Cache metrics

[mappings] (http://localhost:8585/mappings) - collated list of all enpoints

[env] (http://localhost:8585/env) - Environment configuration properties

**Not so readable !! - Want to see them much prettier way**

## Production deployment - Installation as service on Linux

Spring Boot application can be easily started as Unix/Linux services. Below are the commands required in order to run application as service.

    sudo mkdir /var/run/sbapp
	sudo chown sbapp /var/run/sbapp

	sudo touch /var/log/sbapp.log
	sudo chown sbapp /var/log/sbapp.log

	sudo ln -s ~/spring-boot-workshop-0.0.1-SNAPSHOT.jar /etc/init.d/sbapp
	ls -l /etc/init.d/sbapp

	
