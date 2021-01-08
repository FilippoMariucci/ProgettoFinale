package Utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MeteoUtilities {

    /**
     * metedo che trasforma il risultato di timeStamp espressi in Unix in stringhe,formattando data e ora
     */

    protected String toDateSTR(long millisecondi){
        DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Calendar calendario=Calendar.getInstance();
        calendario.setTimeInMillis(millisecondi);
        return  dateFormat.format(calendario.getTime());

    }

    /**
     * Metodo che permette di costruire un JSONObject di risposta di default
     */

    protected JSONObject Generarisposta(int code,int info,int time){
        JSONObject risposta=new JSONObject();
        risposta.put("code",code);
        risposta.put("info",info);
        risposta.put("time",time);
        risposta.put("Risultato",new JSONArray());
        return risposta;
    }
}
