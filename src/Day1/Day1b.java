package Day1;

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
        try (Scanner scanner = new Scanner(Path.of("src/Day1/input.txt"))){
            List<Integer> row1 = new ArrayList<>();
            List<Integer> row2 = new ArrayList<>();
            List<Long> similarity_scores = new ArrayList<>();

            while (scanner.hasNextLine()){
                String[] locations = scanner.nextLine().split(" {3}");

                row1.add(Integer.parseInt(locations[0]));
                row2.add(Integer.parseInt(locations[1]));
            }
            scanner.close();

            for (int i : row1){
                long duplicates = row2
                        .stream()
                        .filter(n -> n == i)
                        .count();

                long score = i * duplicates;
                similarity_scores.add(score);
            }

            long result = 0;
            for (long i : similarity_scores)
                result += i;
            System.out.println(result);
        }

    }
}
