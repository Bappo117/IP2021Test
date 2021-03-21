package src.model;

public class Houses extends Consumers{

    public Houses (int consumption,int hours,int numOfX){
        this.consumption = consumption;
        if(hours > 168) {
            this.hours = 168;
        }
        else this.hours = hours;
        this.numberOfX = numOfX;
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

    public void setHours(int hours){
        this.hours = hours;
    }
    public void setNumberOfX(int numberOfX){
        this.numberOfX = numberOfX;
    }
    public void setConsumption(int consumption){
        this.consumption = consumption;
    }


}
