package it.localhost.app.desktop.learningjava8.common;

/**
 * Person VO
 */
public class Person {

    private String name;
    private int age;
    private Car car;
    private String city;

    /**
     *
     * @param name String
     * @param age int
     * @param car Car
     * @param city String
     */
    public Person(String name, int age, Car car, String city) {
        this.name = name;
        this.age = age;
        this.car = car;
        this.city = city;
    }

    /**
     * Overload
     *
     * @param name String
     */
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
