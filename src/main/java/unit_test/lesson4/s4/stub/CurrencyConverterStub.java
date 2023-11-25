package unit_test.lesson4.s4.stub;

public class CurrencyConverterStub implements CurrencyConverter {

    /**
     * То-же самое, передаем, нет логики внутри, но вовзращать что-то должен
     * @param amount
     * @param fromCurrency
     * @param toCurrency
     * @return
     */
    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        // Вообще все равно что внутри главное что вернет double как в оригинальном методе.
        // Подменим методы
        return 50.0; // Пусть всегда будет 50.0, например
    }
}
