package it.localhost.app.desktop.learningjava8.common;

import java.util.Arrays;
import java.util.List;

/**
 * Fake Data
 */
public class FakeData {

    private final static List<String> cities = Arrays.asList("Rome", "Milan",
            "New York", "Nashville", "Bangkok", "Cairo", "Istanbul", "London",
            "Tokyo");

    private final static List<Car> cars = Arrays.asList(new Car("FIAT", "Punto"),
            new Car("Toyota", "Supra"), new Car("Toyota", "RAV4"), new Car("Ford", "Ka"),
            new Car("Renault", "5 Turbo"), new Car("Mercedes", "Classe SLS AMG"),
            new Car("Pagani", "Zonda R"), new Car("Alfa Romeo", "156"),
            new Car("Ford", "Focus"), new Car("Lamborghini", "Murcielago"));

    private final static List<Integer> numbers = Arrays.asList(
            1, 12, 5, 6, 7, 87, 44, 45, 22, 78, 99, 90, 79, 64, 45, 91, 82, 73,
            22, 6, 3, 60, 85);

    public static List<String> getCities() {
        return cities;
    }

    public static List<Car> getCars() {
        return cars;
    }

    public static List<Integer> getNumbers() {
        return numbers;
    }

}
