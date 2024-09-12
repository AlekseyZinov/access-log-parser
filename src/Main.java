import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        int countLines = 0;
        int countYandexBot = 0;
        int countGoogleBot = 0;
        final int maxAllowedLength = 1024;
        final String yandexBot = "YandexBot";
        final String googleBot = "Googlebot";

/*
Проверка на наличие файла и существования файла
*/
        String path = new Scanner(System.in).nextLine();
        File file = new File(path);
        boolean fileExists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (!fileExists || isDirectory) {
            System.out.println("Указанный файл не существует или указанный путь является путём к папке, а не к файлу");
        } else if (fileExists) {
            count++;
            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + count);
        }

/*
Чтение файла и выявление колличества строк, длину самой длинной и короткой строк
 */
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;

            while ((line = reader.readLine()) != null) {
                String userAgent = "";
                String semicolon = "";
                String whitespace = "";
                String fragment = "";
                int length = line.length();
                if (length > maxAllowedLength) {
                    throw new UserRuntimeException("the maximum allowed string length has been exceeded");
                } else {
                    countLines++;
                    if (line.contains("(compatible;")) {
                        String[] parts = line.split("\\(compatible;");
                        userAgent = parts[1];
                    }
                    String[] parts2 = userAgent.split(";");
                    if (parts2.length >= 2) {
                        semicolon = parts2[0];
                    }
                    String[] parts3 = semicolon.split(" ");
                    if (parts3.length >= 2) {
                        whitespace = parts3[1];
                    }
                    String[] parts4 = whitespace.split("/");
                    if (parts4.length >= 2) {
                        fragment = parts4[0];
                    }
                    if (fragment.equals(yandexBot)) {
                        countYandexBot++;
                    }
                    if (fragment.equals(googleBot)) {
                        countGoogleBot++;
                    }
                }
            }

            System.out.println("Общее колличество строк: " + countLines);
            System.out.println("Колличество запросов от YandexBot " + countYandexBot);
            System.out.println("Колличество запросов от GoogleBot " + countGoogleBot);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}