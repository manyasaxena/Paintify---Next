package com.paintify.controllers;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import com.paintify.panels.ImagePanel;

import java.awt.Graphics;
import java.awt.Color;

public class EraserController extends DrawingController {

    public EraserController(ImagePanel viewer){
        super(viewer);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(e.getX()-10, e.getY()-10, 10, 10);
        viewer.repaint();
    }

}
