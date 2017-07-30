import java.io.*;
import java.nio.file.Files;

public class Main extends Setup{

    public static void main(String[] args) throws IOException {

        // задаем пути для файлов
        System.out.println("Задайте прямой путь к файлу");
        String sourcePath = PathReader();
        System.out.println("Задайте желаемое расположение и имя копии файла");
        String destPath = PathReader();

        //Файлы путь к ним
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        //Копируем данные из одного файла в другой
        Files.copy(sourceFile.toPath(), destFile.toPath());
        System.out.println("Копия файла создана, путь\n" + destPath);

        //Сравниваем построчно данные из файлов
        ReadAndCompare(sourceFile,destFile);
    }
}
