package Controller;

import Repository.MeteoRepository;
import Utilities.MeteoUtilities;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public  abstract class Richiesta extends MeteoUtilities {

    private static final Logger logger = LoggerFactory.getLogger(Richiesta.class);

    /**
     * database su cui effettuare le varie ricerche
      */

    protected MeteoRepository meteoRepository;
    /**
     * Filtro ricevuto dalla richiesta dell'api
     */
 protected JSONObject filtro;

    /**
     * JSONObject utilizzato per costruire la nostra risposta
     */

    protected JSONObject Risposta;

    /**
     * JSONArray che conterrà tutti i vari CityIds
     */

    protected JSONArray CityIDs;

    /**
     * JSONObject che conterrà il periodo di ricerca richiesto dall'utente
     */

    private JSONObject Periodo;

    /**
     * istante di partenza per la ricerca ( UNIX)
     */
    protected Long Inizio;

    /**
     * istante di fine per la ricerca ( UNIX)
     */

    protected Long Fine;

    /**
     * Costrutore di default
     */

    public Richiesta(){}

    /**
     * Costruttore con paremetri MeteoRepository, Filtro
     */

    public Richiesta(MeteoRepository meteoRepository, JSONObject filtro){
        this.meteoRepository=meteoRepository;
        this.filtro=filtro;
        this.Risposta=new JSONObject();
    }


    /**
     *Metodo astratto che si occupa di costruire la risposta. il metodo sarà svolto nella sua sottoclasse
     */

    public abstract JSONObject getResult();

    /**
     *Metodo che si occupa di effettuare un primo parse dalla richesta
     */

    protected boolean fisrtParseRequest(){
        try {
            if((this.CityIDs = (JSONArray) this.filtro.get("cities")) == null)
                return false;
            if((this.Periodo= (JSONObject) this.filtro.get("period")) != null) {
                date2epoch();
            } else
                return false;

            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }


    private void date2epoch() {

        String from = (String) this.Periodo.get("from");
        String to = (String) this.Periodo.get("to");

        if ((from != null) && (to != null)) { // il parsing è riuscito

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                    .withZone(ZoneOffset.systemDefault());

            if ((Instant.from(fmt.parse(from)).toEpochMilli() / 1000) < (Instant.from(fmt.parse(to)).toEpochMilli()
                    / 1000)) {
                this.Inizio = Instant.from(fmt.parse(from)).toEpochMilli() / 1000;
                this.Fine = Instant.from(fmt.parse(to)).toEpochMilli() / 1000;

            } else {
                System.out.println("Intervallo non valido");
            }

        } else {
            System.out.println("Parametri di ricerca non validi");
        }
    }




}
