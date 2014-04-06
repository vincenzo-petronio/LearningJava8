package it.localhost.app.desktop.learningjava8.tutorial;

import it.localhost.app.desktop.learningjava8.common.Car;
import it.localhost.app.desktop.learningjava8.common.FakeData;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Tutorial Lambda Expressions
 */
public class Lambdas extends ATutorial {

    private List<String> cities = null;
    private List<Car> cars = null;
    private StringBuilder sb = null;

    public Lambdas() {
        this.cities = FakeData.getCities();
        this.cars = FakeData.getCars();
    }

    public void printCitiesOrderedAlpha() {
        sb = new StringBuilder();
        sb.append("### List of cities - Alphabetical order ###");
        sb.append("\n");
        sb.append("Before").append(": ");
        sb.append(Arrays.deepToString(this.cities.toArray()));

        // LAMBDA
        Collections.sort(this.cities, (a, b) -> b.compareTo(a));

        sb.append("\n");
        sb.append("After").append(": ");
        sb.append(Arrays.deepToString(this.cities.toArray()));
        sb.append("\n");

        System.out.println(sb.toString());
    }

    public void printCitiesOrderedLength() {
        sb = new StringBuilder();
        sb.append("### List of cities - Length order ###");
        sb.append("\n");
        sb.append("Before").append(": ");
        sb.append(Arrays.deepToString(this.cities.toArray()));

        // LAMBDA
        Collections.sort(this.cities, (a, b) -> b.length() - a.length());

        sb.append("\n");
        sb.append("After").append(": ");
        sb.append(Arrays.deepToString(this.cities.toArray()));
        sb.append("\n");

        System.out.println(sb.toString());
    }

    public void printCarsOrderedLength() {
        sb = new StringBuilder();
        sb.append("### List of cars - Length order ###");
        sb.append("\n");
        sb.append("Before").append(": ");
        sb.append(Arrays.deepToString(this.cars.toArray()));

        // Without LAMBDA
        Collections.sort(cars, (c1, c2) -> c1.compareTo(c2));

        sb.append("\n");
        sb.append("After (using compareTo override)").append(": ");
        sb.append(Arrays.deepToString(this.cars.toArray()));
        sb.append("\n");

        // With LAMBDA
        // Confronta prima Manufacturer, poi a parità di valori confronta Name.
        // N.B. Nuova keyword :: per passare riferimenti a metodi e costruttori!!!
        Collections.sort(cars, Comparator.comparing(Car::getManufacturer)
                .thenComparing(Car::getName));

        sb.append("After (using compareTo lexicographical)").append(": ");
        sb.append(Arrays.deepToString(this.cars.toArray()));
        sb.append("\n");
        //cars.forEach(c -> sb.append(c));

        System.out.println(sb.toString());
    }
}
