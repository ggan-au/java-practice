package LambdasLab;

public class Person {
    private Integer age;
    private String name;
    private Double height;

    public Person(String name, Integer age, Double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Double getHeight() {
        return height;
    }
}
