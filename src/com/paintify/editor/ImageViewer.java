package com.paintify.editor;

import javax.swing.JScrollPane;
import java.awt.Color;

import com.paintify.ImageDisplay;

import org.w3c.dom.events.MouseEvent;

import java.awt.Dimension;
import java.awt.event.MouseMotionListener;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageViewer extends JScrollPane {
    Image currentImage=null;
    ImageEditor currentView=null;
    DrawingController currentController=null;
    HashMap<String,DrawingController> allControllers=new HashMap<String,DrawingController>();

    public Image getImage(){
        return currentImage;
    }
    public ImageEditor getCurrentView(){
        return currentView;
    }
    public ImageViewer(){
        setPreferredSize(new Dimension(1024, 768));

        try {
            currentImage = ImageIO.read(ImageViewer.class.getResource("/images/ball.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        currentView = new ImageEditor(currentImage);
        setViewportView(currentView);
    }
    public void addBrushController(String key, DrawingController controller){
        allControllers.put(key, controller);

        setController(key);
    }

    public void setController(String key){
        if (currentController!=null){
            currentView.removeMouseListener(currentController);
            currentView.removeMouseMotionListener(currentController);
        }
        currentController=allControllers.get(key);
        currentView.addMouseMotionListener(currentController);
        currentView.addMouseListener(currentController);
    }

    public void setCurrentX(int x){
        currentView.setCurrentX(x);
    }

    public void setCurrentY(int y){
        currentView.setCurrentY(y);
    }
}

