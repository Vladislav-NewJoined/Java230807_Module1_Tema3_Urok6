import java.util.Arrays;
import java.util.Scanner;

public class Task1_3_6_1 {
    public static void main(String[] args) {
        System.out.println("Задание: \n1.  Пользователь вводит 10 слов в массив. Найдите первое слово, " +
                "\nв котором есть две гласные буквы подряд\n\nРешение: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 10 слов (после ввода каждого слова - клавиша Enter): ");
        int breakMark = 0;

        String[] words = new String[10];
        for (int i = 0; i < words.length; i++) {
            words[i] = scanner.nextLine();
        }
        System.out.println("Исходный массив слов: " + Arrays.toString(words));
//        String inputWords = String.join(", ", words);
//        System.out.println("Исходный массив слов в списке: " + inputWords);

        for (int i = 0; i < words.length; i++) {
            String word2 = words[i];
            for (int n = 1; n < word2.length(); n++) {

                if (("АЕЁИОУЫЭЮЯаеёиоуыэюяAEIOUaeiou".indexOf(word2.charAt(n)) > -1)
                        && ("АЕЁИОУЫЭЮЯаеёиоуыэюяAEIOUaeiou".indexOf(word2.charAt(n - 1)) > -1)) {
                    System.out.println("Найдено первое слово: \"" + word2 + "\", в котором две гласные подряд: \"" + word2.charAt(n - 1) + word2.charAt(n) + "\"");
                    breakMark = 1;
                    break;
                }
            }
            if (breakMark == 1) {
                break;
            }
        }
    }
}