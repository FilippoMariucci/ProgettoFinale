package com.example5;

import Model.SpazioVariabili;
import Repository.MeteoRepository;
import Service.SchedulerInternet;
import Service.SchedulerInternet;
import org.apache.catalina.webresources.war.Handler;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.HttpsURLConnection;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Optional;
import java.util.Scanner;
import java.util.Timer;



@SpringBootApplication(scanBasePackages = {
		"Utilities","Repository","Model","Controller","Service","ApiUtente"})

public class Application {

	public static void main(String[] args) throws IOException, ParseException {
		SpringApplication.run(Application.class, args);
		{


		}
	}
}


/**SchedulerInternet si1 = new SchedulerInternet("Task1");
 SchedulerInternet si2 = new SchedulerInternet("Task2");
 Timer t = new Timer();
 t.scheduleAtFixedRate(si1, 0, 5 * 1000);
 t.scheduleAtFixedRate(si2, 0, 1000);

 */
