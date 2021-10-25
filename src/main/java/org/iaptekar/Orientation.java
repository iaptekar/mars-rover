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

}