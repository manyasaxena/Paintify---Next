package com.paintify.app;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputListener;

import java.awt.FlowLayout;

import com.paintify.controllers.BrushController;
import com.paintify.controllers.EraserController;
import com.paintify.controllers.FillController;
import com.paintify.controllers.RectController;
import com.paintify.panels.ColorCompareEditor;
import com.paintify.panels.ColorPalettePicker;
import com.paintify.panels.ImageEditor;
import com.paintify.panels.ImagePanel;

import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Insets;
 
public class MainWindow implements ActionListener{
    private AppConfig config;
    private static MainWindow instance=null;
    private JFrame mainFrame;
    public static boolean RIGHT_TO_LEFT = false;
    private ImagePanel imagePanel = null;

    private MainWindow(){
        config=AppConfig.getInstance();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        imagePanel.setController(e.getActionCommand()); 
               
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
     
    private void createLayout(Container mainWindowPane) {

        AppConfig config=AppConfig.getInstance();

        config.setConfig(AppConfig.FILL_COLOR, Color.RED);
        config.setConfig(AppConfig.BRUSH_SIZE,  Integer.valueOf(10));

         
        if (!(mainWindowPane.getLayout() instanceof BorderLayout)) {
            mainWindowPane.add(new JLabel("Container doesn't use BorderLayout!"));
            return;
        }
        if (RIGHT_TO_LEFT) {
            mainWindowPane.setComponentOrientation(
                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        }

        JPanel controlPanel = createControlPanel();
        mainWindowPane.add(controlPanel, BorderLayout.PAGE_START);

        imagePanel=createEditorPanel();

        mainWindowPane.add(imagePanel, BorderLayout.CENTER);
        
        // No 2 ////////////////
        JPanel toolbar = createToolPanel();
        mainWindowPane.add(toolbar, BorderLayout.LINE_START);
         
        JButton button = new JButton("Footer");
        mainWindowPane.add(button, BorderLayout.PAGE_END);
        // No 4
         
        button = new JButton("Canvas Tools");
        mainWindowPane.add(button, BorderLayout.LINE_END);
        // No 5
    }

    private ImagePanel createEditorPanel() {
        ImagePanel panel = new ImagePanel();
        panel.addBrushController("RECT", new RectController(panel));
        panel.addBrushController("FILL", new FillController(panel));
        panel.addBrushController("ERASER", new EraserController(panel));        
        panel.addBrushController("BRUSH", new BrushController(panel));        

        panel.setController("FILL");
        return panel;
    }

    private JPanel createToolPanel() {
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new BoxLayout(toolbar, BoxLayout.PAGE_AXIS));

            JPanel fill =  new JPanel();

            fill.setBorder(BorderFactory.createEtchedBorder());
            fill.setLayout(new BoxLayout(fill,BoxLayout.Y_AXIS));
            ImageEditor editor = imagePanel.getEditor();

            if (editor instanceof ColorCompareEditor){ // Do we play Color Memory?
                ColorCompareEditor cceditor = (ColorCompareEditor) editor;

                ColorPalettePicker cp=new ColorPalettePicker(cceditor.getReferenceImage());
                fill.add(cp);

            }else{
            // Make color chooser button part of toolbar panel

                JButton btn = new JButton("Choose Color");
                fill.add(btn);

                btn.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
                        config.setConfig("color.fg", newColor);
        
                        btn.setBackground(newColor);
                        
                    }
        
                });            

            }
        toolbar.add(fill);

        // Make Brush Size slider part of new panel     
        JPanel brushTools = new JPanel();
        brushTools.setBorder(BorderFactory.createEtchedBorder());   
            JSlider brushSize = new JSlider(5, 50, 10);
            brushSize.addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent e) {
                    // TODO Auto-generated method stub
                    JSlider source = (JSlider)e.getSource();
                    if (!source.getValueIsAdjusting()) {
                        int ibrushSize = (int)source.getValue();
                        config.setConfig("brush.size", Integer.valueOf(ibrushSize));
                    }   
                }
                
            });

            brushTools.add(brushSize);            

        toolbar.add(brushTools);
        return toolbar;
    }

    private JPanel createControlPanel() {
        JPanel controlPanel =new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        //  Add Logo
        controlPanel.add(new JLabel(new ImageIcon(MainWindow.class.getResource("/images/logo.png"))), JLabel.LEFT_ALIGNMENT);

        // Add a bunch of Drawing Operations you can perform
        controlPanel.add(createImageButton("FILL","/images/buttons/icons8-fill-color-50.png"));
        controlPanel.add(createImageButton("BRUSH","/images/buttons/icons8-illustrator-50.png"));
        controlPanel.add(createImageButton( "ERASER", "/images/buttons/icons8-eraser-50.png"));
        // Adding the Top Drawing Modes to the Main Frame Panel 
        return controlPanel;
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
}