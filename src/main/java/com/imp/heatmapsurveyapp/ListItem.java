/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.imp.heatmapsurveyapp;

/**
 *
 * @author dml
 */
public class ListItem
{
    String name;
    Object data;
    String text;

    public ListItem(String in_name, Object in_data) {
        this.name = in_name;
        this.data = in_data;
    }

    @Override
    public String toString() {
        return (text == null) ? name : text;
    }                
}

