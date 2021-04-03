package src.model;

//Abstract class for Consumers

public abstract class Consumers extends Objects {
    protected int consumption;
    protected int totalConsumption;

    public abstract int getConsumption();
    public abstract void setConsumption(int consumption);
    public abstract String getName();

    public abstract void totalConsumption(int consumption, int hours, int numberOfX);

}