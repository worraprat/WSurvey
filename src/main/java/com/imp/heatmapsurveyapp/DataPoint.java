/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.imp.heatmapsurveyapp;

import java.util.HashMap;

/**
 *
 * @author dml
 */
public class DataPoint {
    
    public static final int POINT = 1;
    public static final int ROUTER = 10;
    
    public int number;
    public int type;
    public int x, y;
    
    public float value;
    
    public HashMap<String,Float> layers;
            
    
    
    public DataPoint(int in_x, int in_y, float in_v) {
        type = POINT;
        x = in_x;
        y = in_y;
        value = in_v;
    }
    
    public DataPoint(int in_type, int in_x, int in_y, float in_v) {
        type = in_type;
        x = in_x;
        y = in_y;
        value = in_v;
    }

    public float getValue(String layer_name) {
        
        if (layers != null && layers.containsKey(layer_name))
            return layers.get(layer_name);
        return value;
    }
    
}
