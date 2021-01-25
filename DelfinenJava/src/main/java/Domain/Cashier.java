package Domain;

import java.util.List;

public class Cashier implements Subject {
    private List<Member> members;

    //    i første omgang bare en simpel kasser, der sender en besked ud.
    private String message = "";
    private Subscription newPayment;


//    hvorfor skal vi sende en liste med når vi instantierer?
    public Cashier(List<Member> members) {
        this.members = members;
    }

    public Subscription getNewPayment() {
        return newPayment;
    }

    public void setNewPayment(Subscription newPayment) {
        this.newPayment = newPayment;
        notifyObserver();
    }

    //dette kunne være en ny opkrævning, men også en rykker
    //kan der være en kasse hvor observere kan kigge ned i? (og skal kassen være hos kasseren - eller skal han bare tjekke
    public void setMessage(String message) {
        this.message = message;
        notifyObserver();
    }

    public void setSubscription(Subscription newPayment) {
        this.newPayment = newPayment;
        notifyObserver();
    }


//    det er vel ikke helt sådan at vi skal have oprettet en medlemsliste - ved at de enkelte objekter selv tilmelder sig.
    @Override
    public void registerObserver(Member m) {
        members.add(m);

    }

    @Override
    public void removeObserver(Member m) {
        members.remove(m);

    }

    @Override
    public void notifyObserver() {
        for (Member member : members) {
            member.update(newPayment);
        }

    }


}
