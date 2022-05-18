package com.paintify.editor;
import java.awt.event.MouseEvent;
import java.awt.Image;


import java.awt.Color;
import java.awt.Graphics;

public class FillController extends DrawingController {

    public FillController(ImageViewer viewer){
        super(viewer);
    }    

    @Override
    public void mousePressed(MouseEvent e){
        DrawingConfig config=DrawingConfig.getInstance();

        graphics.setColor((Color)config.getConfig("color.fg"));
        
        // graphics.fillRect(e.getX(), e.getY(), 100, 100);
        // viewer.repaint();
        graphics.drawString("Fill", e.getX(), e.getY());
        viewer.repaint();
        System.out.println(e.getX()+" : "+e.getY());
        System.out.println("FILLOOO");
    }
}

