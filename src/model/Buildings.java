package src.model;

public class Buildings extends Consumers{

    int consumption = 200;
    int totalConsumption;

    public Buildings (int consumption,int hours,int numOfX){
        this.consumption = consumption;
        if(hours > 168) {
            this.hours = 168;
        }
        else this.hours = hours;
        this.numberOfX = numOfX;
    }


    public int getHours(){
        return hours;
    }
    public int getNumberOfX(){
        return numberOfX;
    }
    public int getConsumption(){
        return consumption;
    }

    public int getTotalConsumption() {
        return totalConsumption;
    }

    public void setHours(int hours){
        this.hours = hours;
    }
    public void setNumberOfX(int hours){
        this.hours = hours;
    }
    public void setConsumption(int hours){
        this.hours = hours;
    }

    public void setTotalConsumption(int totalConsumption) {
        this.totalConsumption = totalConsumption;
    }

    public void totalConsumption(int consumption, int hours, int numberOfX) {
        this.totalConsumption = this.consumption*this.hours*this.numberOfX;
    }


}
