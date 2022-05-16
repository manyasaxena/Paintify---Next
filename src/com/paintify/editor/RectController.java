package com.paintify.editor;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import com.paintify.ImageDisplay;

import java.awt.Color;
import java.awt.Graphics;

public class RectController implements DrawingController {

    BufferedImage imageCanvas;
    ImageDisplay imageDisplay;

    int startX, startY, endX, endY;

    public RectController(BufferedImage img, ImageDisplay imageDisplay){
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
        g.drawRect(startX, startY, endX - startX, endY - startY);
        imageDisplay.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        startX = e.getX();
        startY = e.getY();
        System.out.println(startX + ":" +  startY); 
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        endX = e.getX();
        endY = e.getY();
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
