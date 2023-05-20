package lesson_6.goods;

public class Laptop {

    //Процессор,Дискретная видеокарта,Встроенная видеокарта,Оперативная память,SSD,HDD,Экран,Операционная система,Ссылка
    /**
     * Classification
     */
    private final String TYPE = "Laptop";
    private String brand; //Производитель
    private String model; //Модель
    private String price; // Цена
    private String releaseYear; //Год выпуска
    private String operatingSystem; // Операционная система

    /**
     * Additionally info
     */
    private String keyboardLayout;
    private String screenDiagonal;
    private String screenResolution;
    private String ram;
    private String storage;
    private String color;


    /**
     * empty constructor
     */
    public Laptop() {
    }


    public Laptop(String model, String releaseYear, String screenDiagonal, String operatingSystem) {
        this.brand = model;
        this.releaseYear = releaseYear;
        this.screenDiagonal = screenDiagonal;
        this.operatingSystem = operatingSystem;
    }

    public Laptop(String brand, String model, String releaseYear) {
        this.brand = brand;
        this.model = model;
        this.releaseYear = releaseYear;
        this.operatingSystem = check(operatingSystem);
    }

    public Laptop(String brand, String model, String price, String releaseYear, String operatingSystem) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.releaseYear = releaseYear;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
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


    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public String getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(String screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String check(String string) {
        return (string == null ? "Unknown" : string);
    }

    @Override
    public String toString() {
        return "Brand='" + check(brand) + "', " +
                "Model='" + check(model) + "', " +
                "ReleaseYear=" + check(releaseYear) + ", " +
                "OperatingSystem='" + check(operatingSystem) + "', " +
                "KeyboardLayout='" + check(keyboardLayout) + "' " +
                "ScreenDiagonal=" + check(screenDiagonal) + ", " +
                "screenResolution='" + check(screenResolution) + "', " +
                "ram=" + check(ram) + ", " +
                "storage=" + check(storage) + ", " +
                "color='" + check(color) + '\'';
    }
}
