package lesson_6.goods;

public class Laptop {

    /**
     * Classification
     */
    private final String TYPE = "Laptop";
    private String brand;
    private int releaseYear;
    private String operatingSystem;

    /**
     * Additionally info
     */
    private String keyboardLayout;
    private double screenDiagonal;
    private String screenResolution;
    private int ram;
    private int storage;
    private String color;


    /**
     * empty constructor
     */
    public Laptop() {
    }


    public Laptop(String model, int releaseYear, double screenDiagonal,String operatingSystem) {
        this.brand = model;
        this.releaseYear = releaseYear;
        this.screenDiagonal = screenDiagonal;
        this.operatingSystem = operatingSystem;
    }


    /**
     * Getters or Setters
     */

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getKeyboardLayout() {
        return keyboardLayout;
    }

    public void setKeyboardLayout(String keyboardLayout) {
        this.keyboardLayout = keyboardLayout;
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(double screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "TYPE='" + TYPE + '\'' +
                ", brand='" + brand + '\'' +
                ", releaseYear=" + releaseYear +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", keyboardLayout='" + keyboardLayout + '\'' +
                ", screenDiagonal=" + screenDiagonal +
                ", screenResolution='" + screenResolution + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", color='" + color + '\'' +
                '}';
    }
}
