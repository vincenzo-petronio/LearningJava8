package it.localhost.app.desktop.learningjava8;

import it.localhost.app.desktop.learningjava8.tutorial.Lambdas;
import it.localhost.app.desktop.learningjava8.tutorial.Streams;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Learning Java 8 - EntryPoint
 *
 * @author vincenzo.petronio 'AT' gmail.com
 * @version 1.0.0.0
 * @since JDK 1.8
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number (Ctrl+C to exit): ");

        try {
            int n = scanner.nextInt();

            switch (n) {
                case 1: {
                    // LAMBDA
                    Lambdas t = new Lambdas();
                    t.printCitiesOrderedAlpha();
                    t.printCitiesOrderedLength();
                    t.printCarsOrderedLength();
                }
                break;
                case 2:
                    // STREAMS
                    Streams s = new Streams();
                    s.printNumbersFiltered(22);
                    s.printNumbersFiltered(0);
                    s.printNumbersParallelFiltered(7);
                    s.printCarsPartitioned("f");
                    break;
                default:
                    break;
            }

        } catch (InputMismatchException ime) {
            System.out.println("Only numbers are allowed!");
        } finally {
            scanner.close();
        }
    }
}
