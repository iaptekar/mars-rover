package org.iaptekar;

enum Orientation {
    EAST, WEST, NORTH, SOUTH;

    public Orientation rotate(Rotation rotation) {
        return switch (this) {
            case EAST -> rotation == Rotation.PLUS_NINETY ? SOUTH : NORTH;
            case WEST -> rotation == Rotation.PLUS_NINETY ? NORTH : SOUTH;
            case NORTH -> rotation == Rotation.PLUS_NINETY ? EAST : WEST;
            case SOUTH -> rotation == Rotation.PLUS_NINETY ? WEST : EAST;
        };
    }

    public int x() {
        return switch (this) {
            case EAST -> 1;
            case WEST -> -1;
            default -> 0;
        };
    }

    public int y() {
        return switch (this) {
            case SOUTH -> -1;
            case NORTH -> 1;
            default -> 0;
        };
    }

    public static Orientation valueOf(char cmd) {
        return switch (cmd) {
            case 'N' -> NORTH;
            case 'S' -> SOUTH;
            case 'E' -> EAST;
            case 'W' -> WEST;
            default -> throw new IllegalArgumentException("There does not exist a command corresponding to " + cmd);
        };
    }

}