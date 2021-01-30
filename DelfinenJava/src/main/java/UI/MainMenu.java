package UI;

import Domain.*;
import Persistence.Database;
import Persistence.DbMembersMapper;
import Persistence.DbResultsMapper;
import Util.Input;

import java.util.ArrayList;
import java.util.List;


public class MainMenu {
    private final String USER = "testdb_user";
    private final String PASSWORD = "1234";
    private final String URL = "jdbc:mysql://localhost:3306/delfinen_db?serverTimezone=CET&useSSL=false";

    Database database = new Database(USER, PASSWORD, URL);

    DbMembersMapper dbMembersMapper = new DbMembersMapper(database);
    DbResultsMapper dbResultsMapper = new DbResultsMapper(database);

    public void run() {
        boolean running = true;

        while (running) {
            showMainMenu();

            int valg = Input.getInt("Indtast dit valg: ");
            switch (valg) {
                case (1):
                    showMemberDataMenu();
                    memberDataMenuLoop();
                    System.out.println("\n");
                    break;
                case (2): {
                    showMemberSubscriptionMenu();
                    showMemberSubscriptionMenuLoop();
                    System.out.println("\n");
                    break;
                }

                case (3): {
                    showResultsMenu();
                    resultsMenuLoop();
                    System.out.println("\n");
                    break;

                }
                case (4): {
                    sendPaymentRequestToAll();
                    System.out.println("\n");
                    break;

                }


                case (0):
                    System.out.println("vi lukker for i dag");
                    running = false;
                    break;

                default:
                    System.out.println("du har tastet forkert.");
                    running = false;
            }
        }

    }

    public void showMainMenu() {
        System.out.println("**** Hovedmenu for svømmeklubben DELFINEN's ITSYSTEM ****");
        System.out.println("Du har følgende valgmligheder:");

        System.out.println("1: medlemskartotek");
        System.out.println("2: medlemskontingent");
        System.out.println("3: svømmeresultater");
//        System.out.println("5: generer svømmeresultater");
        System.out.println("0: tilbage");
    }

    private void showMemberDataMenu() {
        System.out.println("\n");
        System.out.println("Menu - medlemskartotek");
        System.out.println("1: vis liste over alle medlemmer");
        System.out.println("2: opret nyt medlem");
        System.out.println("3: rediger oplysninger for eksisterende medlem");
        System.out.println("4: slet medlem fra databasen");
        System.out.println("0: tilbage");
    }

    private void memberDataMenuLoop() {

        int valg = Input.getInt("Indtast dit valg: ");
        System.out.println("\n");
        switch (valg) {
            case (1):
                showMembers();
                System.out.println("\n");
                break;
            case (2): {
                insertNewMember();
                System.out.println("\n");
                break;
            }
            case (0): {
                showMainMenu();
                break;
            }
            default:
                System.out.println("du har tastet forkert.");
                showMainMenu();
                break;
        }
    }

    private void showMemberSubscriptionMenu() {
        System.out.println("\n");
        System.out.println("Menu - medlemskontingent");
        System.out.println("1: varsel om ny kontingent-betaling til alle medlemmer");
        System.out.println("2: udsend opkrævning af kontingent til alle medlemmer");
        System.out.println("3: udskriv saldo for for alle medlemmer");
        System.out.println("4: vis dårlige betalere");
        System.out.println("5: betal gæld for medlem");
        System.out.println("0: afslut");
    }

    private void showMemberSubscriptionMenuLoop() {
        int valg = Input.getInt("Indtast dit valg: ");
        switch (valg) {
            case (1): {
                cashierMessage();
                System.out.println("\n");
                break;
            }
            case (2): {
                sendPaymentRequestToAll();
                System.out.println("\n");
                break;
            }
            case (3): {
                showBalanceInfoAllMembers();
                System.out.println("\n");
                break;
            }
            case (4): {
                showBadPayers();
                System.out.println("\n");
                break;
            }
            case (5): {
                paySubscriptionForMember();
                System.out.println("\n");
                break;
            }

            case (0): {
                showMainMenu();
                break;
            }

            default:
                System.out.println("du har tastet forkert.");
                showMainMenu();
                break;

        }

    }

    private void showResultsMenu() {
        System.out.println("\n");
        System.out.println("Menu - svømmeresultater");
        System.out.println("1: vis alle resultater");
        System.out.println("2: vis resultater fordelt på svømmedisciplin og distance");
        System.out.println("3: indtast nyt resultat");
        System.out.println("4: vis resultatlister for de enkelte discipliner");
        System.out.println("5: inviter svømmere med hurtigste tider");
        System.out.println("9:  - generer tilfældige resultater! -");
    }

    private void resultsMenuLoop() {

        int valg = Input.getInt("Indtast dit resultat-valg: ");
        System.out.println("\n");
        switch (valg) {
            case (1):
                System.out.println("\n");
                break;
            case (2): {
                System.out.println("\n");
                break;
            }
            case (3): {
                insertNewResult();
                System.out.println("\n");
                break;
            }
            case (4): {
                displayResultLists();
                System.out.println("\n");
                break;
            }
            case (5): {
                sendRequestToTopPerformers();
                System.out.println("\n");
                break;
            }


            case (9): {
                Resultsgenerator r = new Resultsgenerator();
                int valgDeltagere = Input.getInt("hvor mange resultater vil du have? ");
                List<Result> results = r.generateNewResults(valgDeltagere, 50);
                for (Result result : results) {
                    dbResultsMapper.insertNewResult(result);
                }
                break;

            }


            case (0): {
                showMainMenu();
                break;
            }
            default:
                System.out.println("du har tastet forkert.");
                showMainMenu();
                break;
        }
    }


    private void displayResultLists() {

        System.out.println("Svømmearter: ");
        System.out.println("1: Butterfly");
        System.out.println("2: Crawl");
        System.out.println("3: Rygcrawl");
        System.out.println("4: Brystsvømning");

        SwimmingStyle swimmingStyle = swimmingStyleFromInt(Input.getInt("indtast nummer: "));
        System.out.println("du valgte " + swimmingStyle.toString());


        System.out.println("Distance: ");
        System.out.println("1: Sprint - 50 m");
        System.out.println("2: Kort - 100 m");
        System.out.println("3: Mellemlang - 200 m");
        System.out.println("4: Lang - 800m");

        Distance distance = distanceFromInt(Input.getInt("indtast nummer: "));
        System.out.println("du valgte " + distance.toString());

        List<Result> results = dbResultsMapper.getResultList(swimmingStyle, distance);

        System.out.println("her har vi en liste over resultater for dit valg " + distance.toString() + " " + swimmingStyle.name());
        for (Result r : results) {
            System.out.println("svømmer nr. " + r.getMnr() + " svømmede på tiden " + r.getTime());
        }
    }

    public static Distance distanceFromInt(int distanceNr) {
        for (Distance s : Distance.values()) {
            if (s.getDistanceNr() == distanceNr) {
                return s;
            }
        }
        return null;
    }

    public static SwimmingStyle swimmingStyleFromInt(int styleNr) {
        for (SwimmingStyle s : SwimmingStyle.values()) {
            if (s.getStyleNr() == styleNr) {
                return s;
            }
        }
        return null;
    }

    private void sendRequestToTopPerformers() {
        System.out.println("Svømmearter: ");
        System.out.println("1: Butterfly");
        System.out.println("2: Crawl");
        System.out.println("3: Rygcrawl");
        System.out.println("4: Brystsvømning");

        SwimmingStyle swimmingStyle = swimmingStyleFromInt(Input.getInt("indtast nummer: "));
        System.out.println("du valgte " + swimmingStyle.toString());


        System.out.println("Distance: ");
        System.out.println("1: Sprint - 50 m");
        System.out.println("2: Kort - 100 m");
        System.out.println("3: Mellemlang - 200 m");
        System.out.println("4: Lang - 800m");

        Distance distance = distanceFromInt(Input.getInt("indtast nummer: "));
        System.out.println("du valgte " + distance.toString());

        List<Result> results = dbResultsMapper.getResultList(swimmingStyle, distance);
        List<Member> allMembers = dbMembersMapper.showAllMembers();

        int antalSvømmere = Input.getInt("hvor mange svømmere vil du invitere?");

        List<Member> invitedList = new ArrayList<>();

        int i = 0;
        int newInviteMnr;
        Member newInvite=null;

        while (invitedList.size() < antalSvømmere) {


//            sætter newInvite til det Member-objekt som der peges på fra Result-listen.
            newInviteMnr = results.get(i).getMnr();
            for (Member m : allMembers) {
                if (m.getMnr() == newInviteMnr)
                    newInvite = m;
            }
//            tjekker om det udvalgte er tilmeldt som konkurrence-svømmer
            if(newInvite.getMedlemstype()==MemberType.konkurrence) {
//            tjekker om den nye udvalgte allerede er i listen. HVis ikke tilføjes den. ellers ny omgang i løkken
                if (!invitedList.contains(newInvite)) {
                    invitedList.add(newInvite);

                }
            }
            i++;
        }
        System.out.println("Liste over de " + antalSvømmere + " hurtigste konkurrence-svømmere på "+ distance.getDistanceName()+" "+swimmingStyle+": ");
        for (Member m : invitedList) {
            System.out.println("medlem nr. " + m.getMnr() + ": " + m.getFornavn() + " " + m.getEfternavn());

        }

        String valgMail = Input.getString("Send invitation pr. mail? j/n:");
        if (valgMail.equalsIgnoreCase("j")){
            Trainer trainer = new Trainer(invitedList, "du inviteres hermed til konkurrence ("+ distance.getDistanceName()+" "+swimmingStyle+")");
            trainer.notifyInvited();
            for (Member m: invitedList){
//                man kunne implementere det med en stringbuilder message 1 og message 2 fra træner.
                System.out.print("kære "+ m.getFornavn() + " ");
                System.out.println(m.getMessage());
            }

        }


    }


    private void showMembers() {
        List<Member> members = dbMembersMapper.showAllMembers();
        for (Member s : members) {
            System.out.println("medlemsnr " + s.getMnr() + ": " + s.getFornavn() + "  " + s.getEfternavn() + ", type: " + s.getMedlemstype());
        }
    }

    private void insertNewMember() {
        //        (int mnr, String fornavn, String efternavn, MemberType medlemstype, MemberActivityLevel engagement, int aargang)
        String fornavn = Input.getString("Indtast fornavn: ");
        String efternavn = Input.getString("Indtast efternavn: ");

        String medlemstypeString = Input.getString("motionist/konkurrence?: ");
        MemberType medlemstype = MemberType.valueOf(medlemstypeString);

        String engagementString = Input.getString("aktiv/passiv?: ");
        MemberActivityLevel engagement = MemberActivityLevel.valueOf(engagementString);

        int aargang = Input.getInt("Indtast fødselsår: ");

        Member newMember = new Member(fornavn, efternavn, medlemstype, engagement, aargang);
        boolean succes = dbMembersMapper.insertNewMember(newMember);
        if (succes) {
            System.out.println("*************** " + newMember.getFornavn() + " er nu en uundværlig del af vores svømmeklub. *************** ");
        }

    }

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
        for (Member m : members) {
            if (m.getBalance() > 0) {
                System.out.println("medlem nr. " + m.getMnr() + " skylder " + m.getBalance() + " kr.");
            }
        }
    }

    private void paySubscriptionForMember() {
        int valg = Input.getInt("indtast medlemsnummer: ");
        int debt = dbMembersMapper.getMemberBalance(valg);
        System.out.println("medlem med nr. " + valg + " skylder " + debt + " kr.");

        String valg2 = Input.getString("betal gæld? j/n: ");
        if (valg2.equalsIgnoreCase("j")) {
            dbMembersMapper.payMemberDebt(valg);

            System.out.println("gælden er nu slettet i vores system");
        } else {
            System.out.println("vi betalte ikke nogen gæld.");
        }
    }

    private void insertNewResult() {

        int time = Input.getInt("indtast tid i sekunder");
        int mnr = Input.getInt("indtast medlemsnummer for resultatet");
        SwimmingStyle swimmingStyle = SwimmingStyle.valueOf(Input.getString("butterfly, crawl, rygcrawl, brystsvømning ?: "));
        Distance distance = Distance.valueOf(Input.getString("kort(50), mellemkort(100), mellemlang(200) eller lang(800)?: "));

        Result newResult = new Result(time, mnr, swimmingStyle, distance);
        dbResultsMapper.insertNewResult(newResult);
    }

}
