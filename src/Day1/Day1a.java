package Day1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

/**
 * @author vregi, 12/1/2024
 */
public class Day1a {
    public static void main(String[] args) throws IOException {
        String currentPath = Path.of("").toAbsolutePath().resolve("src/Day1").toString();
        File input = new File(String.format("%s\\input.txt", currentPath));
        File output = new File(String.format("%s\\distances.txt", currentPath));
        output.createNewFile();

        FileWriter writer = new FileWriter(String.format("%s\\distances.txt", currentPath));
        Scanner scanner1 = new Scanner(input);

        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();

        while (scanner1.hasNextLine()){
            String[] locations = scanner1.nextLine().split(" {3}");

            row1.add(Integer.parseInt(locations[0]));
            row2.add(Integer.parseInt(locations[1]));
        }
        scanner1.close();

        Collections.sort(row1);
        Collections.sort(row2);

        int distance;
        for (int i = 0; i < row1.size(); i++) {
            distance = row1.get(i) - row2.get(i);
            writer.write(Math.abs(distance)+"\n");
        }
        writer.close();

        Scanner scanner2 = new Scanner(output);
        int result = 0;
        while (scanner2.hasNextInt()){
            result += scanner2.nextInt();
        }
        System.out.println(result);
        scanner2.close();
    }
}
