package it.localhost.app.desktop.learningjava8.common;

/**
 * Car VO
 */
public class Car implements Comparable<Car> {

    private String manufacturer;
    private String name;

    public Car(String m, String n) {
        this.manufacturer = m;
        this.name = n;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getManufacturer() + "  " + getName();
    }

    /**
     * compareTo based on length of String
     *
     * @param o Car to compare.
     * @return int diff value
     */
    @Override
    public int compareTo(Car o) {
        // Il compareTo originale è basato sul valore Unicode di ogni carattere della stringa.
        // Implemento l'override per effettuare il confronto sulla lunghezza della stringa.
        int diff = this.getManufacturer().length() - o.getManufacturer().length();
        if (diff == 0) {
            // A parità di Manufactured effettuo il confronto su Name.
            return this.getName().length() - o.getName().length();
        }
        return diff;
    }

}
