
package pl.edu.agh.iosr.realestatebroker.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ownerId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="estateType" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="totalArea" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="livingArea" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="frontYardArea" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="backYardArea" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="numberOfBedrooms" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="numberOfFloors" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="floorNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="garageForCars" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="separateKitchen" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "title",
    "ownerId",
    "estateType",
    "description",
    "totalArea",
    "livingArea",
    "frontYardArea",
    "backYardArea",
    "numberOfBedrooms",
    "numberOfFloors",
    "floorNumber",
    "garageForCars",
    "separateKitchen"
})
@XmlRootElement(name = "estateInfo")
public class EstateInfo {

    @XmlElement(required = true)
    protected String title;
    protected int ownerId;
    protected int estateType;
    @XmlElement(required = true)
    protected String description;
    protected int totalArea;
    protected int livingArea;
    protected int frontYardArea;
    protected int backYardArea;
    protected int numberOfBedrooms;
    protected int numberOfFloors;
    protected int floorNumber;
    protected int garageForCars;
    protected boolean separateKitchen;

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the ownerId property.
     * 
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the value of the ownerId property.
     * 
     */
    public void setOwnerId(int value) {
        this.ownerId = value;
    }

    /**
     * Gets the value of the estateType property.
     * 
     */
    public int getEstateType() {
        return estateType;
    }

    /**
     * Sets the value of the estateType property.
     * 
     */
    public void setEstateType(int value) {
        this.estateType = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the totalArea property.
     * 
     */
    public int getTotalArea() {
        return totalArea;
    }

    /**
     * Sets the value of the totalArea property.
     * 
     */
    public void setTotalArea(int value) {
        this.totalArea = value;
    }

    /**
     * Gets the value of the livingArea property.
     * 
     */
    public int getLivingArea() {
        return livingArea;
    }

    /**
     * Sets the value of the livingArea property.
     * 
     */
    public void setLivingArea(int value) {
        this.livingArea = value;
    }

    /**
     * Gets the value of the frontYardArea property.
     * 
     */
    public int getFrontYardArea() {
        return frontYardArea;
    }

    /**
     * Sets the value of the frontYardArea property.
     * 
     */
    public void setFrontYardArea(int value) {
        this.frontYardArea = value;
    }

    /**
     * Gets the value of the backYardArea property.
     * 
     */
    public int getBackYardArea() {
        return backYardArea;
    }

    /**
     * Sets the value of the backYardArea property.
     * 
     */
    public void setBackYardArea(int value) {
        this.backYardArea = value;
    }

    /**
     * Gets the value of the numberOfBedrooms property.
     * 
     */
    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    /**
     * Sets the value of the numberOfBedrooms property.
     * 
     */
    public void setNumberOfBedrooms(int value) {
        this.numberOfBedrooms = value;
    }

    /**
     * Gets the value of the numberOfFloors property.
     * 
     */
    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    /**
     * Sets the value of the numberOfFloors property.
     * 
     */
    public void setNumberOfFloors(int value) {
        this.numberOfFloors = value;
    }

    /**
     * Gets the value of the floorNumber property.
     * 
     */
    public int getFloorNumber() {
        return floorNumber;
    }

    /**
     * Sets the value of the floorNumber property.
     * 
     */
    public void setFloorNumber(int value) {
        this.floorNumber = value;
    }

    /**
     * Gets the value of the garageForCars property.
     * 
     */
    public int getGarageForCars() {
        return garageForCars;
    }

    /**
     * Sets the value of the garageForCars property.
     * 
     */
    public void setGarageForCars(int value) {
        this.garageForCars = value;
    }

    /**
     * Gets the value of the separateKitchen property.
     * 
     */
    public boolean isSeparateKitchen() {
        return separateKitchen;
    }

    /**
     * Sets the value of the separateKitchen property.
     * 
     */
    public void setSeparateKitchen(boolean value) {
        this.separateKitchen = value;
    }

}
