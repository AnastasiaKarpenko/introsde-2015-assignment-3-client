
package introsde.assignment.soap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for readMeasureHistoryId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readMeasureHistoryId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="historyMeasureId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readMeasureHistoryId", propOrder = {
    "historyMeasureId"
})
public class ReadMeasureHistoryId {

    protected int historyMeasureId;

    /**
     * Gets the value of the historyMeasureId property.
     * 
     */
    public int getHistoryMeasureId() {
        return historyMeasureId;
    }

    /**
     * Sets the value of the historyMeasureId property.
     * 
     */
    public void setHistoryMeasureId(int value) {
        this.historyMeasureId = value;
    }

}
