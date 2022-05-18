package com.paintify.editor;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import com.paintify.ImageDisplay;

import java.awt.Graphics;
import java.awt.Color;

public class EraserController extends DrawingController {

    public EraserController(ImageViewer viewer){
        super(viewer);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        graphics.setColor(Color.WHITE);
        graphics.fillOval(e.getX()-10, e.getY()-10, 10, 10);
        viewer.repaint();
    }

}
