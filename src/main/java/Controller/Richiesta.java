package Controller;

import Eccezioni.EccezioneStatistiche;
import Eccezioni.TimeTravelerExeption;
import Model.SpazioVariabili;
import Repository.MeteoRepository;
import Utilities.MeteoUtilities;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.InvalidParameterException;
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
     * tipologia di grandezza richiesta
     */
    protected String type;

    /**
     * JSONArray che conterrà tutti i vari CityIds
     */

    protected JSONArray CityIDs;

    /**
     * JSONObject che conterrà il periodo di ricerca richiesto dall'utente
     */

    private JSONObject Periodo;

    /**
     * istante di partenza per la ricerca (UNIX)
     */
    protected Long Inizio;

    /**
     * istante di fine per la ricerca (UNIX)
     */

    protected Long Fine;

    /**
     * array contenente  la possibile grandezza
     */
    protected String[] types = { "temperature"};


    /**
     * Costrutore di default
     */

    public Richiesta(){}

    /**
     * Costruttore con paremetri MeteoRepository, Filtro
     */

    public Richiesta(JSONObject  filter,MeteoRepository meteoRepository){
        this.meteoRepository=meteoRepository;
        this.filtro=filter;
        this.Risposta=new JSONObject();
    }


    /**
     *Metodo astratto che si occupa di costruire la risposta. il metodo sarà svolto nella sua sottoclasse
     */

    public abstract JSONObject getResult() throws EccezioneStatistiche;

    /**
     *Metodo che si occupa di effettuare un primo parse dalla richesta
     */

    protected boolean fisrtParseRequest(){
        try {
            if((this.CityIDs = (JSONArray) this.filtro.get("CityIDS")) == null)
                return false;
            if((this.Periodo= (JSONObject) this.filtro.get("period")) != null) {
                date2epoch();
            } else
                return false;

            if ((this.type=(String) this.filtro.get("type"))==null)
                return false;

            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }


    private void date2epoch() throws TimeTravelerExeption {

        String Inizio = (String) this.Periodo.get("Inizio");
        String Fine = (String) this.Periodo.get("Fine");

        if ((Inizio != null) && (Fine != null)) { // il parsing è riuscito

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                    .withZone(ZoneOffset.systemDefault());

            if ((Instant.from(fmt.parse(Inizio)).toEpochMilli() / 1000) < (Instant.from(fmt.parse(Fine)).toEpochMilli()
                    / 1000)) {
                this.Inizio = Instant.from(fmt.parse(Inizio)).toEpochMilli() / 1000;
                this.Fine = Instant.from(fmt.parse(Fine)).toEpochMilli() / 1000;

            } else {
                throw new TimeTravelerExeption("Intervallo non Valido");
            }

        } else {
           throw new InvalidParameterException("Parametri di ricerca non valide");
        }
    }

    protected Double getValori(SpazioVariabili spazioVariabili,String type){
        return spazioVariabili.getTempRe();
    }



}
