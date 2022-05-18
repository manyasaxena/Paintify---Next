package com.paintify.app;

import javax.swing.*;
import java.awt.FlowLayout;

import com.paintify.editor.BrushController;
import com.paintify.editor.DrawingConfig;
import com.paintify.editor.EraserController;
import com.paintify.editor.FillController;
import com.paintify.editor.ImageViewer;
import com.paintify.editor.RectController;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Insets;
 
public class MainWindow implements ActionListener{
    private static MainWindow instance=null;
    private JFrame mainFrame;
    public static boolean RIGHT_TO_LEFT = false;
    private ImageViewer viewer = null;

    private MainWindow(){

    }

    private JButton createImageButton(String actionKey, String iconFilePath){
        JButton button;
        ImageIcon bIcon;

        bIcon=new ImageIcon(MainWindow.class.getResource(iconFilePath));
        button = new JButton(bIcon);
        button.setActionCommand(actionKey);
        button.addActionListener(this);

        button.setBackground(Color.WHITE);
        button.setOpaque(false);
        button.setMargin(new Insets(1,1,1,1));
        return button;
    }
     
    private void createLayout(Container pane) {

        DrawingConfig config=DrawingConfig.getInstance();

        config.setConfig("color.fg", Color.RED);
        config.setConfig("brush.size",  Integer.valueOf(50));


         
        if (!(pane.getLayout() instanceof BorderLayout)) {
            pane.add(new JLabel("Container doesn't use BorderLayout!"));
            return;
        }
         
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(
                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        }

        JPanel drawingModes=new JPanel();
            drawingModes.setLayout(new FlowLayout(FlowLayout.LEFT));
        //  Add Logo
            drawingModes.add(new JLabel(new ImageIcon(MainWindow.class.getResource("/images/logo.png"))), JLabel.LEFT_ALIGNMENT);

        // Add a bunch of Drawing Operations you can perform
            drawingModes.add(createImageButton("FILL","/images/buttons/icons8-fill-color-50.png"));
            drawingModes.add(createImageButton("BRUSH","/images/buttons/icons8-illustrator-50.png"));
            drawingModes.add(createImageButton( "ERASER", "/images/buttons/icons8-eraser-50.png"));
        // Adding the Top Drawing Modes to the Main Frame Panel 
        pane.add(drawingModes, BorderLayout.PAGE_START);
         
        //Make the center component big, since that's the
        //typical usage of BorderLayout.

       viewer = new ImageViewer();
        viewer.addBrushController("RECT", new RectController(viewer));
        viewer.addBrushController("FILL", new FillController(viewer));
        viewer.addBrushController("ERASER", new EraserController(viewer));        
        viewer.addBrushController("BRUSH", new BrushController(viewer));        

        viewer.setController("FILL");

        pane.add(viewer, BorderLayout.CENTER);
        
        // No 2

        ////////////////
         
        JButton button = new JButton("Tools");
        pane.add(button, BorderLayout.LINE_START);
        // No 3
         
        button = new JButton("Footer");
        pane.add(button, BorderLayout.PAGE_END);
        // No 4
         
        button = new JButton("Canvas Tools");
        pane.add(button, BorderLayout.LINE_END);
        // No 5
    }
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private void createAndShowGUI() {
         
        //Create and set up the window.
        mainFrame = new JFrame("Paintify");

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        createLayout(mainFrame.getContentPane());
        //Use the content pane's default BorderLayout. No need for
        //setLayout(new BorderLayout());
        //Display the window.


        mainFrame.pack();
        mainFrame.setVisible(true);

    }

    public static MainWindow getInstance(){
        if (instance==null)
        {
            instance=new MainWindow();
        }
        return instance;
    }
     
    public static void main(String[] args) {
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
                // This is where everything gets Started
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        viewer.setController(e.getActionCommand()); 
               
    }
}