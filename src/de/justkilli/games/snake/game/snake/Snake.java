package de.justkilli.games.snake.game.snake;

import de.justkilli.games.snake.game.gamefield.FieldPosition;

import java.util.List;

public class Snake {

    private List<FieldPosition> snakeParts;
    private SnakeState snakeState;

    public SnakeState getSnakeState() {
        return snakeState;
    }

    public void setSnakeState(SnakeState snakeState) {
        this.snakeState = snakeState;
    }
}
