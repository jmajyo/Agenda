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

    List<String> names = new LinkedList<>();
    List<String> phones = new LinkedList<>();




    public Control() {
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
                    showPersons();
                    break;
                case ADD:
                    addperson();
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

    private void showPersons() {
        //List<String> file_names = archivo.readFile("agenda_name.txt");
       // List<String> file_phones = archivo.readFile("agenda_phone.txt");
        //Person p = new Person();
       // for (int i = 0; i <file_names.size() ; i++) {
       //     p.setName(file_names.get(i));
       //     p.setPhone(file_phones.get(i));
       //     agenda.add(p);
       // }
        agenda.print();
    }

    void addperson(){
        System.out.print("Name: ");
        String name = Prompt.read();
        System.out.print("Phone: ");
        String phone = Prompt.read();
        Person persona = new Person(name, phone);
        agenda.add(persona);
        System.out.println("Saved new contact!");
        try {
            names.add(name);
            archivo.createFile("agenda_name.txt", names);
            phones.add(phone);
            archivo.createFile("agenda_phone.txt", phones);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
