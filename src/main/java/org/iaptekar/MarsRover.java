package org.iaptekar;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MarsRover {

    private Position position;

    void move(Command command) {
        switch (command) {
            case LEFT -> position = position.rotate(Rotation.MINUS_NINETY);
            case RIGHT -> position = position.rotate(Rotation.PLUS_NINETY);
            case FORWARD -> position = position.step();
        }
    }

    public boolean isAt(int x, int y, Orientation orientation) {
        return position.equals(new Position(x, y, orientation));
    }
}