package com.spring.dto;

public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public Person name(String name) {
        this.name = name;
        return this;
    }
}
