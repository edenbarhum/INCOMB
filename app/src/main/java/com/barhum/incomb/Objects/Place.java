package com.barhum.incomb.Objects;

import android.graphics.Bitmap;

import java.util.Date;
import java.util.List;

public class Place {

    private String location;
    private List<Bitmap> listOfPic;
    private String type;
    private PropertyDescription property;
    private List<Date> availability;
    private double price;
    private String generalDescription;
    private String availabilityOfBooking;
    private PlaceRules placeRules;

    public Place(String location, List<Bitmap> listOfPic, String type, PropertyDescription property, List<Date> availability, double price, String generalDescription, String availabilityOfBooking, PlaceRules placeRules) {
        this.location = location;
        this.listOfPic = listOfPic;
        this.type = type;
        this.property = property;
        this.availability = availability;
        this.price = price;
        this.generalDescription = generalDescription;
        this.availabilityOfBooking = availabilityOfBooking;
        this.placeRules = placeRules;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Bitmap> getListOfPic() {
        return listOfPic;
    }

    public void setListOfPic(List<Bitmap> listOfPic) {
        this.listOfPic = listOfPic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PropertyDescription getProperty() {
        return property;
    }

    public void setProperty(PropertyDescription property) {
        this.property = property;
    }

    public List<Date> getAvailability() {
        return availability;
    }

    public void setAvailability(List<Date> availability) {
        this.availability = availability;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }

    public void setGeneralDescription(String generalDescription) {
        this.generalDescription = generalDescription;
    }

    public String getAvailabilityOfBooking() {
        return availabilityOfBooking;
    }

    public void setAvailabilityOfBooking(String availabilityOfBooking) {
        this.availabilityOfBooking = availabilityOfBooking;
    }

    public PlaceRules getPlaceRules() {
        return placeRules;
    }

    public void setPlaceRules(PlaceRules placeRules) {
        this.placeRules = placeRules;
    }
}
