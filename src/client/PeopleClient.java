package client;

import java.io.PrintWriter;

import java.util.List;
import java.util.LinkedList;

import java.util.Random;

import introsde.assignment.soap.ws.*;




public class PeopleClient{
	private static PrintWriter logWriter;

    public static void main(String[] args) throws Exception {
        PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        logWriter = new PrintWriter("logfile.txt", "UTF-8");
        Person p = people.readPerson(1);
	    
        
        
        //Method #1 Print all the people 
        logWriter.println("  ");
        logWriter.println("METHOD #1: PRINTING ALL THE PEOPLE ");
        List<Person> pList = people.getPeopleList();
        for (Person per : pList) {
        	logWriter.println("   ");
        	printPersonDetails(per);
        	List<LifeStatus> lsList = per.getLifeStatus();
        	for (LifeStatus ls : lsList) {
        		printLifeStatus(ls);
        	}
        }
        logWriter.println("  ");
        logWriter.println("People number: "+pList.size());

       //Method #2 Print a person (with id=1)
        logWriter.println("   ");
        logWriter.println("METHOD #2: READING THE PERSON WITH ID = 1 ");
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
    	logWriter.println("   ");
        logWriter.println("METHOD #3: UPDATING PERSON WITH ID = 1 (the first name only) ");
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
    	logWriter.println("   ");
        logWriter.println("METHOD #4: CREATING A NEW PERSON ");
    	printPersonDetails(createChuckNorris);
    	List<LifeStatus> lsList2 = createChuckNorris.getLifeStatus();
        	for (LifeStatus ls2 : lsList2) {
        		printLifeStatus(ls2);
        	}

    	logWriter.println("  ");
    	pList = people.getPeopleList();
		logWriter.println("People number before deleting the previousely created person: "+pList.size());


    	//Method #5 Deleting a person
    	
		people.deletePerson(newId);
		logWriter.println("   ");
		logWriter.println("METHOD #5: DELETING A PREVIOUSELY CREATED PERSON ");
		pList = people.getPeopleList();
		logWriter.println("People number after deleting the previousely created person: "+pList.size());
		
		
		//Method #6 Read person's measure History of one measure
		logWriter.println("  ");
        logWriter.println("METHOD #6: READING AND PRINTING HISTORY OF WEIGHT MEASURES FOR PERSON ID = 1");
        List<HealthMeasureHistory> hList = people.readPersonHistory(1, "weight");
        for (HealthMeasureHistory hist : hList) {
        	logWriter.println("   ");
        	printMeasureHistory(hist);
        	
        }
	
        //Method #7 Read all measure types
		logWriter.println("  ");
        logWriter.println("METHOD #7: READING AND PRINTING ALL MEASURE TYPES");
        List<MeasureDefinition> mhList = people.readMeasureTypes();
        for (MeasureDefinition mh : mhList) {
        	logWriter.println("   ");
        	printAllMeasureTypes(mh);
        	
        }

        // Method #8 Read value of measure type mid=1 

        HealthMeasureHistory hmh = people.readMeasureHistoryId(1);
		logWriter.println("  ");
        logWriter.println("METHOD #8: PRINTING THE VALUE OF A MEASURE TYPE WITH MID ");
        logWriter.println("Weight with mid = 1 of the person id = 1 has value: " + hmh.getValue());


		// Method #9 create a new measure 
        logWriter.println("  ");
        logWriter.println("METHOD #9: CREATE A NEW MEASURE (WEIGHT) AND UPDATE A HEALTH MEASURE HISTORY OF PERSON 1");
    	
    	HealthMeasureHistory newHMH = new HealthMeasureHistory();
    	newHMH.setValue("99");
    	HealthMeasureHistory newHMH2 = people.updatePersonHealthMeasureHistory(1, "weight", newHMH );
    	Person p1 = people.readPerson(1);
    	printPersonDetails(p1);

        List<LifeStatus> lsList3 = p1.getLifeStatus();
        for (LifeStatus ls3 : lsList3) {
        	printLifeStatus(ls3);
        }

        logWriter.println("  ");
        logWriter.println( "READING AND PRINTING HISTORY OF WEIGHT MEASURES FOR PERSON ID = 1");
        List<HealthMeasureHistory> hList2 = people.readPersonHistory(1, "weight");
        for (HealthMeasureHistory hist2 : hList2) {
        	logWriter.println("   ");
        	printMeasureHistory(hist2);
        	
        }

        logWriter.close();
    	
    }


    public static void printLifeStatus(LifeStatus ls) {
    	logWriter.println("Person's lifestatus measure: ");
    	logWriter.println("Measure name: " + ls.getMeasure());
    	logWriter.println("Value: " + ls.getValue());

    }

    public static void printPersonDetails(Person per) {
    	logWriter.println("Person id: " + per.getIdPerson());
        logWriter.println("Person's name: " + per.getName());
        logWriter.println("Person's lastname: " + per.getLastname());
        logWriter.println("Person's birthdate: " + per.getBirthdate());
        
    }

    public static void printMeasureHistory(HealthMeasureHistory hist) {
    	logWriter.println("Id of Measure History " + hist.getIdMeasureHistory());
        logWriter.println("Measure name: " + hist.getMeasureName());
        logWriter.println("Timestamp of the measure: " + hist.getTimestamp());
        logWriter.println("Measure's value: " + hist.getValue());
        
    }

    public static void printAllMeasureTypes(MeasureDefinition mh) {
    	logWriter.println("Measure type: " + mh.getMeasureName());
        
    }





}