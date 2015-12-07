
package introsde.assignment.soap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updatePersonHealthMeasureHistoryResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updatePersonHealthMeasureHistoryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="healthMeasureHistoryObject" type="{http://ws.soap.assignment.introsde/}healthMeasureHistory" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updatePersonHealthMeasureHistoryResponse", propOrder = {
    "healthMeasureHistoryObject"
})
public class UpdatePersonHealthMeasureHistoryResponse {

    protected HealthMeasureHistory healthMeasureHistoryObject;

    /**
     * Gets the value of the healthMeasureHistoryObject property.
     * 
     * @return
     *     possible object is
     *     {@link HealthMeasureHistory }
     *     
     */
    public HealthMeasureHistory getHealthMeasureHistoryObject() {
        return healthMeasureHistoryObject;
    }

    /**
     * Sets the value of the healthMeasureHistoryObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link HealthMeasureHistory }
     *     
     */
    public void setHealthMeasureHistoryObject(HealthMeasureHistory value) {
        this.healthMeasureHistoryObject = value;
    }

}
