package com.jmajyo.controller;

import com.jmajyo.managers.CommandParser;
import com.jmajyo.managers.Fichero;
import com.jmajyo.managers.ListOfPersons;
import com.jmajyo.model.Command;
import com.jmajyo.model.Person;
import com.jmajyo.view.Message;
import com.jmajyo.view.Prompt;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class Control {

    ListOfPersons agenda = new ListOfPersons();
    Fichero archivo = new Fichero();
    /*Para escribir en el fichero
    List<String> p = new LinkedList<>();
    String yo="hola";
    String yo1="hola1";
    String yo2="hola2";*/


    public Control() {
        /*p.add(yo);
        p.add(yo1);
        p.add(yo2);*/
        Message.title();

    }

    public void bucle() {
        boolean end = false;
        while (!end) {
            Prompt.print();
            String command = Prompt.read();
            Command com = CommandParser.parse(command);

            switch (com) {
                case QUIT:
                    Message.bye();
                    end = true;
                    break;
                case HELP:
                    Message.printHelp();
                    break;
                case LIST:
                    agenda.print();
                    break;
                case ADD:
                    addperson();
                    /*Para escribir en el fichero
                    try {
                        archivo.createFile("agenda.txt", p);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/
                    break;
                case DELETE:
                    deleteperson();
                    break;
                case UNKNOWN:
                    Message.unknown();
                    break;
            }
        }
    }

    void addperson(){
        System.out.print("Name: ");
        String name = Prompt.read();
        System.out.print("Phone: ");
        String phone = Prompt.read();
        Person persona = new Person(name, phone);
        agenda.add(persona);
        System.out.println("Saved new contact!");
    }

    void deleteperson(){
        System.out.println("Position to delete: ");

        try {
            String pos = Prompt.read();
            int position = Integer.parseInt(pos);
            if((position <= agenda.NumberOfPersons()) && position >=0)
            {
                agenda.delete(position);
                System.out.println("Delected contact!");
            }else{
                System.out.println("ERROR!");
            }
        }catch (Exception e)
        {
            System.out.println("ERROR!");
        }
    }
}
