package Utilities;

import Service.StaticConfig;
import com.fasterxml.jackson.core.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
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
     * Istante temporale delle misurazioni, espresso in formato UNIX
     */
    private long Epoch;

    private String lang;
    /**
     * valore medio della temperatura
     */
    private double temp;
    /**
     * valore della temperatura percepita
     */
    private double tempPerc;
    /**
     * nome della città
     */
    private String nomeCitta;

    private static final Logger logger= LoggerFactory.getLogger(OpenWeatherParse.class);

    public OpenWeatherParse( String CityId) {
        this.CityId=CityId;
    }


    public String getCityId() {
        return CityId;
    }

    public long getEpoch() {
        return Epoch;
    }

    public String getLang() {
        return lang;
    }

    public double getTemp() {
        return temp;
    }

    public double getTempPerc() {
        return tempPerc;
    }

    public String getNomeCitta() {
        return nomeCitta;
    }

    public void parse(){
        JSONParser parser=new JSONParser();
        JSONObject obj=null;
        RestTemplate restTemplate= new RestTemplate();
        String result=restTemplate.getForObject(
                "http://api.openweathermap.org/data/2.5/weather?appid="+ StaticConfig.getApikey()+
                        "&lang=it&id="+this.CityId,String.class
        );
        logger.info(result);

        try {
            obj=(JSONObject) parser.parse(result);
            this.CityId=(String) obj.get("id");
            this.nomeCitta=(String) obj.get("name");
            this.Epoch=(Long)obj.get("dt");
            JSONObject main=(JSONObject) obj.get("main");
            this.temp=Double.parseDouble(main.get("temp").toString());
            this.tempPerc=Double.parseDouble(main.get("feels_like").toString());
        }catch (ParseException e){
            logger.error(e.toString());
        }
    }
}
