import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "input.txt";  // Путь к вашему .txt файлу
        String outputFilePath = "inf.svc";  // Результат

        try {
            // Чтение файла .txt
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Подсчёт количества символов, символов без пробелов и слов
            int totalCharacters = 0;
            int charactersWithoutSpaces = 0;
            int wordCount = 0;

            // Цикл для анализа содержимого
            for (char ch : content.toCharArray()) {
                totalCharacters++;
                if (ch != ' ') {
                    charactersWithoutSpaces++;
                }
            }

            // Подсчёт количества слов
            String[] words = content.trim().split("\\s+");
            wordCount = words.length;

            // Вывод в консоль
            System.out.println("Количество символов в тексте: " + totalCharacters);
            System.out.println("Количество символов в тексте без пробелов: " + charactersWithoutSpaces);
            System.out.println("Количество слов: " + wordCount);

            // Запись результатов в .svc файл
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                writer.write("Результаты анализа текста:\n");
                writer.write("Количество символов в тексте: " + totalCharacters + "\n");
                writer.write("Количество символов в тексте без пробелов: " + charactersWithoutSpaces + "\n");
                writer.write("Количество слов: " + wordCount + "\n");
            }

            System.out.println("Результаты записаны в файл: " + outputFilePath);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
