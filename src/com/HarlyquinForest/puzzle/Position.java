package com.HarlyquinForest.puzzle;

public enum Position
{
    TOP_LEFT(0), TOP_CENTER(1), TOP_RIGHT(2),
    MIDDLE_LEFT(3), MIDDLE_CENTER(4), MIDDLE_RIGHT(5),
    BOTTOM_LEFT(6), BOTTOM_CENTER(7), BOTTOM_RIGHT(8);
    private final int index;

    Position(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public Position setPosition(int index) {
        for (Position p : Position.values()) {
            if (p.index == index)
                return p;
        }
        return null;
    }
}
