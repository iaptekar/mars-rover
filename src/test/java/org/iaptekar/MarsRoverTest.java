package org.iaptekar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.iaptekar.Orientation.EAST;

public class MarsRoverTest {

    @Test
    public void testExample() {
        MarsRover rover = new MarsRover(new Position(1, 1, EAST));
        rover.move(Command.RIGHT);
        rover.move(Command.FORWARD);
        rover.move(Command.RIGHT);
        rover.move(Command.FORWARD);
        rover.move(Command.RIGHT);
        rover.move(Command.FORWARD);
        rover.move(Command.RIGHT);
        rover.move(Command.FORWARD);
        Assertions.assertTrue(rover.isAt(1, 1, EAST));

    }
}