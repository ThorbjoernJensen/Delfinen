package Domain;

import java.util.List;

public class Cashier implements Subject {
    private List<Member> members;

    public Cashier(List<Member> members) {
        this.members = members;
    }

    //    i første omgang bare en simpel kasser, der sender en besked ud.
    String message = "";

    //dette kunne være en ny opkrævning, men også en rykker
    //kan der være en kasse hvor observere kan kigge ned i? (og skal kassen være hos kasseren - eller skal han bare tjekke
    public void setMessage(String message) {
        this.message = message;
    }


//    det er vel ikke helt sådan at vi skal have oprettet en medlemsliste - ved at de enkelte objekter selv tilmelder sig.
    @Override
    public void registerObserver(Member m) {
        members.add(Member m);

    }

    @Override
    public void removeObserver(Member m) {

    }

    @Override
    public void notifyObserver() {
        for (Member member : members) {
            member.update(message);
        }

    }


}
