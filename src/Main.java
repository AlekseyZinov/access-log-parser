import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        int countLines = 0;
        int maxLineLength;
        int minLineLength;
        final int maxAllowedLength = 1024;
        while (true) {

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
                maxLineLength = reader.readLine().length();
                minLineLength = reader.readLine().length();
                while ((line = reader.readLine()) != null) {
                    int length = line.length();
                    if (length > maxAllowedLength) {
                        throw new UserRuntimeException("the maximum allowed string length has been exceeded");
                    } else {
                        countLines++;
                        if (length >= maxLineLength) {
                            maxLineLength = length;
                        }
                        if (length <= minLineLength) {
                            minLineLength = length;
                        }
                    }
                }
                System.out.println("Общее колличество строк: " + countLines);
                System.out.println("Длина самой длинной строки: " + maxLineLength);
                System.out.println("Длина самой короткой строки: " + minLineLength);
            } catch (Exception ex){
                ex.printStackTrace();
            }

        }
    }
}