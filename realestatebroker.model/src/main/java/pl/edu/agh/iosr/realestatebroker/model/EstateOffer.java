package pl.edu.agh.iosr.realestatebroker.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by grzegorz on 2015-04-26.
 */
public class EstateOffer implements Serializable {

    private Integer id;
    private String title;
    private User owner;
    private EstateType estateType;
    private String description;
    private Integer totalArea;
    private Integer livingArea;
    private Integer frontYardArea;
    private Integer backYardArea;
    private Integer numberOfBedrooms;
    private Integer numberOfFloors;
    private Integer floorNumber;
    private boolean separateKitchen;
    private Integer garageForCars;
    private Date creationTime;
    private Date validUntilDate;
    private int ownerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public EstateType getEstateType() {
        return estateType;
    }

    public void setEstateType(EstateType estateType) {
        this.estateType = estateType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Integer totalArea) {
        this.totalArea = totalArea;
    }

    public Integer getLivingArea() {
        return livingArea;
    }

    public void setLivingArea(Integer livingArea) {
        this.livingArea = livingArea;
    }

    public Integer getFrontYardArea() {
        return frontYardArea;
    }

    public void setFrontYardArea(Integer frontYardArea) {
        this.frontYardArea = frontYardArea;
    }

    public Integer getBackYardArea() {
        return backYardArea;
    }

    public void setBackYardArea(Integer backYardArea) {
        this.backYardArea = backYardArea;
    }

    public Integer getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(Integer numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public boolean isSeparateKitchen() {
        return separateKitchen;
    }

    public void setSeparateKitchen(boolean separateKitchen) {
        this.separateKitchen = separateKitchen;
    }

    public Integer getGarageForCars() {
        return garageForCars;
    }

    public void setGarageForCars(Integer garageForCars) {
        this.garageForCars = garageForCars;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getValidUntilDate() {
        return validUntilDate;
    }

    public void setValidUntilDate(Date validUntilDate) {
        this.validUntilDate = validUntilDate;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
}
