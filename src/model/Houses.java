package src.model;

//Creation of Houses object

public class Houses extends Consumers{

    int consumption = 50;
    int totalConsumption;
    String name;

    public Houses (int consumption,int hours,int numOfX){
        this.consumption = consumption ;
        if(hours > 168) {
            this.hours = 168;
        }
        else this.hours = hours;
        this.numberOfX = numOfX;
        this.name = "house";
    }


    public int getHours() {
        return hours;
    }
    public int getNumberOfX() {
        return numberOfX;
    }
    public int getConsumption() {
        return consumption;
    }

    public int getTotalConsumption() {
        return totalConsumption;
    }

    public void setHours(int hours){
        this.hours = hours;
    }
    public void setNumberOfX(int numberOfX){
        this.numberOfX = numberOfX;
    }
    public void setConsumption(int consumption){
        this.consumption = consumption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalConsumption(int totalConsumption) {
        this.totalConsumption = totalConsumption;
    }

    @Override
    public String toString(){
        return getConsumption() + " kW/H " + getHours() + " hrs " + getNumberOfX() + " houses";
    }

    @Override
    public void totalConsumption(int consumption, int hours, int numberOfX) {
        this.totalConsumption = this.consumption*this.hours*this.numberOfX;
    }


}
