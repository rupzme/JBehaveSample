package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import sample.Stock;
import sample.rest.SimpleRestClient;

@Configuration
@ComponentScan("sample.jbehave.steps")
public class TestConfig {
	
	@Bean
	public Stock stock(){
		return new Stock();
	}
	
	@Bean
	public SimpleRestClient simpleRestClient(){
		return new SimpleRestClient();
	}

}
