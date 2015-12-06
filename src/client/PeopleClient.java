package client;

import java.util.List;

import introsde.assignment.soap.ws.PeopleService;
import introsde.assignment.soap.ws.People;
import introsde.assignment.soap.ws.Person;
import introsde.assignment.soap.ws.LifeStatus;

public class PeopleClient{
    public static void main(String[] args) throws Exception {
        PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        Person p = people.readPerson(1);
        // List<Person> pList = people.getPeopleList();
        

        //Method #2 Print a person (with id=1)

        System.out.println("Method #2: readPerson(1) ");
        System.out.println("Person id " + p.getIdPerson());
        System.out.println("Person's name " + p.getName());
        System.out.println("Person's lastname " + p.getLastname());
        System.out.println("Person's lifestatus: ");

        List<LifeStatus> lsList = p.getLifeStatus();
        for (LifeStatus ls : lsList) {
        	printLifeStatus(ls);
        }

        


        // System.out.println("Result ==> "+pList);
        // System.out.println("First Person in the list ==> "+pList.get(0).getName());
    }

    public static void printLifeStatus(LifeStatus ls) {
    	System.out.println("Measure name " + ls.getMeasure());
    	System.out.println("Value " + ls.getValue());
    }
}