package de.justkilli.games.snake.game.gamefield;

import java.awt.*;

/**
 * Class to Store the Size of a BaseField
 * @see BaseField
 * */
public class FieldSize {

    private Dimension dimension;
    private int fieldPartSize, rows, columns;

    public FieldSize(Dimension dimension, int fieldPartSize) {
        this.dimension = dimension;
        this.fieldPartSize = fieldPartSize;
        rows = this.dimension.height / this.fieldPartSize;
        columns = this.dimension.width / this.fieldPartSize;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public int getFieldPartSize() {
        return fieldPartSize;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
