package cn.tomandersen.java.reading.core_java.chapter05;

public class Manager extends Employee {
    private double bonus;

    // subclass constructor
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        this.bonus = 0;
    }

    // overload constructor
    public Manager(String name, double salary, int year, int month, int day, int bonus) {
        super(name, salary, year, month, day);
        this.bonus = bonus;
    }

    @Override
    // override method
    public double getSalary() {
        return super.getSalary() + this.bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
