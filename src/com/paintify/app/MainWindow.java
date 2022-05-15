package com.paintify.app;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.paintify.ImageDisplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.image.BufferedImage;
import java.io.IOException;
 
public class MainWindow {
    private static MainWindow instance=null;
    private JFrame mainFrame;
    public static boolean RIGHT_TO_LEFT = false;

    private static JButton createImageButton(String iconFilePath){
        JButton button;
        ImageIcon bIcon;

        bIcon=new ImageIcon(MainWindow.class.getResource(iconFilePath));
        button = new JButton(bIcon);
        button.setBackground(Color.WHITE);
        button.setOpaque(false);
        button.setMargin(new Insets(1,1,1,1));
        button.addActionListener((ActionListener) new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        return button;
    }

    private void setUpMenuBar()
  {

  // menu components
  /** menu bar */
   JMenuBar menuBar;
  /** zoom menu */
   JMenu zoomMenu;
  /** 25% zoom level */
   JMenuItem twentyFive;
  /** 50% zoom level */
   JMenuItem fifty;
  /** 75% zoom level */
   JMenuItem seventyFive;
  /** 100% zoom level */
   JMenuItem hundred;
  /** 150% zoom level */
   JMenuItem hundredFifty;
  /** 200% zoom level */
   JMenuItem twoHundred;
  /** 500% zoom level */
   JMenuItem fiveHundred;    
    //create menu
    menuBar = new JMenuBar();
    
    
    
    zoomMenu = new JMenu("Zoom");
    twentyFive = new JMenuItem("25%");
    fifty = new JMenuItem("50%");
    seventyFive = new JMenuItem("75%");
    hundred = new JMenuItem("100%");
    hundred.setEnabled(false);
    hundredFifty = new JMenuItem("150%");
    twoHundred = new JMenuItem("200%");
    fiveHundred = new JMenuItem("500%");
    
    // add the action listeners
    twentyFive.addActionListener(AppController.getInstance());
    fifty.addActionListener(AppController.getInstance());
    seventyFive.addActionListener(AppController.getInstance());
    hundred.addActionListener(AppController.getInstance());
    hundredFifty.addActionListener(AppController.getInstance());
    twoHundred.addActionListener(AppController.getInstance());
    fiveHundred.addActionListener(AppController.getInstance());
    
    // add the menu items to the menus
    zoomMenu.add(twentyFive);
    zoomMenu.add(fifty);
    zoomMenu.add(seventyFive);
    zoomMenu.add(hundred);
    zoomMenu.add(hundredFifty);
    zoomMenu.add(twoHundred);
    zoomMenu.add(fiveHundred);
    menuBar.add(zoomMenu);
    
    // setUpSelectType();
    
    // set the menu bar to this menu
    mainFrame.setJMenuBar(menuBar);
  }
     
    private void createLayout(Container pane) {
         
        if (!(pane.getLayout() instanceof BorderLayout)) {
            pane.add(new JLabel("Container doesn't use BorderLayout!"));
            return;
        }
         
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(
                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        }

        JPanel drawingModes=new JPanel();
            drawingModes.add(new JLabel(new ImageIcon(MainWindow.class.getResource("/images/logo.png"))), JLabel.LEFT_ALIGNMENT);
            drawingModes.add(createImageButton("/images/buttons/icons8-fill-color-50.png"));
            drawingModes.add(createImageButton("/images/buttons/icons8-illustrator-50.png"));

        pane.add(drawingModes, BorderLayout.PAGE_START);
         
        //Make the center component big, since that's the
        //typical usage of BorderLayout.

/*        JButton button;

        button = new JButton("Button 2 (CENTER)");
        button.setPreferredSize(new Dimension(1024, 768));
        pane.add(button, BorderLayout.CENTER); */

        ////////////////
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(1024, 768));
        scrollPane.setBackground(Color.BLACK);
        scrollPane.setOpaque(false);

        BufferedImage bi=null;
        try {
            bi = ImageIO.read(MainWindow.class.getResource("/images/avacado.jpeg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ImageDisplay imageDisplay = new ImageDisplay(bi);
        scrollPane.setViewportView(imageDisplay);
        imageDisplay.setToolTipText("Click a mouse button on a pixel to see the pixel information");
        imageDisplay.setBackground(Color.BLACK);
        imageDisplay.setOpaque(true);

        pane.add(scrollPane, BorderLayout.CENTER);


        ////////////////
         
        JButton button = new JButton("Button 3 (LINE_START)");
        pane.add(button, BorderLayout.LINE_START);
         
        button = new JButton("Long-Named Button 4 (PAGE_END)");
        pane.add(button, BorderLayout.PAGE_END);
         
        button = new JButton("5 (LINE_END)");
        pane.add(button, BorderLayout.LINE_END);
    }
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private void createAndShowGUI() {
         
        //Create and set up the window.
        mainFrame = new JFrame("Painterly");

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        createLayout(mainFrame.getContentPane());
        //Use the content pane's default BorderLayout. No need for
        //setLayout(new BorderLayout());
        //Display the window.
        setUpMenuBar();


        mainFrame.pack();
        mainFrame.setVisible(true);

    }

    private static MainWindow getInstance(){
        if (instance==null)
        {
            instance=new MainWindow();
        }
        return instance;
    }
     
    public static void main(String[] args) {
      System.out.println("Test");
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use bold fonts */
        // UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainWindow.getInstance().createAndShowGUI();
            }
        });
    }
}