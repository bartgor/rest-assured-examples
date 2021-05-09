package com.testinglaboratory.testingbasics.exercises;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Toy {

    private String make;
    private String name;
    private String color;
    private String material;

    @Override
    public String toString() {
        return "Hello my name is: " + name + " my colour is " + color + " I was made of: " + material;
    }

}
