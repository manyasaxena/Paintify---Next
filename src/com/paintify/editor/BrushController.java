package com.paintify.editor;

import java.awt.event.MouseEvent;
import java.awt.Color;

public class BrushController extends DrawingController {

    public BrushController(ImageViewer viewer){
        super(viewer);
    }

    private void drawBrush(int x, int y){
        DrawingConfig config=DrawingConfig.getInstance();

        Integer brushSize=(Integer)config.getConfig("brush.size");
        int brushSizeSimple = brushSize.intValue();

        graphics.setColor((Color)config.getConfig("color.fg"));
        graphics.fillOval(x-brushSizeSimple, y-brushSizeSimple, brushSizeSimple*2, brushSizeSimple*2);
        viewer.repaint();

    }

    @Override
    public void mousePressed(MouseEvent e){
        drawBrush(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e){
        viewer.setCurrentX(e.getX());
        viewer.setCurrentY(e.getY());
        viewer.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        drawBrush(e.getX(), e.getY());
    }
    
}
