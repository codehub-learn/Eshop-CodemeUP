package repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileRepository {

    public void read(String filepath) throws IOException {
        // FileReader reader = new FileReader(filepath); // 1.1
        BufferedReader reader = Files.newBufferedReader(Path.of(filepath)); // 1.7
        for (int index = 1; true; index++) {
            String line = reader.readLine();
            // NEVER USE THE FOLLOWING, ALWAYS USE BRACKETS
            // THIS IS USED JUST FOR FLEXING REASONS
            if (line == null) break;
            if (index == 1) parseFirstLine(line);
            else parseOtherLines(line);
        }
    }

    private void parseFirstLine(String line) {
        System.out.println("I am in line one");
        System.out.println(line);
        String[] resultOfLine = line.split(" ");
        int first = Integer.parseInt(resultOfLine[0]);
        double second = Double.parseDouble(resultOfLine[1]);
        int third = Integer.parseInt(resultOfLine[2]);
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }

    private void parseOtherLines(String line) {
        System.out.println("I am not in line one");
        System.out.println(line);
    }
}
