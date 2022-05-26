package com.paintify.editor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.util.HashMap;


public class ImageViewer extends JScrollPane {
    ImageEditor editor=null;
    DrawingController currentController=null;
    HashMap<String,DrawingController> allControllers=new HashMap<String,DrawingController>();

    public ImageEditor getEditor(){
        return editor;
    }
    public ImageViewer(){
        // JPanel group=new JPanel();
        setPreferredSize(new Dimension(1024, 768));
        editor = new ColorCompareEditor();
        editor.loadImage("/images/ball.jpeg");

        // ImageEditor ee=new ImageEditor();
        // ee.loadImage("/images/ball.color.jpeg");
        // group.add(ee);
        // group.add(editor);

        setViewportView(editor);
    }
    public void addBrushController(String key, DrawingController controller){
        allControllers.put(key, controller);

        setController(key);
    }

    public void setController(String key){
        if (currentController!=null){
            editor.removeMouseListener(currentController);
            editor.removeMouseMotionListener(currentController);
        }
        currentController=allControllers.get(key);
        editor.addMouseMotionListener(currentController);
        editor.addMouseListener(currentController);
    }

    public void setCurrentX(int x){
        editor.setCurrentX(x);
    }

    public void setCurrentY(int y){
        editor.setCurrentY(y);
    }
}

