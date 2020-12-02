package com.company;

public class Data {
    Data next;
    private int value;
    private String type;

    Data(int value, String type) {
        this.value = value;
        this.type = type;
    }

    void print(){
        System.out.println(this.type + " " + this.value);
    }

    int getValue() {
        return this.value;
    }

    String getType() {
        return this.type;
    }

}
