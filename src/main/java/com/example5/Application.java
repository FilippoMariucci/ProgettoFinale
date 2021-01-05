package com.example5;

import Model.SpazioVariabili;
import Repository.MeteoRepository;
import Service.SchedulerInternet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.Timer;



@SpringBootApplication(scanBasePackages = {
		"Utilities","Repository","Model","Controller","Service"})



public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		{
			/*SchedulerInternet si1= new SchedulerInternet("Task1");
			SchedulerInternet si2=new SchedulerInternet("Task2");
			Timer t=new Timer();
			t.scheduleAtFixedRate(si1,0,5*1000);
			t.scheduleAtFixedRate(si2,0,1000);

		}
*/
		}
	}
}