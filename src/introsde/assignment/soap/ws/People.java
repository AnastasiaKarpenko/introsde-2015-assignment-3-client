
package introsde.assignment.soap.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "People", targetNamespace = "http://ws.soap.assignment.introsde/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface People {


    /**
     * 
     * @return
     *     returns java.util.List<introsde.assignment.soap.ws.Person>
     */
    @WebMethod
    @WebResult(name = "people", targetNamespace = "")
    @RequestWrapper(localName = "getPeopleList", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.GetPeopleList")
    @ResponseWrapper(localName = "getPeopleListResponse", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.GetPeopleListResponse")
    @Action(input = "http://ws.soap.assignment.introsde/People/getPeopleListRequest", output = "http://ws.soap.assignment.introsde/People/getPeopleListResponse")
    public List<Person> getPeopleList();

    /**
     * 
     * @param personId
     * @return
     *     returns introsde.assignment.soap.ws.Person
     */
    @WebMethod
    @WebResult(name = "person", targetNamespace = "")
    @RequestWrapper(localName = "readPerson", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.ReadPerson")
    @ResponseWrapper(localName = "readPersonResponse", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.ReadPersonResponse")
    @Action(input = "http://ws.soap.assignment.introsde/People/readPersonRequest", output = "http://ws.soap.assignment.introsde/People/readPersonResponse")
    public Person readPerson(
        @WebParam(name = "personId", targetNamespace = "")
        int personId);

    /**
     * 
     * @param person
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "personId", targetNamespace = "")
    @RequestWrapper(localName = "updatePerson", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.UpdatePerson")
    @ResponseWrapper(localName = "updatePersonResponse", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.UpdatePersonResponse")
    @Action(input = "http://ws.soap.assignment.introsde/People/updatePersonRequest", output = "http://ws.soap.assignment.introsde/People/updatePersonResponse")
    public int updatePerson(
        @WebParam(name = "person", targetNamespace = "")
        Person person);

    /**
     * 
     * @param person
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "personId", targetNamespace = "")
    @RequestWrapper(localName = "createPerson", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.CreatePerson")
    @ResponseWrapper(localName = "createPersonResponse", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.CreatePersonResponse")
    @Action(input = "http://ws.soap.assignment.introsde/People/createPersonRequest", output = "http://ws.soap.assignment.introsde/People/createPersonResponse")
    public int createPerson(
        @WebParam(name = "person", targetNamespace = "")
        Person person);

    /**
     * 
     * @param personId
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "deletedPersonId", targetNamespace = "")
    @RequestWrapper(localName = "deletePerson", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.DeletePerson")
    @ResponseWrapper(localName = "deletePersonResponse", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.DeletePersonResponse")
    @Action(input = "http://ws.soap.assignment.introsde/People/deletePersonRequest", output = "http://ws.soap.assignment.introsde/People/deletePersonResponse")
    public int deletePerson(
        @WebParam(name = "personId", targetNamespace = "")
        int personId);

    /**
     * 
     * @param personId
     * @param measureType
     * @return
     *     returns java.util.List<introsde.assignment.soap.ws.HealthMeasureHistory>
     */
    @WebMethod
    @WebResult(name = "healthMeasure", targetNamespace = "")
    @RequestWrapper(localName = "readPersonHistory", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.ReadPersonHistory")
    @ResponseWrapper(localName = "readPersonHistoryResponse", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.ReadPersonHistoryResponse")
    @Action(input = "http://ws.soap.assignment.introsde/People/readPersonHistoryRequest", output = "http://ws.soap.assignment.introsde/People/readPersonHistoryResponse")
    public List<HealthMeasureHistory> readPersonHistory(
        @WebParam(name = "personId", targetNamespace = "")
        int personId,
        @WebParam(name = "measureType", targetNamespace = "")
        String measureType);

}
