package unit_test.lesson4.s4.stub;

public class Calculator {
    private CurrencyConverter currencyConverter;

    public Calculator(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }


    public double calculateTotalCost(double price, int quantity, String currency) {
        // очень сложная логика которую мы не понимаем, но точно вернет double
        double totalCost = price * quantity;
        return currencyConverter.convert(totalCost, "USD", currency);
    }
}
