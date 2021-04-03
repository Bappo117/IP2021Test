package src.model;

//Creation of SolarFarm object

public class SolarFarm extends Suppliers{

    int power = 750;
    int totalProduction;
    String name;

    public SolarFarm (int power, int numOfX){
        this.power = 750;
        this.numberOfX = numOfX;
        this.name = "solarpanel";
    }


    public int getHours() {
        return hours;
    }
    public int getNumberOfX() {
        return numberOfX;
    }
    public int getPower() {
        return power;
    }

    public int getTotalProduction() {
        return totalProduction;
    }

    public void setHours(int hours){
        this.hours = hours;
    }
    public void setNumberOfX(int NumberOfX){
        this.numberOfX = NumberOfX;
    }
    public void setPower(int power){
        this.power = power;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalProduction(int totalProduction) {
        this.totalProduction = totalProduction;
    }

    public String toString(){
        return getPower() + " kW/H " + getNumberOfX() + " solar panels";
    }

    @Override
    public void totalProduction(int power, int numOfX) {
        this.totalProduction = this.power*this.numberOfX;
    }

}
