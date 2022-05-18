package com.paintify.editor;
import java.awt.Image;
import java.awt.Graphics;


import javax.swing.event.MouseInputAdapter;

public abstract class DrawingController extends MouseInputAdapter{
    Image image;
    ImageViewer viewer;
    Graphics graphics;

    protected DrawingController(ImageViewer viewer){
        this.viewer=viewer;
        this.image=viewer.getImage();
        this.graphics=image.getGraphics();
    }

}