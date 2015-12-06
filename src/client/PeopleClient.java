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
	    
        
        
        //Method #1 Print all the people 
        System.out.println("  ");
        System.out.println("METHOD #1: PRINTING ALL THE PEOPLE ");
        List<Person> pList = people.getPeopleList();
        for (Person per : pList) {
        	System.out.println("   ");
        	printPersonDetails(per);
        	List<LifeStatus> lsList = per.getLifeStatus();
        	for (LifeStatus ls : lsList) {
        		printLifeStatus(ls);
        	}
        }

	    


        //Method #2 Print a person (with id=1)
        System.out.println("   ");
        System.out.println("METHOD #2: READING THE PERSON WITH ID = 1 ");
        System.out.println("Person id: " + p.getIdPerson());
        System.out.println("Person's name: " + p.getName());
        System.out.println("Person's lastname: " + p.getLastname());
        System.out.println("Person's lifestatus: ");

        List<LifeStatus> lsList = p.getLifeStatus();
        for (LifeStatus ls : lsList) {
        	printLifeStatus(ls);
        }

        


        
    }

    public static void printLifeStatus(LifeStatus ls) {
    	System.out.println("Measure name: " + ls.getMeasure());
    	System.out.println("Value: " + ls.getValue());

    }

    public static void printPersonDetails(Person per) {
    	System.out.println("Person id: " + per.getIdPerson());
        System.out.println("Person's name: " + per.getName());
        System.out.println("Person's lastname: " + per.getLastname());
        System.out.println("Person's lifestatus: ");
    }
}