package homework.Pushkin;

import java.io.File;
import java.io.IOException;

import static java.lang.String.join;

public class RunPushkinRun {

    public static void main(String[] args) throws IOException {
        File fileWithPoem = new File(join(File.separator, "src", "homework", "Pushkin", "PushkinsPoem.txt"));
        File fileToWrite = new File(join(File.separator, "src", "homework", "Pushkin", "WordsInPoem.txt"));

        CountingPushkinsLetters.countWordsAndWriteToTheFile(fileWithPoem, fileToWrite);
    }
}
