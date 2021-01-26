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
        boolean running = true;

        while (running) {
            showMainMenu();
            int valg = Input.getInt("Indtast dit valg: ");
            switch (valg) {
                case (1):
                    showMembers();
                    System.out.println("\n");
                    break;

                case (3): {
                    cashierMessage();
                    System.out.println("\n");
                    break;

                }
                case (4): {
                    sendPaymentRequestToAll();
                    System.out.println("\n");
                    break;

                }
                case (5): {
                    showBalanceInfoAllMembers();
                    System.out.println("\n");
                    break;

                }
                case (6): {
                    showBadPayers();
                    System.out.println("\n");
                    break;

                }
                case (7): {
                    paySubscriptionForMember();
                    System.out.println("\n");
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
        System.out.println("4: send opkrævning af kontingent til alle medlemmer");
        System.out.println("5: udskriv saldo for for alle medlemmer");
        System.out.println("6: vis dårlige betalere");
        System.out.println("7: betal gæld for medlem");
        System.out.println("9: afslut");

    }

    private void showMembers() {
        List<Member> members = dbMembersMapper.showAllMembers();
        for (Member s : members) {
            System.out.println("medlemsnr " + s.getMnr() + ": " + s.getFornavn() + "  " + s.getEfternavn() + ", type: " + s.getMedlemstype());
        }
    }


//        man kunne sende en besked herfra - men man kunne også have det som en funktion i cashier-klassen.
//    må "domæne-klasser" ikke have nogle handlinger/initiativ? I Jons design ser det ud til at alt initiativ udgår fra UI.
//    der kunne f.eks. være et objekt der hed pizzabager. eller admin brugeren selv er vel også en slags objekt -
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
        List<Member> members = dbMembersMapper.showAllMembersWithBalance();
//        System.out.println(dbMembersMapper.getMemberBalance(5));
        for (Member m : members) {
           System.out.println("medlem nr. " + m.getMnr() + " skylder " + m.getBalance() + " kr.");
        }
    }

    private void showBadPayers() {
        List<Member> members = dbMembersMapper.showAllMembersWithBalance();
        for (Member m : members){
            if (m.getBalance()>0){
                System.out.println("medlem nr. " + m.getMnr() + " skylder " + m.getBalance() + " kr.");
            }
        }
    }

    private void paySubscriptionForMember() {
        int valg = Input.getInt("indtast medlemsnummer: ");
        int debt = dbMembersMapper.getMemberBalance(valg);
        System.out.println("medlem med nr. "+ valg + " skylder " + debt +" kr.");

        String valg2 = Input.getString("betal gæld? j/n: ");
        if(valg2.equalsIgnoreCase("j")){
            dbMembersMapper.payMemberDebt(valg);

            System.out.println("gælden er nu slettet i vores system");
        }
        else{
            System.out.println("vi betalte ikke nogen gæld.");
        }
    }
}
