package Model;


import Utilities.OpenWeatherParse;

import javax.persistence.*;

@Entity
@Table(name = "spaziovariabili")
public class SpazioVariabili {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String CityId;
    private String lang;
    private double valMin;
    private double valMax;
    private double tempMed;
    private double tempPerc;
    private String nomeCitta;



    public SpazioVariabili(){}

    public SpazioVariabili(String cityId, String lang, double valMin, double valMax, double tempMed, double tempPerc, String nomeCitta) {
        this.CityId = cityId;
        this.lang = lang;
        this.valMin = valMin;
        this.valMax = valMax;
        this.tempMed = tempMed;
        this.tempPerc = tempPerc;
        this.nomeCitta = nomeCitta;
    }

    public String getCityId() {
        return CityId;
    }

    public void setCityId(String cityId) {
        this.CityId = cityId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public double getValMin() {
        return valMin;
    }

    public void setValMin(double valMin) {
        this.valMin = valMin;
    }

    public double getValMax() {
        return valMax;
    }

    public void setValMax(double valMax) {
        this.valMax = valMax;
    }

    public double getTempRe() {
        return tempMed;
    }

    public void setTempRe(double tempRe) {
        this.tempMed = tempRe;
    }

    public double getTempPerc() {
        return tempPerc;
    }

    public void setTempPerc(double tempPerc) {
        this.tempPerc = tempPerc;
    }

    public String getNomeCitta() {
        return nomeCitta;
    }

    public void setNomeCitta(String nomeCitta) {
        this.nomeCitta = nomeCitta;
    }


    /* rihiamo dal parse i valori e li assegno alle varibili attraverso i vari metodi get*/

    public void getFromParse(String CityId, String lang){
        OpenWeatherParse openWeatherParse=new OpenWeatherParse(CityId,lang);
        openWeatherParse.parse();
        this.CityId=openWeatherParse.getCityId();
        this.lang=openWeatherParse.getLang();
        this.tempMed=openWeatherParse.getTempMed();
        this.nomeCitta=openWeatherParse.getNomeCitta();
        this.valMax=openWeatherParse.getValMax();
        this.valMin=openWeatherParse.getValMin();
        this.tempPerc=openWeatherParse.getTempPerc();

    }
}
