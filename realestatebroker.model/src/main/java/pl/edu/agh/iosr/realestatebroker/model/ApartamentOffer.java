package pl.edu.agh.iosr.realestatebroker.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by grzegorz on 2015-04-26.
 */
public class ApartamentOffer implements Serializable {
    private Integer id;
    private String title;
    private User owner;
    private String description;
    private Integer totalArea;
    private Integer livingArea;
    private Integer numberOfBedrooms;
    private boolean separateKitchen;
    private Integer floorNumber;
    private Integer numberOfFloorsInTheBuilding;
    private Date creationTime;
    private Date validUntilDate;

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

    public Integer getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(Integer numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public boolean isSeparateKitchen() {
        return separateKitchen;
    }

    public void setSeparateKitchen(boolean separateKitchen) {
        this.separateKitchen = separateKitchen;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getNumberOfFloorsInTheBuilding() {
        return numberOfFloorsInTheBuilding;
    }

    public void setNumberOfFloorsInTheBuilding(Integer numberOfFloorsInTheBuilding) {
        this.numberOfFloorsInTheBuilding = numberOfFloorsInTheBuilding;
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
}
