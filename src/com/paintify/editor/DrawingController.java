package com.paintify.editor;
import java.awt.image.BufferedImage;
import java.awt.Graphics;


import javax.swing.event.MouseInputAdapter;

public abstract class DrawingController extends MouseInputAdapter{
    BufferedImage image;
    ImageViewer viewer;
    Graphics graphics;

    protected DrawingController(ImageViewer viewer){
        this.viewer=viewer;
        this.image=(BufferedImage)viewer.getEditor().getImage();
        this.graphics=image.getGraphics();
    }

}