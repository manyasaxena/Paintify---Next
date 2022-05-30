package com.paintify.controllers;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import com.paintify.panels.ColorPuzzle;
import com.paintify.panels.GamePanel;

import java.awt.Color;
import java.awt.Graphics;

public class RectController extends DrawingController {

    int startX=0, startY=0;
    int endX=0, endY=0;    

    public RectController(ColorPuzzle puzzle){
        super(puzzle);
    }

    @Override
    public void mousePressed(MouseEvent e){
        startX=e.getX();
        startY=e.getY();        
    }

    @Override
    public void mouseMoved(MouseEvent e){
        puzzle.setCurrentX(e.getX());
        puzzle.setCurrentY(e.getY());
        puzzle.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics graphics = getGraphics();        
        endX=e.getX();
        endY=e.getY();
        if ((startX<endX) &&  (startY<endY)){
            graphics.setColor(Color.RED);
            graphics.drawRect(startX, startY, endX-startX,endY-startY);
            puzzle.repaint();
        }
        System.out.println(e.getX()+" : "+e.getY());
        
    }
    
}
