package com.testinglaboratory.testingbasics.exercises;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Human {
    private String name;
    private String surname;

    public static Human getBartosz() {
        return Human.builder()
                .name("Bartosz")
                .surname("Górny")
                .build();
    }

}
