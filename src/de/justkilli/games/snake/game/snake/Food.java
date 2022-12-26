package de.justkilli.games.snake.game.snake;

import de.justkilli.games.snake.game.gamefield.FieldPosition;

public class Food {
    private FieldPosition fieldPosition;

    public Food(FieldPosition fieldPosition) {
        this.fieldPosition = fieldPosition;
    }

    public boolean equals(Food food) {
        return fieldPosition.equals(food.getFieldPosition());
    }

    public Food clone() throws CloneNotSupportedException {
        return (Food) super.clone();
    }

    public FieldPosition getFieldPosition() {
        return fieldPosition;
    }
}
