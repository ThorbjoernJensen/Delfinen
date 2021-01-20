package UI;

import Domain.Cashier;
import Domain.Member;
import Domain.Subject;
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

                case (9):
                    System.out.println("vi lukker for i dag");

                default:
                    System.out.println("du har tastet forkert.");
                    running = false;

            }

        }

    }
        public void showMainMenu () {
            System.out.println("**** Hovedmenu for svømmeklubben DELFINEN's ITSYSTEM ****");
            System.out.println("Du har følgende valmligheder:");
            System.out.println("1: vis medlemsliste");
            System.out.println("9: afslut");

        }

        private void showMembers () {
            List<Member> members = dbMembersMapper.showAllMembers();
            for (Member s : members) {
                System.out.println("medlemsnr " + s.getMnr() + ": " + s.getFornavn() + "  " + s.getEfternavn() + ", type: " + s.getMedlemstype());

            }


        }

        private void cashierMessage () {
            List<Member> members = dbMembersMapper.showAllMembers();
            Subject cashier = new Cashier(members);
            Cashier cashier1 = new Cashier(members);
            cashier1.setMessage("så er der kontingent.");

        }

    }
