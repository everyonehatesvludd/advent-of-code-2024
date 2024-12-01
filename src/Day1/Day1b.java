package Day1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author vregi, 12/1/2024
 */
public class Day1b {
    public static void main(String[] args) throws IOException {
        String currentPath = Path.of("").toAbsolutePath().resolve("src/Day1").toString();
        File input = new File(String.format("%s\\input.txt", currentPath));

        File output = new File(String.format("%s\\similarity_scores.txt", currentPath));
        boolean outputCreation = output.createNewFile();
        if (!outputCreation)
            System.out.println("Unable to create file");

        FileWriter writer = new FileWriter(String.format("%s\\similarity_scores.txt", currentPath));
        Scanner inputScanner = new Scanner(input);

        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();

        while (inputScanner.hasNextLine()){
            String[] locations = inputScanner.nextLine().split(" {3}");

            row1.add(Integer.parseInt(locations[0]));
            row2.add(Integer.parseInt(locations[1]));
        }
        inputScanner.close();

        for (int i : row1){
            long duplicates = row2
                    .stream()
                    .filter(n -> n == i)
                    .count();

            long score = i * duplicates;
            writer.write(score+"\n");
        }
        writer.close();

        Scanner outputScanner = new Scanner(output);
        int result = 0;
        while (outputScanner.hasNextInt())
            result += outputScanner.nextInt();

        System.out.println(result);
        outputScanner.close();

    }
}
