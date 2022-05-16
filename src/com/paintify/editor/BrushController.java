package com.paintify.editor;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import com.paintify.ImageDisplay;

import java.awt.Color;
import java.awt.Graphics;

public class BrushController implements DrawingController {

    BufferedImage imageCanvas;
    ImageDisplay imageDisplay;

    public BrushController(BufferedImage img, ImageDisplay imageDisplay){
        this.imageCanvas = img;
        this.imageDisplay=imageDisplay;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

        Graphics g = imageCanvas.getGraphics();
        // g.drawRect(e.getX(), e.getY(), 20,20);
        g.setColor(Color.BLACK);
        g.fillOval(e.getX()-10, e.getY()-10, 10, 10);
        imageDisplay.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
