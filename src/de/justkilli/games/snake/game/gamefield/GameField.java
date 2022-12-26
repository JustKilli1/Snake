package de.justkilli.games.snake.game.gamefield;

import de.justkilli.games.snake.game.Design;
import de.justkilli.games.snake.game.snake.Food;
import de.justkilli.games.snake.game.snake.Snake;
import de.justkilli.games.snake.game.snake.SnakeState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameField extends BaseField {

    private List<Food> activeFood;
    private Snake snake;

    public GameField(FieldSize fieldSize, Design design, Snake snake) {
        super(fieldSize, design);
        this.snake = snake;
        activeFood = new ArrayList<>();
    }


    /**
     * Spawns food at the specified Row/Column
     * @param fieldPosition Point where the Food gets placed
     * @see FieldPosition
     * */
    public void spawnFood(FieldPosition fieldPosition) throws IllegalArgumentException {
        if(!fieldPosition.inBounds(fieldSize.getRows(), fieldSize.getColumns()))
            throw new IllegalArgumentException("Illegal Argument for Method spawnFood. " +
                    "Row or Column to big. " +
                    "row = " + fieldPosition.getRow() + " Allowed = " + fieldSize.getRows() + "; " +
                    "column = " + fieldPosition.getColumn() + " Allowed = " + fieldSize.getColumns());
        if(fieldParts[fieldPosition.getRow()][fieldPosition.getColumn()].getBackground().equals(design.getFoodColor())){
            spawnFood(fieldPosition);
            return;
        }
        changePartColor(fieldPosition, design.getFoodColor());
        activeFood.add(new Food(fieldPosition));
    }

    /**
     * Spawns food at a Random Location
     * @see FieldPosition
     * */
    public void spawnFood() throws IllegalArgumentException {
        Random rand = ThreadLocalRandom.current();
        int randRow = rand.nextInt(fieldSize.getRows());
        int randColumn = rand.nextInt(fieldSize.getColumns());
        spawnFood(new FieldPosition(randRow, randColumn));
    }

    /**
     * Despawns food at the specified Row/Column
     * @param fieldPosition Point where the Food gets placed
     * @see FieldPosition
     * */
    public void despawnFood(FieldPosition fieldPosition) throws IllegalArgumentException {
        if(!fieldPosition.inBounds(fieldSize.getRows(), fieldSize.getColumns()))
            throw new IllegalArgumentException("Illegal Argument for Method despawnFood. " +
                    "Row or Column to big. " +
                    "row = " + fieldPosition.getRow() + " Allowed = " + fieldSize.getRows() + "; " +
                    "column = " + fieldPosition.getColumn() + " Allowed = " + fieldSize.getColumns());
        if(activeFood.stream().noneMatch(food -> food.equals(new Food(fieldPosition))))
            throw new IllegalArgumentException("Could not find food with given arguments.");

        changePartColor(fieldPosition, design.getFieldBackground());
        activeFood.remove(new Food(fieldPosition));
    }
    /**
     * Despawns random Food item from {@code List<Food> activeFood}
     * @see Food
     * */
    public void despawnFood() throws IllegalArgumentException {
        Food food = activeFood.get(ThreadLocalRandom.current().nextInt(activeFood.size()));
        despawnFood(food.getFieldPosition());
    }

    /**
     * Spawns the Snake at the first possible Location and changes its State to Alive
     * @see Snake
     * @see SnakeState
     * */
    public void spawnSnake() {
        if(snake != null) return;
        changePartColor(new FieldPosition(0, 0), design.getSnakeColor());
        snake = new Snake();
        snake.setSnakeState(SnakeState.ALIVE);
    }
    /**
     * Spawns a Snake Part at the given Position
     * @param fieldPosition Position where the Part gets spawned
     * @see FieldPosition
     * */
    public void spawnSnakePart(FieldPosition fieldPosition) {
        if(!fieldPosition.inBounds(fieldSize.getRows(), fieldSize.getColumns()))
            throw new IllegalArgumentException("Illegal Argument for Method spawnSnakePart. " +
                    "Row or Column to big. " +
                    "row = " + fieldPosition.getRow() + " Allowed = " + fieldSize.getRows() + "; " +
                    "column = " + fieldPosition.getColumn() + " Allowed = " + fieldSize.getColumns());
        if(fieldParts[fieldPosition.getRow()][fieldPosition.getColumn()].getBackground().equals(design.getSnakePartColor()))
            return;
        changePartColor(fieldPosition, design.getSnakePartColor());
    }

    /**
     * Despawns a Snake part at the given Position
     * @param fieldPosition Position where the Snake part gets despawned
     * @see FieldPosition
     * */
    public void despawnSnakePart(FieldPosition fieldPosition) {
        if(!fieldPosition.inBounds(fieldSize.getRows(), fieldSize.getColumns()))
            throw new IllegalArgumentException("Illegal Argument for Method despawnSnakePart. " +
                    "Row or Column to big. " +
                    "row = " + fieldPosition.getRow() + " Allowed = " + fieldSize.getRows() + "; " +
                    "column = " + fieldPosition.getColumn() + " Allowed = " + fieldSize.getColumns());
        if(fieldParts[fieldPosition.getRow()][fieldPosition.getColumn()].getBackground().equals(design.getSnakePartColor()))
            return;
        changePartColor(fieldPosition, design.getFieldBackground());
    }
}
