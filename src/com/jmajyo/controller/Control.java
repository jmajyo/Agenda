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
        try{
            Initialize();
        }catch (Exception e)
        {
            //e.printStackTrace();
        }

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
                    LinkedList<Person> personasRescribir = agenda.getListOfPersons();
                    if(personasRescribir.size()== 0)
                    {
                        writtingInFile("","");
                    }else{
                    for (Person p:personasRescribir) {
                        writtingInFile(p.getName(),p.getPhone());
                    }}
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
    //coge lo que haya en el fichero de lectura y lo guarda en memoria, ademas se encarga de escribir otra vez en el archivo los
    //datos para que se guarden para la sieguiente vez.
    //TODO arreglar excepción cuando no hay archivos.
    public void Initialize() {
        List<String> file_names = archivo.readFile("agenda_name.txt");
        List<String> file_phones = archivo.readFile("agenda_phone.txt");
        if(file_names.size() == file_phones.size()){
            for (int i = 0; i <file_names.size() ; i++) {
                Person p = new Person();
                p.setName(file_names.get(i));
                p.setPhone(file_phones.get(i));
                agenda.add(p);
                //writtingInFile(p.getName(), p.getPhone());
            }
        }else{
            System.out.println("Someone is trying to fuck the aplication");
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
        //writtingInFile(name, phone);
    }

    private void writtingInFile(String name, String phone) {
        try {
            names.add(name);
            archivo.createFile("agenda_name.txt", names);
            phones.add(phone);
            archivo.createFile("agenda_phone.txt", phones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //TODO hacer que borre también de la lista de ficheros.
    void deleteperson(){
        System.out.println("Position to delete: ");

        try {
            String pos = Prompt.read();
            int position = Integer.parseInt(pos);
            if((position <= agenda.NumberOfPersons()) && position >=0)
            {
                agenda.delete(position);
                System.out.println("Delected contact!");
                /*LinkedList<Person> personasRescribir = agenda.getListOfPersons();
                for (Person p:personasRescribir) {
                    writtingInFile(p.getName(),p.getPhone());
                }*/
            }else{
                System.out.println("ERROR!");
            }
        }catch (Exception e)
        {
            System.out.println("ERROR!");
        }
    }
}
