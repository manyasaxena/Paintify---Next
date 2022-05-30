package com.paintify.controllers;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import com.paintify.panels.ColorPuzzle;
import com.paintify.panels.GamePanel;

import java.awt.Graphics;
import java.awt.Color;

public class EraserController extends DrawingController {

    public EraserController(ColorPuzzle puzzle){
        super(puzzle);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics graphics = getGraphics();
                
        graphics.setColor(Color.WHITE);
        graphics.fillOval(e.getX()-10, e.getY()-10, 10, 10);
        puzzle.repaint();
    }

}
