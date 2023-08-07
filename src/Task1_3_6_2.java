import java.util.*;

public class Task1_3_6_2 {
    public static void main(String[] args) {
        System.out.println("Задание: \n2.Пользователь вводит массив чисел. Найдите первое четное число\n\nРешение: ");
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
        int firstEven = 1;
        int count = 0;
        for(int i = 0; i<arrInt.size(); i++) {
            if (arrInt.get(i) % 2 == 0) {
                firstEven = arrInt.get(i);
                count = i+1;
                break;
            }
        }
        System.out.println("Найжено первое четное число: " + firstEven + ", его порядковый номер в списке: " + count);

    }
}