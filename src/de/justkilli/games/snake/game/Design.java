package de.justkilli.games.snake.game;

import java.awt.*;

public class Design {

    private Color fieldBackground, snakeColor, snakePartColor, foodColor;

    public Color getFieldBackground() {
        return fieldBackground;
    }

    public Color getSnakePartColor() {
        return snakePartColor;
    }

    public Design setSnakePartColor(Color snakePartColor) {
        this.snakePartColor = snakePartColor;
        return this;
    }

    public Design setFieldBackground(Color fieldBackground) {
        this.fieldBackground = fieldBackground;
        return this;
    }

    public Color getSnakeColor() {
        return snakeColor;
    }

    public Design setSnakeColor(Color snakeColor) {
        this.snakeColor = snakeColor;
        return this;
    }

    public Color getFoodColor() {
        return foodColor;
    }

    public Design setFoodColor(Color foodColor) {
        this.foodColor = foodColor;
        return this;
    }
}
