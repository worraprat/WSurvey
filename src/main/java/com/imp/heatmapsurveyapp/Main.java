package com.imp.heatmapsurveyapp;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dml
 */
public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        
        MainFrame frame = new MainFrame();        
        frame.setLocationRelativeTo(null);
        
        frame.addPage(new StartPage(), "StartPage");        
        frame.addPage(new PlannerPage(), "PlannerPage");
        frame.addPage(new InstructPage(), "InstructPage");
        frame.setTitle("Heatmap Survey");
        
        frame.switchTo("StartPage");        
//        frame.switchTo("PlannerPage");        
        frame.setVisible(true);
        
    }
}
