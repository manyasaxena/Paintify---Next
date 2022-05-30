package com.paintify.controllers;

import java.awt.event.MouseEvent;

import com.paintify.app.AppConfig;
import com.paintify.panels.ColorPuzzle;

import java.awt.Color;
import java.awt.Graphics;

public class BrushController extends DrawingController {

    public BrushController(ColorPuzzle puzzle){
        super(puzzle);
    }

    private void drawBrush(int x, int y){

        Graphics graphics = getGraphics();
        AppConfig config=AppConfig.getInstance();

        Integer brushSize=(Integer)config.getConfig(AppConfig.BRUSH_SIZE);
        int brushSizeSimple = brushSize.intValue();

        graphics.setColor((Color)config.getConfig(AppConfig.FILL_COLOR));
        graphics.fillOval(x-brushSizeSimple, y-brushSizeSimple, brushSizeSimple*2, brushSizeSimple*2);
        puzzle.repaint();

    }

    @Override
    public void mousePressed(MouseEvent e){
        drawBrush(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e){
        puzzle.setCurrentX(e.getX());
        puzzle.setCurrentY(e.getY());
        puzzle.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        drawBrush(e.getX(), e.getY());
    }
    
}
