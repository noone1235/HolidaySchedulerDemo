package com.chary.main.config;

import java.util.Map;
import java.util.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
@ConfigurationProperties(prefix = "quartz")
public class QuartzConfiguration {
	
	private Map<String, String> properties;

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	private Properties getAllProperties() {
		Properties prop = new Properties();
		prop.putAll(properties);
		return prop;
	}
	
	@Bean
	SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean scheduler= new SchedulerFactoryBean();
		scheduler.setQuartzProperties(getAllProperties());;
		scheduler.setWaitForJobsToCompleteOnShutdown(true);
		scheduler.setApplicationContextSchedulerContextKey("applicationContext");
		
		return scheduler;
	}
   

}
