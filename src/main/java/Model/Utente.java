package Model;

public class Utente {
    private String nomeutente;
    private static double codiceutente=(int) Math.random();

    public Utente(String nomeutente,int codiceutente){
        this.nomeutente=nomeutente;
        this.codiceutente=codiceutente+1;
        codiceutente++;
    }

    public String getNomeUtente(){
        return nomeutente;
    }

    public double getCodiceutente(){
        return codiceutente;
    }

    public void setNomeutente(String nomeutente){
        this.nomeutente=nomeutente;
    }

    public void visualizza(){
        System.out.println("Il nome utente inserito è il seguente: "+nomeutente);
        System.out.println("Il codice assegnato a quest'ultimo e' "+codiceutente);
    }
}

