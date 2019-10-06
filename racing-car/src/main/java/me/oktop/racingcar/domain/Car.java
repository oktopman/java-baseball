package me.oktop.racingcar.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Car {

    private String name;
    private String distance = "";

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        this.distance += "-";
    }

    public void printDistance() {
        System.out.println(this.name + ": " + this.distance);
    }

}
