package com.paintify;


import java.awt.Color;
import java.io.File;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.image.*;

import com.paintify.picture.*;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.  This is a great lesson for learning 
 * about 2D arrays and the Color class.
 * 
 * @author Barbara Ericson and altered by Richard Hanson
 */
public class PictureTester
{
  private static JPanel panel;
  public static final String ROOT_PICS_INPUT =  "/home/runner/Picture-Lab/images/";
  public static final String ROOT_PICS_OUTPUT =  "/home/runner/Picture-Lab/processed/";

	/** Main method for testing.  Every class can have a main
	 * method in Java */
	public static void main(String[] args)	{
   //  panel = new JPanel() {
		 //  @Override
  	// 	public void paintComponent(Graphics g) {
  	// 		super.paintComponent(g);
  	// 		testColorFill(g);
			//   // panel.getToolkit().sync();
		 //  }
	  // };
    // testEdgeDetection(g);
		
    // testFillSection();
    // original();
    testFill();

  
	}


  public static void original() {
  //   Picture swan = new Picture("flower.jpeg");
		// // write this method in Picture class
		// swan.explore();
  }

  public static void testFill() {
    Picture swan = Picture.getInstance("./src/avacado.jpeg");
		swan.explore();
    // Pixel p = new Pixel(swan, swan.getX(), swan.getY());
    // Color c = p.getColor();
    // swan.fill(swan.getBufferedImage(), 1, 1, c, Color.red);
    // swan.explore();

    
  }


  public static void testFillSection() {
    // Picture square = new Picture("Square.png");
		// write this method in Picture class
		//square.fillSection();
		// square.explore();
  }

	public static void testColorFill(Graphics g){
    // Picture flo = new Picture("flower.jpeg");
  //   flo.explore();
		// ColorFill flower = new ColorFill();
  //   Graphics2D g2 = (Graphics2D) g;
		// g2.setColor(Color.RED);
  //   g2.drawRect(x,y,1,1);

    //File pic = new File("flower.jpeg");
		// flower.paint(g);

		  //   Graphics g1 = null;
    // a.paint(g1)
	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection()
	{

		//Picture swan = new Picture("Square.png");
  //   Picture swan = new Picture("flower.jpeg");
    
		// // written in Picture class
		// swan.edgeDetection(225);
		
		// swan.write("outside outline.png");// writes the new picture to a new file
	}
	/**
	 * Checks to see if row and col are within the Picture pic
	 * @param pic Picture we are checking
	 * @param row Row in pic
	 * @param col Col in pic
	 * @return true if row and col are valid for pic, false otherwise
	 */
	public boolean inbounds(Picture pic, int row, int col) {
		return false;
	}
	



	
}