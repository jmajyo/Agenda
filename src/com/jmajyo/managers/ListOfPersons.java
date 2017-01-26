package com.jmajyo.managers;

import com.jmajyo.model.Person;

import java.util.LinkedList;

public class ListOfPersons {

    private LinkedList<Person> listOfPerson = new LinkedList();


    public ListOfPersons() {
    }

    public LinkedList<Person> getListOfPersons() {
        return listOfPerson;
    }

    public void setListOfPersons(LinkedList<Person> listOfPersons) {
        this.listOfPerson = listOfPersons;
    }
    public void add(Person person){
        this.listOfPerson.add(person);
    }
    public void delete(int position){
        this.listOfPerson.remove(position);
    }
    public void print(){
        if(listOfPerson.size() == 0)
        {
            System.out.println("No contacts");
        }
        for (Person person: listOfPerson) {
            System.out.println(listOfPerson.indexOf(person) + " - " + person.toString());
        }
    }
    public int NumberOfPersons(){
        return listOfPerson.size();
    }
}
