package com.barhum.incomb.Objects;

public class PlaceRules {

    private boolean children;
    private boolean pets;
    private boolean smoking;
    private String additionRules;
    private boolean prePaid;
    private boolean insurance;

    public PlaceRules(boolean children, boolean pets, boolean smoking, boolean prePaid, boolean insurance) {
        this.children = children;
        this.pets = pets;
        this.smoking = smoking;
        this.prePaid = prePaid;
        this.insurance = insurance;
    }

    public boolean isChildren() {
        return children;
    }

    public void setChildren(boolean children) {
        this.children = children;
    }

    public boolean isPets() {
        return pets;
    }

    public void setPets(boolean pets) {
        this.pets = pets;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public String getAdditionRules() {
        return additionRules;
    }

    public void setAdditionRules(String additionRules) {
        this.additionRules = additionRules;
    }

    public boolean isPrePaid() {
        return prePaid;
    }

    public void setPrePaid(boolean prePaid) {
        this.prePaid = prePaid;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }
}
