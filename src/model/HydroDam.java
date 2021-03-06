package src.model;

//Creation of HydroDam object

public class HydroDam extends Suppliers{

    int power = 1000;
    int totalProduction;
    String name;

    public HydroDam (int power,int numOfX){
        this.power = power;
        this.numberOfX = numOfX;
        this.name = "waterdam";
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

    public int getTotalPower(){
        return power*numberOfX;
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

    public int getTotalProduction() {
        return totalProduction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return getPower() + " kW/H " + getNumberOfX() + " hydrodams";
    }

    @Override
    public void totalProduction(int power, int numOfX){
        this.totalProduction = this.power*this.numberOfX;
    }
}
