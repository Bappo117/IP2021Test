package src.model;

//Abstract class for Consumers and Suppliers

public abstract class Objects {
    protected int hours;
    protected int numberOfX;

    public abstract int getHours();
    public abstract int getNumberOfX();
    public abstract void setHours(int hours);
    public abstract void setNumberOfX(int numberOfX);


}
