package src.model;

public class NuclearPowerPlant extends Suppliers{

    public NuclearPowerPlant (int power,int hours,int numOfX){
        this.power = power;
        this.hours = hours;
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

}
