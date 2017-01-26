package com.jmajyo.view;

public class Message {
    public static void printHelp(){
        System.out.println(
                " __    __   _______  __      .______    __  \n" +
                "|  |  |  | |   ____||  |     |   _  \\  |  | \n" +
                "|  |__|  | |  |__   |  |     |  |_)  | |  | \n" +
                "|   __   | |   __|  |  |     |   ___/  |  | \n" +
                "|  |  |  | |  |____ |  `----.|  |      |__| \n" +
                "|__|  |__| |_______||_______|| _|      (__) \n" +
                "                                            ");
        System.out.println(
                "(Q)UIT \t\t\t - Salir \n" +
                "(H)ELP\t\t\t - Muestra la ayuda\n" +
                "(L)IST\t\t\t - Muestra la lista de contactos incluida la posicion en la que estan guardados\n" +
                "(A)DD\t\t\t - Añade un nuevo contacto a la lista\n" +
                "(D)ELETE\t\t - Borra un contacto de la lista (introduciendo la posición)\n");
    }
    public static void title(){
        System.out.println("Bienvenido a la agenda telefónica.");
    }

    public static void bye() {
        System.out.println("Hasta la próxima!!");
    }

    public static void unknown() {
        System.out.println("Comando no reconocido. Si necesita ayuda presione 'H' o 'help'");
    }
}
