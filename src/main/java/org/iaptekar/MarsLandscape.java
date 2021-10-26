package org.iaptekar;

import java.util.Collection;
import java.util.HashSet;

public class MarsLandscape {

    private final int maxX;
    private final int maxY;
    private final Collection<Position> lostPositions = new HashSet<>();

    public MarsLandscape(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public static MarsLandscape build(String x, String y) {
        return new MarsLandscape(Integer.parseInt(x), Integer.parseInt(y));
    }

    public String moveRover(MarsRover rover, Command[] instructions) {
        if (instructions == null || instructions.length == 0) {
            return "";
        }
        Position lastPosition = null;
        for (Command command : instructions) {
            lastPosition = rover.getPosition();
            if (lostPositions.contains(lastPosition) && command == Command.FORWARD) {
                continue;
            }
            rover.move(command);
            if (rover.getPosition().isOutsideBounds(maxX, maxY)) {
                rover.setLost();
                lostPositions.add(lastPosition);
                break;
            }
        }
        return rover.isLost() ? lastPosition.toString() + " LOST" : rover.getPosition().toString();
    }


}