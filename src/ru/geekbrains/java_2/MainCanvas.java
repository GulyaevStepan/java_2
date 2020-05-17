package ru.geekbrains.java_2;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {

    MainWindow gameController;
    long lastFrame;
    Background background;

    MainCanvas(MainWindow gameController) {
        this.gameController = gameController;
        lastFrame = System.nanoTime();
        background = new Background();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrame) * 0.000000001f;
        gameController.onDrawFrame(this, g, deltaTime);
        lastFrame = currentTime;
        background.setColor(this, deltaTime);
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
