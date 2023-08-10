import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


//        Пример _ ППППППППППППППППППППППППППППППППППП  УДДКОНЧАТЕЛЬНО, ОТПРАВЛЕН В ЭТОМ ВИДЕ !!!!!
//  Пример взят отсюда: https://www.youtube.com/watch?v=5V2lZpEeRlA  девушка на английском говорит
//  5 способов выполнения HTTP-запросов  https://javascopes.com/5-ways-to-make-http-requests-in-java-2p3-fca27bc8/
//  УТИЛИТА, КАК СКАЧАТЬ ФОТО NASA_Module1_Tema1_Urok9 видео мин 22.00, НО ЗДЕСЬ БЕЗ ДАТЫ
public class Task1_3_6_7 {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("Задание: \n7. Сохраняйте снимки NASA с 1 января до того момента, пока в поле Explanation " +
                "нет слова “Earth”\n\nРешение: ");

        String dateBegin_NO_Format = "2022/12/31";
        for (int i = 0; i < 10; i++) {
            System.out.println("ИТЕРАЦИЯ " + (i + 1));

            dateFormat_Begin(dateBegin_NO_Format);  //  Форматируем дату

            final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            final Date date = format.parse(dateBegin_NO_Format);
            final Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            String dateNext_NO_Format = format.format(calendar.getTime());

            String dateNext_YES_Format = dateFormat_Next(dateNext_NO_Format);

            String pageNasaAsText = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=2019-10-14";
            int urlBeginAsText = pageNasaAsText.lastIndexOf("date=");
            String substringUrlAsText = pageNasaAsText.substring(urlBeginAsText + 5);
            String pageNasaAsText_NEW = pageNasaAsText.replace(substringUrlAsText, dateNext_YES_Format);

            dateBegin_NO_Format = dateNext_NO_Format;

            String pageNasa = downloadWeBPage(pageNasaAsText_NEW); //  ВОТ ЗДЕСЬ ЗАДАЕТСЯ ДАТА
            int urlBegin = pageNasa.lastIndexOf("url");
            int urlEnd = pageNasa.lastIndexOf("}");
            String urlPhoto = pageNasa.substring(urlBegin + 6, urlEnd - 1);
            try (InputStream from = new URL(urlPhoto).openStream()) {
                Path to = Paths.get("photo.jpg");  //  ЕСЛИ БЕЗ ПЕРЕЗАПИСИ, ТО ЭТА СТРОЧКА НЕ НУЖНА ! Я подставил to И СТАЛА НУЖНА
//            Files.copy(from, Paths.get("photo.jpg"));  //  ЭТО БЫЛО РАНЕЕ, БЕЗ ПЕРЕЗАПИСИ, СЕЙЧАС ЭТА СТРОКА НЕ НУЖНА !
                Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            }

            System.out.println("Сохранена картинка за дату: " + dateNext_YES_Format);

            int explanationBegin = pageNasa.lastIndexOf("explanation");
            int explanationEnd = pageNasa.lastIndexOf("hdurl");
            String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3/* или 8, три - правильно */);
            System.out.println("Пояснение к фотографии: \n" + explanation);

            if (explanation.contains("Earth")) {
                System.out.println("Найдена первая фотография, у которой в поле Explanation есть слово “Earth”. " +
                        "\nФотография сохранена. На этом программа закончена.");
                break;
            } else {
                System.out.println("Фотографий с заданными условиями не найдено.");
            }
            System.out.println();  //  перенос строки
        }
    }

    private static String downloadWeBPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (InputStream is = urlConnection.getInputStream();
             BufferedReader Br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = Br.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }

    private static void dateFormat_Begin(String dateBegin_NO_Format) {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date date = dt.parse(dateBegin_NO_Format);
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
            String dateBegin_YES_Format = dt1.format(date);
//            System.out.println("Стало dateBegin_YES_Format: " + dateBegin_YES_Format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        System.out.println(); //  перенос строки
    }

    private static String dateFormat_Next(String dateNext_NO_Format) {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
        String dateNext_YES_Format = null;
        try {
            Date date2 = dt.parse(dateNext_NO_Format);
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
            dateNext_YES_Format = dt1.format(date2);
//            System.out.println("Стала следующ. дата в цикле В ФОРМАТЕ: " + dateNext_YES_Format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateNext_YES_Format;
    }
}
//        Конец Примера _ КККККККККККККККК
