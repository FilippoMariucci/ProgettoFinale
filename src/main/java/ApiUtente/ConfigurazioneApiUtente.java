package ApiUtente;

import Controller.Configurations;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 *  Classe che mette in evidenza le API per le configurazioni e gestisce le chiamate effettuabili tramite:
 *  1)metodo HTTP GET per leggere le configurazioni attuali,
 *  2)metodo HTTP POST per modificare le configurazioni attuali.
 *   Utilizza la  classe Configurations per leggere o modificare le configurazioni.
 *   @RestController è l'annotazione utilizzata per definire i servizi web RESTful
 */

@RestController
public class ConfigurazioneApiUtente {

    private static final Logger logger= LoggerFactory.getLogger(ConfigurazioneApiUtente.class);

    @Autowired
    Configurations configurazioni;

    /**
     * @RequestMapping è l'annotazione usata per definire la Request URI per accedere
     * 	 * agli Endpoint REST
     */

    @RequestMapping(value = "/config")
    public JSONArray leggiconfigurazioni(){
        return configurazioni.getConfig();
    }


    /**
     * @RequestBody annotazione usata per definire il cnteuto del request body
     * @return
     */
    @RequestMapping(value = "/config",method = RequestMethod.POST)
    public JSONObject scriviConfigurazioni(@RequestBody String confgStr){
        try {
            /**
             * Verifico che il parsing è andato a buon fine,aggioro le configurazioni e le rendo nuovamente attive
             */
            JSONArray config=(JSONArray) new JSONParser().parse(confgStr);
            configurazioni.setConfig(config);
            return answer(0,"OK");

        }catch (ParseException e){
            // nel caso in cui ci sono stati problemi nel Parse risolvo qui i problemi

            logger.error(e.toString());
            return answer(1,e.toString());
        } catch (IOException e){
            //nel casoo ci siano problemi di I/O li risolvo qui

            logger.error(e.getMessage());
            return answer(2,e.toString());
        }

    }


    @SuppressWarnings("Unchecked")
    private JSONObject answer(int code,String info){
        JSONObject answer=new JSONObject();
        answer.put("code",code);
        answer.put("info",info);
        return answer;
    }


}
