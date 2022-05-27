package com.paintify.editor;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.paintify.editor.color.ColorPalettePicker;

import java.awt.*;
import java.awt.image.*;
import java.io.IOException;

public class ColorCompareEditor extends ImageEditor {
    private BufferedImage imageReference;

    public BufferedImage getReferenceImage(){
        return imageReference;

    }

    public void loadImage(String str){
        super.loadImage(str);
        int indexExtn = str.indexOf(".png");
        String colorImageFile = str.substring(0, indexExtn) + ".color" + str.substring(indexExtn);
        try {
            imageReference = ImageIO.read(ImageEditor.class.getResource(colorImageFile));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  

        ColorPalettePicker cp=new ColorPalettePicker(imageReference);


    }
    
    public boolean isColorMatch(int x, int y, Color fillColor){
        Color colorAt = new Color(imageReference.getRGB(x,y));
        // float[] hsbValsColorAt = new float[3];

        // Color.RGBtoHSB(colorAt.getRed(),colorAt.getGreen(),colorAt.getBlue(),hsbValsColorAt);

        // float [] hsbValsFillColor = new float[3];

        // Color.RGBtoHSB(fillColor.getRed(),fillColor.getGreen(),fillColor.getBlue(),hsbValsFillColor);
        // int fillHue = (int)((hsbValsFillColor[0])*360) /30*30;
        // int colorAtHue = (int)((hsbValsColorAt[0])*360) /30*30;
        // return (fillHue  == colorAtHue);


        return ((Math.abs(fillColor.getGreen() - colorAt.getGreen())<60) &&
        (Math.abs(fillColor.getBlue() - colorAt.getBlue())<60) && 
        (Math.abs(fillColor.getRed() - colorAt.getRed())<60));  
    }  
}
