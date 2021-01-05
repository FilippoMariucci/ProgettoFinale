/*package Service;

import Model.SpazioVariabili;
import Repository.MeteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    /**
     * @Autowired viene utilizzato poichè, essendo  MeteoRepository  un componente, esso viene
     * considerato come una classe la cui unica istanza viene gestita dal FrameWork
     */

  /*  @Autowired
    MeteoRepository meteoRepository;


    /**
     * @Autowired viene utilizzato poichè, essendo Configurations un componente, esso viene
     * considerato come una classe la cui unica istanza viene gestita dal FrameWork
     */


   /* @Scheduled(fixedRate = 10000)
    public void ConnectToOpenWeather() {
        SpazioVariabili m1 = new SpazioVariabili();
        m1.getFromParse("5134295","it");
        meteoRepository.save(m1);
        SpazioVariabili m2 = new SpazioVariabili();
        m2.getFromParse("3173435", "it");
        meteoRepository.save(m2);


    }
}
*/