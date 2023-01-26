package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileRepository {

    public List<String> read(String filepath) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Path.of(filepath));
        ArrayList<String> lines = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            lines.add(line);
        }
        return lines;
    }

    public void save(List<String> lines, String filepath) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Path.of(filepath));
        for (String line : lines) { // enhanced loop
            writer.write(line);
            writer.newLine();
        }
        writer.flush();
    }
}
