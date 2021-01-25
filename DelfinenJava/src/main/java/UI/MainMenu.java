package UI;

import Domain.Cashier;
import Domain.Member;
import Domain.Subject;
import Domain.Subscription;
import Persistence.Database;
import Persistence.DbMembersMapper;
import Util.Input;

import java.util.List;


public class MainMenu {
    private final String USER = "testdb_user";
    private final String PASSWORD = "1234";
    private final String URL = "jdbc:mysql://localhost:3306/delfinen_db?serverTimezone=CET&useSSL=false";

    Database database = new Database(USER, PASSWORD, URL);

    DbMembersMapper dbMembersMapper = new DbMembersMapper(database);

    public void run() {
        showMainMenu();
        boolean running = true;

        while (running) {
            int valg = Input.getInt("Indtast dit valg: ");
            switch (valg) {
                case (1):
                    showMembers();
                    break;

                case (3): {
                    cashierMessage();
                    break;

                }
                case (4): {
                    sendPaymentRequestToAll();
                    break;

                }
                case (5): {
                    showBalanceInfoAllMembers();
                    break;

                }

                case (9):
                    System.out.println("vi lukker for i dag");

                default:
                    System.out.println("du har tastet forkert.");
                    running = false;

            }

        }

    }


    public void showMainMenu() {
        System.out.println("**** Hovedmenu for svømmeklubben DELFINEN's ITSYSTEM ****");
        System.out.println("Du har følgende valmligheder:");
        System.out.println("1: vis medlemsliste");
        System.out.println("3: varsel om ny kontingent-betaling til alle medlemmer");
        System.out.println("4: udskriv opkrævning af kontingent til alle medlemmer");
        System.out.println("5: udskriv saldo for kontingentbetaling for alle medlemmer");
        System.out.println("9: afslut");

    }

    private void showMembers() {
        List<Member> members = dbMembersMapper.showAllMembers();
        for (Member s : members) {
            System.out.println("medlemsnr " + s.getMnr() + ": " + s.getFornavn() + "  " + s.getEfternavn() + ", type: " + s.getMedlemstype());

        }


    }

//        man kunne sende en besked herfra - men man kunne også have det som en funktion i cashier-klassen.
//    må "domæne-klasser" ikke have nogle handlinger? der kunne f.eks. være et objekt der hed pizzabager. eller admin
//    brugeren selv er vel også en slags objekt -

    private void cashierMessage() {
        List<Member> members = dbMembersMapper.showAllMembers();
        Subject cashier = new Cashier(members);
        Cashier cashier1 = new Cashier(members);
        cashier1.setMessage("så er der kontingent.");

    }


    private void sendPaymentRequestToAll() {
        List<Member> members = dbMembersMapper.showAllMembers();

        Cashier cashier = new Cashier(members);
        cashier.setMessage("så er der kontingent.");

        Subscription newSubscriptionPayment = new Subscription(2021, "21-12-2021", 3000);
        dbMembersMapper.printNewAnnualSubscription(newSubscriptionPayment);
        for (Member m : members) {
            dbMembersMapper.insertMemberPayment(newSubscriptionPayment, m);
        }
        System.out.println("tak for kaffe! de ved sandelig godt hvad de skal have for en omgang svømning.");

    }

    private void showBalanceInfoAllMembers() {
        List<Member> members = dbMembersMapper.showAllMembers();
//        System.out.println(dbMembersMapper.getMemberBalance(5));
        for (Member m: members){
            int balance = dbMembersMapper.getMemberBalance(m.getMnr());
            m.setBalance(balance);
            System.out.println("medlem nr. "+ m.getMnr() + " skylder " + m.getBalance() + " kr.");
        }
    }
}
