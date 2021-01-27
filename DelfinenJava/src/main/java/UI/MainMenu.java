package UI;

import Domain.*;
import Persistence.Database;
import Persistence.DbMembersMapper;
import Persistence.DbResultsMapper;
import Util.Input;

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
        System.out.println("3: indsæt nyt resultat");
        System.out.println("4:  - generer nye resultater -");
        System.out.println("5: bestil ny doping - boosterpack");
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
