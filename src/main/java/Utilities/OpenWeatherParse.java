package Utilities;

import com.fasterxml.jackson.core.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Scanner;

public class OpenWeatherParse {
    /**
     * ID della città
     */
    private String CityId;


    /**
     * valore minimo di temperatura
     */
    private double valMin;
    /**
     * valore massimo della temperatura
     */
    private double valMax;

    /**
     * valore medio della temperatura
     */
    private double tempMed;
    /**
     * valore della temperatura percepita
     */
    private double tempPerc;
    /**
     * nome della città
     */
    private String nomeCitta;

    public OpenWeatherParse (){}

    public OpenWeatherParse(String CityId) {
        this.CityId = CityId;
    }

    /**
     *
     *  ID della città su cui effettuare la richiesta a OpenWeatherMap
     */


    public String getCityId(){ return CityId;}
    public double getValMin() {
        return valMin;
    }

    public double getValMax() {
        return valMax;
    }

    public double getTempMed() {
        return tempMed;
    }

    public double getTempPerc() {
        return tempPerc;
    }

    public String getNomeCitta() {
        return nomeCitta;
    }





    public void parse() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj=null;
        RestTemplate restTemplate =new RestTemplate(); // oggetto che consumerà un' API REST
        String result = restTemplate.getForObject(
                "http://api.openweathermap.org/data/2.5/weather?id="+this.CityId+"&lang=it&appid=acff9fc7b20e0ff3ebb1f1615f76abb1",String.class);

        System.out.println(result); // per  vedere se stampa qualcosa sulla console

        /* richiamo l'url con valori dati dall'utente e salvo il contenuto in result*/
        try {
            /* passo i dati contenunti in result in variabili specificando la forma del JSON*/

            obj=(JSONObject) parser.parse(result);
            this.nomeCitta=(String) obj.get("name");
            this.CityId = (String) obj.get("id");
            JSONObject main =(JSONObject) obj.get("main");
            this.tempMed=Double.parseDouble(main.get("temp").toString());
            this.tempPerc=Double.parseDouble(main.get("feels_like").toString());
            this.valMin=Double.parseDouble(main.get("temp_min").toString());
            this.valMax=Double.parseDouble(main.get("temp_max").toString());

            // System.out.println("temperatura reale:"+this.tempRe);

        }
        /*Signals that an error has been reached unexpectedly while parsing.*/
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    }

