package src.model;

public class HydroDam extends Suppliers{

    int power = 1000;
    int totalProduction;

    public HydroDam (int power,int numOfX){
        this.power = power;
        this.numberOfX = numOfX;
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


    public void setHours(int hours){
        this.hours = hours;
    }
    public void setNumberOfX(int NumberOfX){
        this.numberOfX = NumberOfX;
    }
    public void setPower(int power){
        this.power = power;
    }

    public String toString(){
        return getPower() + " kW/H " + getNumberOfX() + " hydrodams";
    }

    @Override
    public void totalProduction(int power, int hours){
        this.totalProduction = this.power*this.hours;
    }
}
