package unit_test.lesson3.s3;

public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        String operation = "+"; // Здесь можно изменить операцию (+, -, *, /)

        controller.performCalculation(operation);
    }
}
