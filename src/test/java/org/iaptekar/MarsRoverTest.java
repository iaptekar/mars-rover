package org.iaptekar;

import org.junit.jupiter.api.Test;

import static org.iaptekar.Command.*;
import static org.iaptekar.Orientation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarsRoverTest {

    @Test
    public void shouldNotMoveWithNoInstructions() {
        MarsRover rover = new MarsRover(new Position(1, 1, EAST));
        assertTrue(rover.isAt(1, 1, EAST));

    }

    @Test
    public void shouldNotMoveOnRotateInstruction() {
        MarsRover rover = new MarsRover(new Position(1, 1, EAST));
        rover.move(RIGHT);
        assertTrue(rover.isAt(1, 1, SOUTH));
        rover.move(RIGHT);
        assertTrue(rover.isAt(1, 1, WEST));
        rover.move(RIGHT);
        assertTrue(rover.isAt(1, 1, NORTH));
        rover.move(LEFT);
        assertTrue(rover.isAt(1, 1, WEST));
        rover.move(LEFT);
        assertTrue(rover.isAt(1, 1, SOUTH));
        rover.move(LEFT);
        assertTrue(rover.isAt(1, 1, EAST));
    }

    @Test
    public void shouldNotRotateWhenMovingForward() {
        MarsRover rover = new MarsRover(new Position(1, 1, EAST));
        rover.move(FORWARD);
        assertTrue(rover.isAt(2, 1, EAST));
    }

    @Test
    public void testExampleOfGoingInACircle() {
        MarsRover rover = new MarsRover(new Position(1, 1, EAST));
        rover.move(RIGHT);
        rover.move(FORWARD);
        rover.move(RIGHT);
        rover.move(FORWARD);
        rover.move(RIGHT);
        rover.move(FORWARD);
        rover.move(RIGHT);
        rover.move(FORWARD);
        assertTrue(rover.isAt(1, 1, EAST));

    }

    @Test
    public void test() {
        MarsLandscape landscape = new MarsLandscape(5, 3);
        String position = landscape.moveRover(new MarsRover(new Position(1, 1, EAST)), Command.decode("RFRFRFRF"));
        assertEquals("1 1 E", position);
        position = landscape.moveRover(new MarsRover(new Position(3, 2, NORTH)), Command.decode("FRRFLLFFRRFLL"));
        assertEquals("3 3 N LOST", position);
        position = landscape.moveRover(new MarsRover(new Position(0, 3, WEST)), Command.decode("LLFFFLFLFL"));
        assertEquals("2 3 S", position);

    }
}