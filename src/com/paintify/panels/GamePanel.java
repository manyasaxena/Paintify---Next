package com.paintify.panels;

import javax.swing.JScrollPane;

import com.paintify.controllers.DrawingController;

import java.awt.Dimension;
import java.util.HashMap;
import java.awt.Cursor;
import java.awt.Toolkit;


public class GamePanel extends JScrollPane {
    ImageEditor editor=null;
    public ImageEditor getEditor(){

        return editor;
    }

    public GamePanel(){
        setPreferredSize(new Dimension(1024, 768));
        editor = new ColorPuzzle();
        editor.loadImage("/images/pond.png");

        setViewportView(editor);
    }

}

