package org.iaptekar;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class Position {

    private final int x;
    private final int y;
    private final Orientation orientation;

    public Position rotate(Rotation rotation) {
        return new Position(x, y, orientation.rotate(rotation));
    }

    public Position step() {
        int newX = x + orientation.x();
        int newY = y + orientation.y();
        return new Position(newX, newY, orientation);
    }
}