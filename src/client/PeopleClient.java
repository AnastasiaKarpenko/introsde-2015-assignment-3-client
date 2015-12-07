package client;

import java.util.List;
import java.util.LinkedList;

import java.util.Random;

import introsde.assignment.soap.ws.*;




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
        System.out.println("  ");
        System.out.println("People number: "+pList.size());

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

    	//Method #4 Creating a new person with new life status (health profile)

    	Person createChuckNorris = new Person();
   
    	createChuckNorris.setName("Chuck");
    	createChuckNorris.setLastname("Norris");
    	createChuckNorris.setBirthdate("1945/01/01");
    	

    	LifeStatus weight = new LifeStatus();
		weight.setValue("78.9");
		weight.setMeasure("weight");
		
		LifeStatus height = new LifeStatus();
		height.setValue("172");
		height.setMeasure("height");
		
		
		createChuckNorris.getLifeStatus().add(weight);
		createChuckNorris.getLifeStatus().add(height);
	
    	int newId = people.createPerson(createChuckNorris);

    	createChuckNorris = people.readPerson(newId);
    	System.out.println("   ");
        System.out.println("METHOD #4: CREATING A NEW PERSON ");
    	printPersonDetails(createChuckNorris);
    	List<LifeStatus> lsList2 = createChuckNorris.getLifeStatus();
        	for (LifeStatus ls2 : lsList2) {
        		printLifeStatus(ls2);
        	}

    	System.out.println("  ");
    	pList = people.getPeopleList();
		System.out.println("People number before deleting the previousely created person: "+pList.size());

   	


    	//Method #5 Deleting a person
    	
		people.deletePerson(newId);
		System.out.println("   ");
		System.out.println("METHOD #5: DELETING A PREVIOUSELY CREATED PERSON ");
		pList = people.getPeopleList();
		System.out.println("People number after deleting the previousely created person: "+pList.size());
		
		//Method #6 readPersonHistory
		System.out.println("  ");
        System.out.println("METHOD #6: READING AND PRINTING HISTORY OF WEIGHT MEASURES FOR PERSON ID = 1");
        List<HealthMeasureHistory> hList = people.readPersonHistory(1, "weight");
        for (HealthMeasureHistory hist : hList) {
        	System.out.println("   ");
        	printMeasureHistory(hist);
        	
        }
	
        
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
        System.out.println("Person's birthdate: " + per.getBirthdate());
        
    }

    public static void printMeasureHistory(HealthMeasureHistory hist) {
    	System.out.println("Id of Measure History " + hist.getIdMeasureHistory());
        System.out.println("Measure name: " + hist.getMeasureName());
        System.out.println("Timestamp of the measure: " + hist.getTimestamp());
        System.out.println("Measure's value: " + hist.getValue());
        
    }







}