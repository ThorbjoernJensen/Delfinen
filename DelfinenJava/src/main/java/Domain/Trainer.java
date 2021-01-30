package Domain;

import java.util.List;

public class Trainer implements Subject {
//    denne liste er oplagt at knytte til en træner. i første omgang er det bare alle medlemmer der er tilknyttet "træner"
    private List<Member> members;

//    men vi laver også en constructor hvor træneren kun bliver instantieret med de medlemmer der er udvalgte.
    private List<Member> invited;

    public Trainer(List<Member> invited, String message) {
        this.invited = invited;
        this.message = message;
    }

    private String message = "";

    public Trainer(List<Member> members) {
        this.members = members;
    }



   public void setMessage(String message) {
        this.message = message;
        notifyObserver();
    }

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
            member.update(message);
        }
    }

//    Man kunne også sende en liste med de inviterede ud til alle - også de ikke inviterede
//    det ville være smart bare at lave et Event-objekt afsted og notify observers med det. Med tid, dato, sted, og type
    public void notifyInvited() {
        for (Member member : invited) {
            member.update(message);
        }
    }





}
