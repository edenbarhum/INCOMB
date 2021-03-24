package com.barhum.incomb.Objects;

public class PropertyDescription {

    private boolean bedroom;
    private boolean pool;
    private boolean chicken;
    private boolean wifi;
    private boolean bbq;
    private boolean sportEquipment;
    private boolean yogaEquipment;
    private boolean parkingSpot;
    private boolean AirConditioner;
    private boolean essentials;
    private boolean computers;
    private int amountOfGuest;

    public PropertyDescription(boolean bedroom, boolean pool, boolean chicken, boolean wifi, boolean bbq, boolean sportEquipment, boolean yogaEquipment, boolean parkingSpot, boolean airConditioner, boolean essentials, boolean computers, int amountOfGuest) {
        this.bedroom = bedroom;
        this.pool = pool;
        this.chicken = chicken;
        this.wifi = wifi;
        this.bbq = bbq;
        this.sportEquipment = sportEquipment;
        this.yogaEquipment = yogaEquipment;
        this.parkingSpot = parkingSpot;
        AirConditioner = airConditioner;
        this.essentials = essentials;
        this.computers = computers;
        this.amountOfGuest = amountOfGuest;
    }

    public boolean isBedroom() {
        return bedroom;
    }

    public void setBedroom(boolean bedroom) {
        this.bedroom = bedroom;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isChicken() {
        return chicken;
    }

    public void setChicken(boolean chicken) {
        this.chicken = chicken;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isBbq() {
        return bbq;
    }

    public void setBbq(boolean bbq) {
        this.bbq = bbq;
    }

    public boolean isSportEquipment() {
        return sportEquipment;
    }

    public void setSportEquipment(boolean sportEquipment) {
        this.sportEquipment = sportEquipment;
    }

    public boolean isYogaEquipment() {
        return yogaEquipment;
    }

    public void setYogaEquipment(boolean yogaEquipment) {
        this.yogaEquipment = yogaEquipment;
    }

    public boolean isParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(boolean parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public boolean isAirConditioner() {
        return AirConditioner;
    }

    public void setAirConditioner(boolean airConditioner) {
        AirConditioner = airConditioner;
    }

    public boolean isEssentials() {
        return essentials;
    }

    public void setEssentials(boolean essentials) {
        this.essentials = essentials;
    }

    public boolean isComputers() {
        return computers;
    }

    public void setComputers(boolean computers) {
        this.computers = computers;
    }

    public int getAmountOfGuest() {
        return amountOfGuest;
    }

    public void setAmountOfGuest(int amountOfGuest) {
        this.amountOfGuest = amountOfGuest;
    }
}
