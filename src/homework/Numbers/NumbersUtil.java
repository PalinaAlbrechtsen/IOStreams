package homework.Numbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class NumbersUtil {

    private NumbersUtil() {
    }

    public static void fillFileWithRandomNumbers(File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            Random random = new Random();
            Integer[] randomNumbs = new Integer[28];
            for (int i = 0; i < randomNumbs.length; i++) {
                randomNumbs[i] = random.nextInt(100);
                writer.write(randomNumbs[i] + " ");
            }
        }
    }

    public static void sortNumbersAndWriteToFile(File file) throws IOException {
        List<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (scanner.hasNext()) {
                list.add(scanner.nextInt());
            }
        }
        list.sort(Comparator.naturalOrder());
        fillFileWithSortNumbs(file, list);
    }

    private static void fillFileWithSortNumbs(File file, List<Integer> list) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write("\n");
            for (Integer integer : list) {
                writer.write(integer + " ");
            }
        }
    }
}
