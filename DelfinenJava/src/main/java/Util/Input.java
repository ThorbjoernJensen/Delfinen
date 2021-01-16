package Util;

import java.util.Scanner;

public class Input {
    public static String getString(String question){
        Scanner scanner = new Scanner(System.in);
        System.out.print(question);
        return scanner.nextLine();

    }
    public static int getInt(String question){
        return Integer.parseInt(getString(question));

    }
}
