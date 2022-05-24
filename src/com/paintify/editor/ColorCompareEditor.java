package com.paintify.editor;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.IOException;

public class ColorCompareEditor extends ImageEditor {
    private BufferedImage imageReference;

    public void loadImage(String str){
        super.loadImage(str);
        int indexExtn = str.indexOf(".jpeg");
        String colorImageFile = str.substring(0, indexExtn) + ".color" + str.substring(indexExtn);
        try {
            imageReference = ImageIO.read(ImageEditor.class.getResource(colorImageFile));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  


    }
    
    public boolean isColorMatch(int x, int y, Color fillColor){
        Color colorAt = new Color(imageReference.getRGB(x,y));

        return ((Math.abs(fillColor.getGreen() - colorAt.getGreen())<60) &&
        (Math.abs(fillColor.getBlue() - colorAt.getBlue())<60) && 
        (Math.abs(fillColor.getRed() - colorAt.getRed())<60));  
    }  
}
