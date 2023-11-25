package unit_test.lesson3.s3;

public class CalculatorModel {
    private double result;

    public void add(double num1, double num2) {
        result = num1 + num2;
    }

    public void subtract(double num1, double num2) {
        result = num1 - num2;
    }

    public void multiply(double num1, double num2) {
        result = num1 * num2;
    }

    public void divide(double num1, double num2) {
        if (num1 == 0 || num2 == 0) {
            throw new IllegalArgumentException("На ноль делить нельзя");
        }
        result = num1 / num2;
    }

    public double getResult() {
        return result;
    }
}
