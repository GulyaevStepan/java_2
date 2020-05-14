package ru.geekbrains.java_2;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {

    MainWindow gameController;
    long lastFrame;
    int countBackground = 0;
    int speedBackground = 60;

    MainCanvas(MainWindow gameController) {
        this.gameController = gameController;
        lastFrame = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrame) * 0.000000001f;
        gameController.onDrawFrame(this, g, deltaTime);
        lastFrame = currentTime;
        ++countBackground;
        if (countBackground == speedBackground) {
            setBackground(new Color((int) (Math.random() * 255),
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255)));
            countBackground = 0;
        }
        /*
        * Будем считать разы проходов paintComponent-а.
        * Внимание, если поменять Thread.sleep(17);,
        * то скорость смены фона тоже поменяется.
        * */
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }


    public int getLeft() { return 0; }

    public int getRight() { return getWidth() - 1; }

    public int getTop() { return 0; }

    public int getBottom() { return getHeight() - 1; }
}
