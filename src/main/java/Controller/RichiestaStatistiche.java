package Controller;


import Eccezioni.EccezioneStatistiche;
import Model.SpazioVariabili;
import Repository.MeteoRepository;
import Utilities.StatisticCalculator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.jar.JarOutputStream;

/**
 * classe che eredit da Richiesta e presenta metodi specifici per la generazione delle statistiche
 */
@SuppressWarnings("Unchecked")
public class RichiestaStatistiche extends Richiesta {
    private static final Logger logger= LoggerFactory.getLogger(RichiestaStatistiche.class);

    /**
     * costruttore con parametri
     * @Param meteoRepository è l'archivio dati su cui effettuare le ricerche
     * @Param filtro è un filtro di ricerca ricevuto nelle api
     */

    public RichiestaStatistiche(JSONObject filter,MeteoRepository meteoRepository){
        super(filter,meteoRepository);
    }

    /**
     * Effettuo l'overriding del metodo della superclasse
     * Ritorna la rispota in formato JSON all'utente
     */
    public JSONObject getResult()throws EccezioneStatistiche{
        if (fisrtParseRequest()){
            JSONArray risultato= new JSONArray();
            this.Risposta.put("code",0);
            this.Risposta.put("info","");

            for (Object cityIds :CityIDs){
                String cityid=(String) cityIds;
                logger.info(cityid);// giusto per controllare

                  if (this.type.equals("all")){
                                      for (String type:this.types){
                                          risultato.add(calcolaStatistiche(cityid,type));
                                      }
                                  }else {
                      risultato.add(calcolaStatistiche(cityid,this.type));
                  }

            }
            this.Risposta.put("risultato",risultato);
        }else {
            this.Risposta=Generarisposta(3,"File not ok",0L);
        }
return this.Risposta;
    }


    /**
     * Metodo che si occupa di costruire la risposta in formato JSON
     * da ritornare al chiamante
     * Effettua la query al repository
     * Istanzia un oggetto di StatisticCalculator performando i calcoli richiesti
     * sui dati estratti
     */

    private JSONObject calcolaStatistiche(String cityId,String type)throws EccezioneStatistiche{
        List<SpazioVariabili> spazioVariabilis=meteoRepository.trovaValori(cityId,this.Inizio,this.Fine);
        JSONObject risultatiPerCityId=new JSONObject();
        risultatiPerCityId.put("CityId",cityId);
        risultatiPerCityId.put("type",type);

        StatisticCalculator statisticCalculator=new StatisticCalculator();
        for (SpazioVariabili spazioVariabili:spazioVariabilis){
            statisticCalculator.addSpazioVaribili(getValori(spazioVariabili,type));
        }
        JSONObject data =new JSONObject();
        data.put("max",statisticCalculator.getMax());
        data.put("min",statisticCalculator.getMin());
        data.put("media",statisticCalculator.getMedia());
        data.put("varianza", statisticCalculator.getVarianza());
        risultatiPerCityId.put("data",data);
        return risultatiPerCityId;

    }

    }






