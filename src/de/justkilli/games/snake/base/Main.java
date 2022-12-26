package de.justkilli.games.snake.base;

import de.justkilli.games.snake.game.Design;
import de.justkilli.games.snake.game.gamefield.BaseField;
import de.justkilli.games.snake.game.gamefield.FieldSize;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Design design = new Design();
        design.setFieldBackground(new Color(0, 100, 0));
        BaseField baseField = new BaseField(new FieldSize(Toolkit.getDefaultToolkit().getScreenSize(), 20), design);
        baseField.setVisible(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++) {
                    baseField.changePartColor(i, i, Color.BLUE);
                    baseField.changePartColor((i > 0 ? i - 1 : 0), (i > 0 ? i - 1 : 0), design.getFieldBackground());
                    try {
                        Thread.currentThread().sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }).run();
    }
}