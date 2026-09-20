package model;

public class App {

    private String name;
    private double price;
    private boolean containsViolence;
    private boolean containsNudity;

    public App(String name, double price,
               boolean containsViolence,
               boolean containsNudity) {

        this.name = name;
        this.price = price;
        this.containsViolence = containsViolence;
        this.containsNudity = containsNudity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isContainsViolence() {
        return containsViolence;
    }

    public void setContainsViolence(boolean containsViolence) {
        this.containsViolence = containsViolence;
    }

    public boolean isContainsNudity() {
        return containsNudity;
    }

    public void setContainsNudity(boolean containsNudity) {
        this.containsNudity = containsNudity;
    }
}