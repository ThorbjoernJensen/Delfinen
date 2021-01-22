package Domain;

public class Member implements Observer {
    private String message;
    private Subject cashier;


    private int mnr;
    private String fornavn;
    private String efternavn;
    private MemberType medlemstype;
    private int aargang;



    private int annualSubscription;
    private int myPayment;



    public Member(int mnr, String fornavn, String efternavn, MemberType medlemstype, int aargang) {
        this.mnr = mnr;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.medlemstype = medlemstype;
        this.aargang = aargang;
            }

//            constructor til at implementere observer pattern
    public Member(int mnr, String fornavn, String efternavn, MemberType medlemstype, Subject cashier, int aargang) {
        this.mnr = mnr;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.medlemstype = medlemstype;
        this.aargang = aargang;
        this.cashier = cashier;
        cashier.registerObserver(this);

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
    public MemberType getMedlemstype() {
        return medlemstype;
    }

    public void setMedlemstype(MemberType medlemstype) {
        this.medlemstype = medlemstype;
    }

    public int getAargang() {
        return aargang;
    }

    public void setAargang(int aargang) {
        this.aargang = aargang;
    }

    //    hvis vi overrider update-funktionen giver det cashier mulighed for både at sende beskeder og opkrævning ud fra samme interface

    public void update(String message) {
        this.message = message;
        System.out.println("medlem nr. " + mnr  + " har fået beskeden: \"" + message.hashCode() + "\" fra kasseren. ");
    }

    public void update(Subscription newPayment) {
        this.annualSubscription = annualSubscription;
        calculateMyPayment();
    }

    public void calculateMyPayment(){


    }
}
