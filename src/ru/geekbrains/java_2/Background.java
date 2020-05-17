package ru.geekbrains.java_2;

import javax.swing.*;
import java.awt.*;

public class Background  extends JPanel {
    private float sumTime = 0;
    private float backgroundTime = 1;

    void setColor (MainCanvas canvas, float deltaTime) {
        sumTime += deltaTime;
        if (sumTime >= backgroundTime) {
            canvas.setBackground(new Color((int) (Math.random() * 255),
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255)));
            sumTime = 0;
        }
    }
}
