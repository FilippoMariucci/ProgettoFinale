package Utilities;



/**
//import Model.SpazioVariabili;
//import Repository.MeteoRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.logging.Logger;

public class MyRunner implements CommandLineRunner {
    private static final Logger logger= (Logger) LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private MeteoRepository meteoRepository;

    @Override

    public void run(String... args) throws Exception {
        logger.info("inizializer users");

        meteoRepository.save(new SpazioVariabili("3173435","it",278.71,279.82,
                279.26,275.98,"Milano"));


    }
}
*/