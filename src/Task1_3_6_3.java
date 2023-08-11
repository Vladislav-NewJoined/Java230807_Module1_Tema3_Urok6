import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1_3_6_3 {
    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                Найдите первое чётное число в массиве, которое больше 100

                Решение:\s""");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите несколько целых чисел, разделяя числа клавишей Enter, " +
                "\nпо окончании ввода, введите две запятые, т.е. \",,\" и далее Enter: ");
        String input = "";
        List<String> arrStr = new ArrayList<>();
        int inputInt;

        while(!input.equals(",,")){
            input = scanner.nextLine();
            arrStr.add(input);
        }
        scanner.close();

        int index = arrStr.size() - 1;
        arrStr.remove(index);

        List<Integer> arrInt = new ArrayList<>();

        for(int i = 0; i<arrStr.size(); i++) {
            String value = arrStr.get(i);
            inputInt = Integer.parseInt(value);
            arrInt.add(inputInt);
        }
        System.out.println("Исходный массив чисел: " + arrInt);
        int firstSuitableNum = 1;
        int count = 0;
        String summary = null;
        for(int i = 0; i<arrInt.size(); i++) {
            if (arrInt.get(i) % 2 == 0 && arrInt.get(i) > 100) {
                firstSuitableNum = arrInt.get(i);
                count = i+1;
                summary = "Найдено первое четное число, которое больше ста: " + firstSuitableNum + ", его порядковый номер в списке: " + count;
                break;
            } else {
                summary = "Чисел, соответствующих заданным критериям, не найдено";
            }
        }
        System.out.println(summary);
    }
}