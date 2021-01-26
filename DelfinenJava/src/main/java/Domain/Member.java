package Domain;

import java.time.Year;

public class Member implements Observer {

    private int mnr;
    private String fornavn;
    private String efternavn;
    private MemberType medlemstype;
    private MemberActivityLevel engagement;
    private int aargang;

    private int balance;

    private int memberPayment;
    private Subscription annualSubscription;
    private String message;
    private Subject cashier;



    public Member(int mnr, String fornavn, String efternavn, MemberType medlemstype, MemberActivityLevel engagement, int aargang) {
        this.mnr = mnr;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.medlemstype = medlemstype;
        this.engagement = engagement;
        this.aargang = aargang;
    }

//    constructor til showAllMembersWithBalance
    public Member(int mnr, String fornavn, String efternavn, MemberType medlemstype, MemberActivityLevel engagement, int aargang, int balance) {
        this.mnr = mnr;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.medlemstype = medlemstype;
        this.engagement = engagement;
        this.aargang = aargang;
        this.balance = balance;
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


    public int getBalance() {
        return balance;
    }


//    public void setBalance(int balance) {
//        this.balance = balance;
//    }


    //    hvis vi overrider update-funktionen giver det cashier mulighed for både at sende beskeder og opkrævning ud fra samme interface

    public void update(String message) {
        this.message = message;
        System.out.println("medlem nr. " + mnr + " har fået beskeden: \"" + message.hashCode() + "\" fra kasseren. ");
    }

    public void update(Subscription newPayment) {
        this.annualSubscription = newPayment;
        calculateMyPayment();

    }

    public int getMemberPayment() {
        return memberPayment;
    }

    public int calculateAgeAtSubscriptionTime() {
        int year = Year.now().getValue();
        return year - aargang;
    }

    //    ville være oplagt at omregne til procent-rabat, så det er lettere at styre efter index
//    pt. bruger vi slet ikke det subscription-objekt der bliver sendt
    public void calculateMyPayment() {
//        if (medlemstype==) todo implementer enum til aktiv/passiv og brug det til at beregne pris
        if (calculateAgeAtSubscriptionTime() < 18) {
            memberPayment = 1000;
        }

        if (calculateAgeAtSubscriptionTime() >= 18) {
            memberPayment = 1600;
            if (calculateAgeAtSubscriptionTime() < 59) {
                memberPayment = 1200;
            }
        }

    }


}

