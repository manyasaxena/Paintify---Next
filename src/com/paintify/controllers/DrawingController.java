package com.paintify.controllers;
import java.awt.image.BufferedImage;
import java.awt.Graphics;


import javax.swing.event.MouseInputAdapter;

import com.paintify.panels.ImagePanel;

public abstract class DrawingController extends MouseInputAdapter{
    protected BufferedImage image;
    ImagePanel viewer;
    Graphics graphics;

    protected DrawingController(ImagePanel viewer){
        this.viewer=viewer;
        this.image=(BufferedImage)viewer.getEditor().getImage();
        this.graphics=image.getGraphics();
    }

}