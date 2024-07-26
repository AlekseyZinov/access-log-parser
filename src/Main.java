import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите первое целое число:");
        int firstNumber = new Scanner(System.in).nextInt();
        System.out.println("Введите второе целое число:");
        int secondNumber = new Scanner(System.in).nextInt();
        int sum = firstNumber + secondNumber;
        int diff = firstNumber - secondNumber;
        int product = firstNumber * secondNumber;
        double quotient = (double) firstNumber / secondNumber;
        System.out.println("Сумма чисел: " + sum);
        System.out.println("Разность чисел: " + diff);
        System.out.println("Произведение чисел: " + product);
        System.out.println("Частное: " + quotient);
    }
}
