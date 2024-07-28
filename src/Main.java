import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count = 0;
        while (true) {
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExist = file.exists();
            boolean isDirectory = file.isDirectory();
            if (!fileExist && !isDirectory) {
                System.out.println("Файл не существует или указанный путь является путём к папке, а не к файлу");
                continue;
            } else if (fileExist && isDirectory) {
                count++;
                System.out.println(count);
                System.out.println("Путь указан верно");
                System.out.println("Это файл номер " + count);
            }
        }
    }
}
