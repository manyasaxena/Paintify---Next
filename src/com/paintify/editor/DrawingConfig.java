package com.paintify.editor;

import java.util.HashMap;

public class DrawingConfig{
    HashMap<String,Object> config=new HashMap<String,Object>();

    static DrawingConfig instance = null;

    // static final String FG_COLOR="fg.color";

    public static DrawingConfig getInstance(){
        if (instance==null)
            instance = new DrawingConfig();
        return instance;
    }

    public void setConfig(String key, Object value){
        config.put(key, value);

    }

    public Object getConfig(String key){
        return config.get(key);
    }    
}
