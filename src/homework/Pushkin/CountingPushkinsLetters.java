package homework.Pushkin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public final class CountingPushkinsLetters {

    private CountingPushkinsLetters() {
    }

    public static void countWordsAndWriteToTheFile(File fileToRead, File fileToWrite) throws IOException {
        Map<Character, Integer> words = new TreeMap<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileToRead)))) {
            while (scanner.hasNext()) {
                String line = scanner.next().toLowerCase();
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isLetter(line.charAt(i))) {
                        words.merge(line.charAt(i), 1, Integer::sum);
                    }
                }
            }
        }
        writeListOfCountedLettersToFile(words, fileToWrite);
    }

    private static void writeListOfCountedLettersToFile(Map<Character, Integer> words, File file) throws IOException {
        try (BufferedWriter bfWriter = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<Character, Integer> entry : words.entrySet()) {
                String line = entry.getKey() + " - " + entry.getValue();
                bfWriter.write(line + "\n");
            }
        }
    }
}
