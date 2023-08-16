
import java.util.Scanner;

public class CalculatorJava {
    public static void main(String[] args) {
        System.out.println(" Введите два числа и арифметическую операциию проводимую между ними разделенные пробелами");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = calc(input);
        System.out.println(result);
    }

    public static String calc(String input) throws IllegalArgumentException {
        String[] tokens = input.split(" ");
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Неправильный формат строки");
        }

        int a;
        int b;

        try {
            a = Integer.parseInt(tokens[0]);
            b = Integer.parseInt(tokens[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неправильный формат чисел");
        }
        if (a > 10 || a < 1) {
            throw new IllegalArgumentException("Первое число больше 10");
        }
        if (b > 10 || b < 1) {
            throw new IllegalArgumentException("Второе число больше 10");
        }
        int result = switch (tokens[1]) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Неправильная арифметическая операция");
        };

        return String.valueOf(result);
    }
}
