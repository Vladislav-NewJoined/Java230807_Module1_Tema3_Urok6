import java.io.IOException;
import java.text.ParseException;

public class Task1_3_6_5 {
    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                5. Выводите числа от 1 до того момента, как сумма всех цифр в числе не будет равна 20 
                (пример такого числа - 875)

                Решение:\s""");

        int n = 0;
        int sumDig = 0;
        while (sumDig != 20) {
            n = n + 1;
            System.out.print("Добавлено число: " + n + ", ");
            System.out.println("Сумма цифр равна: " + sumDigits(n));
            sumDig = sumDigits(n);
        }
        System.out.println("Это первое найденное число с заданными условиями. Программа закончена.");
    }

    public static int sumDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}