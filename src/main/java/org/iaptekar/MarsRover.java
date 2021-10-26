package org.iaptekar;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class MarsRover {

    private Status status = Status.ACTIVE;

    public MarsRover(Position position) {
        this.position = position;
    }

    private Position position;

    public static MarsRover build(String x, String y, String orientation) {
        Position position = new Position(Integer.parseInt(x), Integer.parseInt(y), Orientation.valueOf(orientation));
        return new MarsRover(position);
    }

    public void move(Command command) {
        switch (command) {
            case LEFT -> position = position.rotate(Rotation.MINUS_NINETY);
            case RIGHT -> position = position.rotate(Rotation.PLUS_NINETY);
            case FORWARD -> position = position.step();
        }
    }

    public boolean isLost() {
        return status == Status.LOST;
    }

    public boolean isAt(int x, int y, Orientation orientation) {
        return position.equals(new Position(x, y, orientation));
    }

    public void setLost() {
        status = Status.LOST;
    }

    enum Status {
        ACTIVE, LOST
    }
}