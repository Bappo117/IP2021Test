package src.model;

//Creation of WindFarm object

public class WindFarm extends Suppliers{

    int power = 1500;
    int totalProduction;
    String name;

    public WindFarm(int power, int numOfX){
        this.power = power;
        this.numberOfX = numOfX;
        this.name = "windturbine";
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
    public int getTotalProduction(){ return totalProduction; }


    public void setHours(int hours){
        this.hours = hours;
    }
    public void setNumberOfX(int NumberOfX){
        this.numberOfX = NumberOfX;
    }
    public void setPower(int power){
        this.power = power;
    }
    public void setTotalProduction(int totalProduction){ this.totalProduction = totalProduction; }
    public String getName() {
        return name;
    }

    public int getTotalPower(){
        return power*numberOfX;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return getPower() + " kW/H " + getNumberOfX() + " wind turbines";
    }

    @Override
    public void totalProduction(int power, int numOfX) {
        this.totalProduction = this.power*this.numberOfX;
    }

}
