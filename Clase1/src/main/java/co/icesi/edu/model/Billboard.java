package co.icesi.edu.model;

import java.io.Serializable;
import java.util.Comparator;

public class Billboard implements Serializable, Comparable<Billboard> {

    private double width;
    private double height;
    private boolean inUse;
    private String brand;

    private Billboard next;
    private Billboard before;

    public Billboard(double width, double height, boolean inUse, String brand) {
        this.width = width;
        this.height = height;
        this.inUse = inUse;
        this.brand = brand;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double calculateArea() {
        return width * height;
    }

    public void addBillboard(Billboard a) {
        Billboard current = this;
        boolean flag = false;
        while (current.next != null && !flag) {

            if (compareTo(a) <= 0 && current.next.compareTo(a) == 1) {
                a.setNext(current.next);
                current.next = a;
                flag = true;
            }

            current = current.next;
        }
        if (!flag) {
            current.next = a;
        }

    }

    public void setNext(Billboard a) {
        next = a;
    }

    @Override
    public int compareTo(Billboard o) {
        int ret = Double.compare(width, o.width);
        if (width > o.width) {
            return 1;
        } else if (width < o.width) {
            return -1;
        } else {
            return 0;
        }

    }

    public Billboard searchBillboard(Billboard a, Comparator<Billboard> c) {
        Billboard current = this;
        while (current != null) {
            if (c.compare(current, a) == 0) {
                return current;
            }
            current = current.next;
        }
        return current;
    }

}
