package com.paintify.editor;

import java.awt.event.MouseEvent;
import java.util.Stack;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Graphics;

import com.paintify.picture.SimplePicture;
import com.paintify.picture.Pixel;

public class NumColor extends DrawingController {

    private Pixel[][] result;

    public NumColor(ImageViewer img) {
        super(img);
        answerKey();
    }

    public void answerKey() {
        SimplePicture coloredPic = new SimplePicture("ballResult.jpg");
        result = coloredPic.getPixels2D();
    }

    public boolean checkClick(int x, int y, Color c) {
        if (result[x][y].getColor().equals(c)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "That color doesn't match the key!", "Wrong Color!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void changeColor(int x, int y, Color c) {
        if (checkClick(x, y, c)) {
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // displayPixelInformation(e);

        DrawingConfig config = DrawingConfig.getInstance();

        Rectangle rectBounds = new Rectangle(0, 0, image.getWidth(), image.getHeight());
        Color chosen = (Color) config.getConfig("color.fg");
        Stack<Point> stack = new Stack<Point>();

        stack.push(new Point(e.getX(), e.getY()));
        Color startingColor = new Color(image.getRGB(e.getX(), e.getY()));

        while (!stack.isEmpty()) {
            Point currentPoint = stack.pop();

            if (rectBounds.contains(currentPoint)) {
                Color currentColor = new Color(image.getRGB(currentPoint.x, currentPoint.y));
                if ((Math.abs(currentColor.getGreen() - startingColor.getGreen()) < 200)
                        && (Math.abs(currentColor.getBlue() - startingColor.getBlue()) < 200)
                        && (Math.abs(currentColor.getRed() - startingColor.getRed()) < 200)) {
                    image.setRGB(currentPoint.x, currentPoint.y, chosen.getRGB());

                    stack.push(new Point(currentPoint.x, currentPoint.y + 1));
                    stack.push(new Point(currentPoint.x + 1, currentPoint.y));
                    stack.push(new Point(currentPoint.x, currentPoint.y - 1));
                    stack.push(new Point(currentPoint.x - 1, currentPoint.y));
                }

            }

        }
        viewer.repaint();
    }

}
