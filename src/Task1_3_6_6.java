import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task1_3_6_6 {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("Задание: \n6. Выведите все даты невисокосного года. В январе 31 день, феврале - 28, " +
                "\nдалее чередуется - в марте 31, в апреле 30...\n\nРешение: ");

        String dateBegin_NO_Format = "2022/12/31";

        for (int i = 0; i < 365; i++) {
            for (int a = 0; a < 10; a++) {
                final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                final Date date = format.parse(dateBegin_NO_Format);
                final Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                String dateNext_NO_Format = format.format(calendar.getTime());
                String dateNext_YES_Format = dateBegin_NO_Format = dateNext_NO_Format;
                System.out.print(dateNext_YES_Format + " ");
                i = i+1;
                if (i == 365) {
                    break;
                }
            }
            if (i == 365) {
                break;
            }
            i = i-1;
            System.out.println();
        }
        System.out.println();  //  перенос строки
    }
}