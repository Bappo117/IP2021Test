package src.model;

//Creation of NPP object

public class NuclearPowerPlant extends Suppliers{

    int power = 500;
    int totalProduction;
    String name;

    public NuclearPowerPlant (int power, int numOfX){
        this.power = power;
        this.numberOfX = numOfX;
        this.name = "npp";
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

    public int getTotalPower(){
        return power*numberOfX;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setTotalProduction(int totalProduction) {
        this.totalProduction = totalProduction;
    }

    public String toString(){
        return getPower() + " kW/H " + getNumberOfX() + " power plants";
    }

    @Override
    public void totalProduction(int power, int numOfX) {
        this.totalProduction = this.power*this.numberOfX;
    }

}
