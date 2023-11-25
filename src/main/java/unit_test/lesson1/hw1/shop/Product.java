package unit_test.lesson1.hw1.shop;

public class Product {
    private Integer cost; // Стоимость продукта
    private String title; // Название

    public Product(String title, int cost) {
        this.cost = cost;
        this.title = title;
    }

    public Product() {
        this.cost = null;
        this.title = null;
    }

    // Геттеры, сеттеры:
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "cost=" + cost;
    }
}