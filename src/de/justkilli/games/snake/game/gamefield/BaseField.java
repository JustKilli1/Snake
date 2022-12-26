package de.justkilli.games.snake.game.gamefield;

import de.justkilli.games.snake.game.Design;

import javax.swing.*;
import java.awt.*;

/**
 * Provides basic functions to interact with the Field Window
 * */
public class BaseField extends JFrame {

    private final FieldSize fieldSize;
    private Design design;
    private JPanel[][] fieldParts;


    public BaseField(FieldSize fieldSize, Design design) {
        this.fieldSize = fieldSize;
        this.design = design;
        windowInit();
        build();
    }

    /**
     * Sets some initial Window Values
     * */
    private void windowInit() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(fieldSize.getDimension());
        GridLayout gridLayout = new GridLayout(fieldSize.getRows(), fieldSize.getColumns());
        this.setLayout(gridLayout);
    }

    /**
     * Builds the Base Field
     * */
    private void build() {
        fieldParts = new JPanel[fieldSize.getRows()][fieldSize.getColumns()];
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < fieldParts.length; i++) {
                    JPanel[] parts = fieldParts[i];
                    for(int z = 0; z < parts.length; z++) {
                        JPanel panel = new JPanel();
                        panel.setBackground(design.getFieldBackground());
                        add(panel);
                        fieldParts[i][z] = panel;
                    }
                }
            }
        }).run();
    }

    /**
     * Changes the Background of a specified JPanel
     * @param row The Row where the JPanel is located
     * @param column The Column where the JPanel is located
     * @param newColor The New Color of the targeted JPanel
     * */
    public void changePartColor(int row, int column, Color newColor) {
        fieldParts[row][column].setBackground(newColor);
    }

}
