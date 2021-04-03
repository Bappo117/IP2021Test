package src.model;

//Abstract class for Suppliers

public abstract class Suppliers extends Objects{
    protected int power;

    public abstract int getPower();
    public abstract void setPower(int power);
    public abstract String getName();

    public abstract void totalProduction(int power, int hours);
}
