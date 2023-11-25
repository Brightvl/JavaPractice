package introduction_to_java.lesson_6.goods.laptop;

public class Laptop {

    /**
     * Classification
     */
    private String manufacture;
    private String model;
    private String category;
    private String screenSize;
    private String screen;
    private String cpu;
    private String ram;
    private String storage;
    private String gpu;
    private String operatingSystem;
    private String operatingSystemVersion;
    private String weight;
    private String price;

    public Laptop() {
    }

    public Laptop(String brand, String model, String category, String screenSize, String screen, String cpu, String ram, String storage, String gpu, String operatingSystem, String operatingSystemVersion, String weight, String price) {
        this.manufacture = brand;
        this.model = model;
        this.category = category;
        this.screenSize = screenSize;
        this.screen = screen;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.gpu = gpu;
        this.operatingSystem = operatingSystem;
        this.operatingSystemVersion = operatingSystemVersion;
        this.weight = weight;
        this.price = price;
    }

    public String getManufacture() {
        return manufacture;
    }

    public String getCategory() {
        return category;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "manufacture='" + manufacture + '\'' +
                ", model='" + model + '\'' +
                ", category='" + category + '\'' +
                ", screenSize='" + screenSize + '\'' +
                ", screen='" + screen + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", gpu='" + gpu + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", operatingSystemVersion='" + operatingSystemVersion + '\'' +
                ", weight='" + weight + '\'' +
                ", price='" + price + '\'' + '}';
    }


}
