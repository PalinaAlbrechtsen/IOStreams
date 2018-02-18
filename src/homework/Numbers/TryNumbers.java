package homework.Numbers;

import java.io.File;
import java.io.IOException;

import static java.lang.String.join;

public class TryNumbers {

    public static void main(String[] args) throws IOException {
        File file = new File(join(File.separator, "src", "homework", "Numbers", "random_num.txt"));

        NumbersUtil.fillFileWithRandomNumbers(file);
        NumbersUtil.sortNumbersAndWriteToFile(file);
    }
}
