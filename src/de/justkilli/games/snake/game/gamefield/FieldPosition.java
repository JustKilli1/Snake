package de.justkilli.games.snake.game.gamefield;

public class FieldPosition {

    int row, column;

    public FieldPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean inBounds(int row, int column) {
        return this.row <= row && this.column <= column;
    }

    public boolean equals(FieldPosition fieldPosition) {
        return row == fieldPosition.getRow() && column == fieldPosition.getColumn();
    }

    public FieldPosition clone() throws CloneNotSupportedException {
        return (FieldPosition) super.clone();
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
