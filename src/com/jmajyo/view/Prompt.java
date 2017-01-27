package com.jmajyo.view;

import java.util.Scanner;

public class Prompt {
    public static void print(int numPerson){
        System.out.print("(" + numPerson + ")" + "> ");
    }

    public static String read() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

}
