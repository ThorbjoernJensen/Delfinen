package Domain;

public class Subscriber {
    int mnr;
    String fornavn;
    String efternavn;

    public Subscriber(int mnr, String fornavn, String efternavn) {
        this.mnr = mnr;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
    }

    public int getMnr() {
        return mnr;
    }

    public void setMnr(int mnr) {
        this.mnr = mnr;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }
}
