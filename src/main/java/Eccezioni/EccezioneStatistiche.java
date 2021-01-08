package Eccezioni;

public class EccezioneStatistiche extends Exception {

    public static final long serialVersion=3L;

    public EccezioneStatistiche(){
        super();
    }

    public EccezioneStatistiche(String messaggio){
        super(messaggio);
    }
}
