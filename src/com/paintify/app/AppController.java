package com.paintify.app;
import java.awt.event.*;

public class AppController implements ActionListener {

    private static AppController instance=null;
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    public static AppController getInstance(){
        if (instance==null)
        {
            instance=new AppController();
        }
        return instance;
    }    
}
