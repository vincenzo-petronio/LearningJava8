package it.localhost.app.desktop.learningjava8.tutorial;

import it.localhost.app.desktop.learningjava8.common.Car;
import it.localhost.app.desktop.learningjava8.common.FakeData;
import it.localhost.app.desktop.learningjava8.common.Person;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Tutorial Streams
 */
public class Streams extends ATutorial {

    private List<Integer> numbers = null;
    private List<Car> cars;
    private List<String> cities;
    private List<Person> persons;
    private StringBuilder sb = null;

    public Streams() {
        this.numbers = FakeData.getNumbers();
        this.cars = FakeData.getCars();
        this.cities = FakeData.getCities();
        this.persons = FakeData.getPersons();
    }

    public void printNumbersFiltered(int findme) {
        sb = new StringBuilder();
        sb.append("### List of numbers - Filtered ###");
        sb.append("\n");
        sb.append("Before").append(": ");
        sb.append(Arrays.deepToString(this.numbers.toArray()));

        sb.append("\n");
        sb.append("Try to find ").append(Integer.toString(findme)).append(": ");

        // FILTER
        long founded = numbers.stream().filter(n -> n.equals(findme)).count();

        sb.append(Long.toString(founded)).append(" values...").append("\n");
        System.out.println(sb.toString());
    }

    public void printNumbersParallelFiltered(int lowerbound) {
        sb = new StringBuilder();
        sb.append("### List of numbers - Filtered ###");
        sb.append("\n");
        sb.append("Before").append(": ");
        sb.append(Arrays.deepToString(this.numbers.toArray()));

        sb.append("\n");
        sb.append("Try to find (parallel stream) values upper than ")
                .append(Integer.toString(lowerbound)).append(": ");

        // FILTER PARALLEL STREAM
        // Il filtro agisce in parallelo, quindi il risultato non è ordinato.
        // Utile per grandi collezioni di dati (~ .NET Parallel Programming)
        numbers.parallelStream().filter(n -> n > lowerbound).forEach(
                nn -> sb.append(Integer.toString(nn)).append(", "));

        sb.append("\n");
        sb.append("Try to find (sequential stream) values upper than ")
                .append(Integer.toString(lowerbound)).append(": ");

        // FILTER SEQUENTIAL STREAM
        // Il filtro agisce in sequenza, quindi il risultato è ordinato.
        numbers.stream().filter(n -> n > lowerbound).forEach(
                nn -> sb.append(Integer.toString(nn)).append(", "));

        sb.append("\n");
        System.out.println(sb.toString());
    }

    public void printCarsPartitioned(String initialchar) {
        sb = new StringBuilder();
        sb.append("### List of cars - Partitioned ###");
        sb.append("\n");
        sb.append("Before").append(": ");
        sb.append(Arrays.deepToString(this.cars.toArray()));

        sb.append("\n");
        sb.append("Cars start with ").append(initialchar).append(": ");

        // PARTITION
        cars.stream().collect(Collectors.partitioningBy(
                s -> s.getManufacturer().startsWith(initialchar.toUpperCase()))).get(true).forEach(
                        ss -> sb.append(ss.getManufacturer()).append(" ").append(ss.getName()).append(", "));

        sb.append("\n");
        System.out.println(sb.toString());
    }

    public void printCitiesToUpperCase() {
        sb = new StringBuilder();
        sb.append("### List of cities - Upper Case ###");
        sb.append("\n");
        sb.append("Before").append(": ");
        sb.append(Arrays.deepToString(this.cities.toArray()));

        sb.append("\n");
        sb.append("Upper Case: ");

        cities.stream()
                // MAP, METHOD REFERENCE
                // equivalent to .map(city -> city.toUpperCase())
                .map(String::toUpperCase)
                .forEach(city -> sb.append(city).append(", "));

        sb.append("\n");
        System.out.println(sb.toString());
    }

    public void printCitiesStringToPersonCollection() {
        sb = new StringBuilder();
        sb.append("### From List of cities String to List of Person object ###");
        sb.append("\n");
        sb.append("Before").append(": ");
        sb.append(Arrays.deepToString(this.cities.toArray()));

        sb.append("\n");
        sb.append("To Person: ");

        // MAP
        cities.stream()
                .map(s -> {
            return new Person(
                    this.persons.get(new Random().nextInt(this.persons.size())).getName(),
                    new Random().nextInt(this.numbers.size()),
                    this.cars.get(new Random().nextInt(this.cars.size())),
                    s.toUpperCase());
                })
                .collect(Collectors.toList())
                .forEach(p -> sb.append(p.getName())
                        .append(" ").append(p.getAge())
                        .append(" ").append(p.getCity())
                        .append(" ").append(p.getCar().getName())
                        .append(", "));

        sb.append("\n");
        System.out.println(sb.toString());
    }
}
