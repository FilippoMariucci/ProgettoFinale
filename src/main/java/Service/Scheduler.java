package Service;

import Controller.Configurations;
import Model.SpazioVariabili;
import Repository.MeteoRepository;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Scheduler {

    /**
     * @Autowired viene utilizzato poichè, essendo  MeteoRepository  un componente, esso viene
     * considerato come una classe la cui unica istanza viene gestita dal FrameWork
     */
    @Autowired
    MeteoRepository meteoRepository;

    @Autowired
    Configurations configurations;


    /**
     * @Autowired viene utilizzato poichè, essendo Configurations un componente, esso viene
     * considerato come una classe la cui unica istanza viene gestita dal FrameWork
     */

    @Scheduled(fixedRate = 30000)//3600000
    public void ConnectToOpenWeather() throws IOException, ParseException {

        final Logger logger = LoggerFactory.getLogger(Scheduler.class);
        JSONArray lista = configurations.getConfig();
        if (StaticConfig.getCallOpenWeather()) {
            for (Object city : lista) {
                logger.info("Recupero i dati di" + city.toString());
                SpazioVariabili spazioVariabili = new SpazioVariabili();
                spazioVariabili.getFromParse(city.toString());
                meteoRepository.save(spazioVariabili);
            }
        } else {
            logger.info("Chiamata ad OpenWeather non attiva");
        }
    }
}

