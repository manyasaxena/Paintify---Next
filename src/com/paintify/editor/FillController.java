package com.paintify.editor;
import java.awt.event.MouseEvent;
import java.util.Stack;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Color;

public class FillController extends DrawingController {

    public FillController(ImageViewer viewer){
        super(viewer);
    }

    private void fillColor(int x, int y, Color col){

        Rectangle rectBounds = new Rectangle(0,0,image.getWidth(), image.getHeight());
        Stack<Point> stack=new Stack<Point>();

        stack.push(new Point(x,y));
        Color startingColor = new Color(image.getRGB(x,y));

        while (!stack.isEmpty()){
            Point currentPoint = stack.pop();
            if (stack.size()>100000) break;

            if (rectBounds.contains(currentPoint)){
                Color currentColor=new Color(image.getRGB(currentPoint.x, currentPoint.y));
                if ((Math.abs(currentColor.getGreen() - startingColor.getGreen())<30) &&
                (Math.abs(currentColor.getBlue() - startingColor.getBlue())<30) && 
                (Math.abs(currentColor.getRed() - startingColor.getRed())<30))
                {
                    image.setRGB(currentPoint.x, currentPoint.y, col.getRGB());

                    stack.push(new Point(currentPoint.x,currentPoint.y+1));
                    stack.push(new Point(currentPoint.x+1,currentPoint.y));
                    stack.push(new Point(currentPoint.x,currentPoint.y-1));
                    stack.push(new Point(currentPoint.x-1,currentPoint.y));
                }
            }
        }        

    }

    @Override
    public void mousePressed(MouseEvent e){
        DrawingConfig config=DrawingConfig.getInstance();
        Color chosen = (Color)config.getConfig("color.fg");

        ImageEditor editor = viewer.getEditor();

        if (editor instanceof ColorCompareEditor){
            ColorCompareEditor ccEditor = (ColorCompareEditor) editor;
            if (ccEditor.isColorMatch(e.getX(),e.getY(), chosen)){
                fillColor(e.getX(),e.getY(), chosen);
            }
        }else
            fillColor(e.getX(),e.getY(), chosen);

        viewer.repaint();
    }
    
}

