package lesson_6.goods.laptop;

public class Laptop {

    /**
     * Classification
     */
    private final String TYPE = "Laptop";
    private String manufacture; //Производитель
    private String model; //Модель
    private String category; // Категория
    private String screenSize;
    private String screen;
    private String cpu; //CPU
    private String ram;
    private String storage; // Место на диске
    private String gpu;
    private String operatingSystem; // Операционная система
    private String operatingSystemVersion; // Операционная система
    private String weight;
    private String price; // Цена
    private String releaseYear; //Год выпуска


    /**
     * empty constructor
     */
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

    public String getTYPE() {
        return TYPE;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystemVersion() {
        return operatingSystemVersion;
    }

    public void setOperatingSystemVersion(String operatingSystemVersion) {
        this.operatingSystemVersion = operatingSystemVersion;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * Getters or Setters
     */


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
                ", price='" + price + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                '}';
    }



}
