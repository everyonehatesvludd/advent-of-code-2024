package Day1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

/**
 * @author vregi, 12/1/2024
 */
public class Day1a {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new File(Path.of("src/Day1/input.txt").toString()))) {
            List<Integer> row1 = new ArrayList<>();
            List<Integer> row2 = new ArrayList<>();
            List<Integer> distances = new ArrayList<>();

            while (scanner.hasNextLine()){
                String[] locations = scanner.nextLine().split(" {3}");

                row1.add(Integer.parseInt(locations[0]));
                row2.add(Integer.parseInt(locations[1]));
            }
            scanner.close();

            Collections.sort(row1);
            Collections.sort(row2);

            int distance;
            for (int i = 0; i < row1.size(); i++) {
                distance = row1.get(i) - row2.get(i);
                distances.add(Math.abs(distance));
            }

            int result = 0;
            for (Integer integer : distances) {
                result += integer;
            }

            System.out.println(result);
        }
    }
}
