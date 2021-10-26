package org.iaptekar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FileInstructionLoader implements InstructionLoader {

    private final Path file;

    public FileInstructionLoader(String filename) {
        this.file = Paths.get(filename);
    }

    public List<String> execute() throws IOException {
        List<String> lines = Files.lines(file).filter(line -> !line.isEmpty()).collect(toList());
        if (lines.isEmpty()) {
            throw new IllegalStateException("No instructions given");
        }
        List<String> output = new ArrayList<>();
        String[] size = lines.get(0).split(" ");
        MarsLandscape landscape = MarsLandscape.build(size[0], size[1]);

        for (int i = 1; i < lines.size(); i += 2) {
            String[] coords = lines.get(i).split(" ");
            MarsRover rover = MarsRover.build(coords[0], coords[1], coords[2].charAt(0));
            String commands = lines.get(i + 1);
            String lastPosition = landscape.moveRover(rover, Command.decode(commands));
            output.add(lastPosition);
        }
        return output;
    }
}