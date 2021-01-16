package UI;

import Util.Input;

public class MainMenu {
    public void run(){
        showMainMenu();
        int valg= Input.getInt("Indtast dit valg: ");
        switch (valg){
            case (1):
                System.out.println("det rigtige valg");
                showMembers();
                break;

            case (9):
                System.out.println("vi lukker for i dag");

            default:
                System.out.println("du har tastet forkert.");

        }

    }



    public void showMainMenu(){
        System.out.println("**** Hovedmenu for svømmeklubben DELFINEN's ITSYSTEM ****");
        System.out.println("Du har følgende valmligheder:");
        System.out.println("1: vis medlemsliste");
        System.out.println("9: afslut");

    }

    private void showMembers() {
        DbMembersMapper.showAllMembers;



    }

}
