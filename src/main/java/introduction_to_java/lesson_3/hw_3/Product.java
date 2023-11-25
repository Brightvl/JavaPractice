package introduction_to_java.lesson_3.hw_3;


/**
 * Класс может принимать массив с информацией о продуктах и отдельную информацию о них.
 */
public class Product {
    String name;
    double price;
    int variety;
    int weight;
    String countryOrigin;


    /**
     * Конструктор товара
     * @param name          наименование товара
     * @param price         стоимость товара
     * @param variety       сорт товара
     * @param weight        вес товара
     * @param countryOrigin страна изготовитель
     */
    public Product(String name, double price, int variety, int weight, String countryOrigin) {
        this.name = name;
        this.price = price;
        this.variety = variety;
        this.weight = weight;
        this.countryOrigin = countryOrigin;
    }

//    /**
//     * Если передана строка которую нужно разбить на составляющие
//     * @param record Данные продукта в виде строки
//     */
//    public Product(String record) {
//        String[] hi = record.split(";");
//        name = hi[0];
//        price = Double.parseDouble(hi[1]);
//        variety = Integer.parseInt(hi[2]);
//        weight = Double.parseDouble(hi[3]);
//        countryOrigin = (hi[4]);
//    }


    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", price=" + price +
                ", variety=" + variety +
                ", weight=" + weight +
                ", countryOrigin='" + countryOrigin + '\'';
    }


}
