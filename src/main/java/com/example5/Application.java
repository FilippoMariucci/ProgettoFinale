package com.example5;

import Service.StaticConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;


@SpringBootApplication(scanBasePackages = {
		"Utilities","Repository","Model","Controller","Service","ApiUtente","Eccezioni"})
@EnableScheduling
//@EnableJpaRepositories("Repository")
//@EntityScan("Repository")

public class Application {


	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}




		/** Metodo eseguito alla fine dell'inizializzazione dell'applicativo da
		 * parte del framework Spring e prima del suo avvio (grazie all'annotazione @PostConstruct)
		 * Legge dal file application.properties, usando l'interfaccia Environment, le
		 * configurazioni fisse (non modificabili a runtime)
		 */
		@PostConstruct
		public void init(){
		StaticConfig.setApikey(env.getProperty("mmw.apikey"));
		StaticConfig.setOffset(Long.parseLong(env.getProperty("mmw.offset")));
		StaticConfig.setCallOpenWeather(Boolean.parseBoolean(env.getProperty("mmw.callopenweather")));


	}
	}



/**SchedulerInternet si1 = new SchedulerInternet("Task1");
 SchedulerInternet si2 = new SchedulerInternet("Task2");
 Timer t = new Timer();
 t.scheduleAtFixedRate(si1, 0, 5 * 1000);
 t.scheduleAtFixedRate(si2, 0, 1000);

 */
