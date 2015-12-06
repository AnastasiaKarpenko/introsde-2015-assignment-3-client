package client;

import java.util.List;

import introsde.assignment.soap.ws.PeopleService;
import introsde.assignment.soap.ws.People;
import introsde.assignment.soap.ws.Person;
import introsde.assignment.soap.ws.LifeStatus;

import java.util.Random;

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
        printPersonDetails(p);

        List<LifeStatus> lsList = p.getLifeStatus();
        for (LifeStatus ls : lsList) {
        	printLifeStatus(ls);
        }

        //Method #3 Update person id = 1 (only first name)
    	Person newPerson = p;
    	Random rand = new Random();
    	newPerson.setName("Laura" + rand.nextInt());
    	people.updatePerson(newPerson);

    	newPerson = people.readPerson(1);
    	System.out.println("   ");
        System.out.println("METHOD #3: UPDATING PERSON WITH ID = 1 (the first name only) ");
    	printPersonDetails(newPerson);

    	//Method #4 Creating a new person 

    	Person createChuckNorris = new Person();
   
    	createChuckNorris.setName("Chuck");
    	createChuckNorris.setLastname("Norris");
    	createChuckNorris.setBirthdate("1945/01/01");
    	int newId = people.createPerson(createChuckNorris);

    	createChuckNorris = people.readPerson(newId);
    	System.out.println("   ");
        System.out.println("METHOD #4: CREATING A NEW PERSON ");
    	printPersonDetails(createChuckNorris);
    	
       
      

        
    }

    public static void printLifeStatus(LifeStatus ls) {
    	System.out.println("Person's lifestatus measure: ");
    	System.out.println("Measure name: " + ls.getMeasure());
    	System.out.println("Value: " + ls.getValue());

    }

    public static void printPersonDetails(Person per) {
    	System.out.println("Person id: " + per.getIdPerson());
        System.out.println("Person's name: " + per.getName());
        System.out.println("Person's lastname: " + per.getLastname());
        
    }
}