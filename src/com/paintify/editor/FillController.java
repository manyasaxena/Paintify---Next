package com.paintify.editor;
import java.awt.event.MouseEvent;
import java.util.Stack;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;


import java.awt.Color;
import java.awt.Graphics;

public class FillController extends DrawingController {

    public FillController(ImageViewer viewer){
        super(viewer);
    }    

    @Override
    public void mousePressed(MouseEvent e){
        DrawingConfig config=DrawingConfig.getInstance();


        Rectangle rectBounds = new Rectangle(0,0,image.getWidth(), image.getHeight());
        Color chosen = (Color)config.getConfig("color.fg");
        Stack<Point> stack=new Stack<Point>();

        stack.push(new Point(e.getX(),e.getY()));
        Color startingColor = new Color(image.getRGB(e.getX(), e.getY()));

        while (!stack.isEmpty()){
            Point currentPoint = stack.pop();

            if (rectBounds.contains(currentPoint)){
                Color currentColor=new Color(image.getRGB(currentPoint.x, currentPoint.y));
                if ((Math.abs(currentColor.getGreen() - startingColor.getGreen())<30) &&
                (Math.abs(currentColor.getBlue() - startingColor.getBlue())<30) && 
                (Math.abs(currentColor.getRed() - startingColor.getRed())<30))
                {
                    image.setRGB(currentPoint.x, currentPoint.y, chosen.getRGB());

                    stack.push(new Point(currentPoint.x,currentPoint.y+1));
                    stack.push(new Point(currentPoint.x+1,currentPoint.y));
                    stack.push(new Point(currentPoint.x,currentPoint.y-1));
                    stack.push(new Point(currentPoint.x-1,currentPoint.y));
                }
                

            }

        }
        viewer.repaint();
    }
    
}

