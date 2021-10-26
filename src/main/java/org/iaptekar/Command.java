package org.iaptekar;

import java.util.stream.IntStream;

public enum Command {

    LEFT, RIGHT, FORWARD;

    public static Command[] decode(String instructions) {
        return IntStream.range(0, instructions.length()).mapToObj(i -> Command.of(instructions.charAt(i))).toArray(Command[]::new);
    }

    private static Command of(char cmd) {
        return switch (cmd) {
            case 'L' -> LEFT;
            case 'R' -> RIGHT;
            case 'F' -> FORWARD;
            default -> throw new IllegalArgumentException("There does not exist a command corresponding to " + cmd);
        };
    }
}