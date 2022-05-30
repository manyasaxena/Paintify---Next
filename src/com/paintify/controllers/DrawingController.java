package com.paintify.controllers;
import java.awt.image.BufferedImage;
import java.awt.Graphics;


import javax.swing.event.MouseInputAdapter;

import com.paintify.panels.ColorPuzzle;

public abstract class DrawingController extends MouseInputAdapter{
    ColorPuzzle puzzle;

    protected DrawingController(ColorPuzzle puzzle){
        this.puzzle=puzzle;
    }

    protected Graphics getGraphics(){
        return puzzle.getImage().getGraphics();
    }

    protected BufferedImage getImage(){
        return puzzle.getImage();
    }

}