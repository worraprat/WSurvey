/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.imp.heatmapsurveyapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author dml
 */
public class WifiStats {
    
    public static final String ShowInterfaceCommand = "netsh wlan show network mode=bssid";
    //public static final String ShowInterfaceCommand = "type wifi.txt";
    
    /*
    Windows  Wifi Signal Strength Calculation:
    https://docs.microsoft.com/en-us/windows/win32/api/wlanapi/ns-wlanapi-wlan_association_attributes?redirectedfrom=MSDN
    
        quality = 2 * (dBm + 100)  where dBm: [-100 to -50]
        dBm = (quality / 2) - 100  where quality: [0 to 100]
        
    */
    
    
    public class WifiNetwork extends HashMap<String, String>
    {
        public String getSSID() {
            return this.get("SSID");
        }
        
        public float getSignal() {
            String text  = this.get("SIGNAL");            
            if (text.endsWith("%"))
                text = text.substring(0, text.length()-1);

            float result = -1;
            try {
                System.out.println("signal: " + text);
                result = Float.parseFloat(text);
            } catch(Exception ex) {
                
            }
            return result;            
        }
        
        public float getRSSI() {
            float quality = getSignal();
            if (quality == -1)
                return -100;
            return (quality / 2) - 50;
        }       

        @Override
        public String toString() {
            
            return String.format("%s | %.0f%% | %.1fdBm", getSSID(), getSignal(), getRSSI() );
        }
        
        
    }
    
    
    public HashMap<String, WifiNetwork> GetNetworks() throws IOException
    {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", ShowInterfaceCommand);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        
        HashMap<String, WifiNetwork> results = new HashMap<String, WifiNetwork>();
        WifiNetwork network = null;
        System.out.println("start");        
        
        int line_count = 0;
        String line;
        String SSID = null;
        while ( (line = r.readLine()) != null) {
            
            //System.out.println(line);
            
            if (line.startsWith("SSID")) {
                network = new WifiNetwork();
                
                String[] values = line.split(":");                
                if (values != null && values.length == 2) {                    
                    String key = values[0].trim().toUpperCase();
                    String value = values[1].trim();              
                    
                    SSID = key;
                    network.put("SSID", value);                    
                    results.put(SSID, network);
                }
                
                
                
            } 
            else if (SSID != null && network != null) {
                String[] values = line.split(":", 2);
                if (values != null && values.length >= 2) {                    
                    String key = values[0].trim().toUpperCase();
                    String value = values[1].trim();   
                                        
                    if ("BSSID 1".equals(key)) {    
                        key = "BSSID";
                    }
                    
                    if ("BSSID 2".equals(key)) {    
                        SSID = null;
                        network = null;
                        continue;
                        
                    } else {                    
                        
                        System.out.println(key + "=" + value);
                        network.put(key, value);
                    }
                }                
            }
            line_count++;
        }
        System.out.println("termi");
        
        
        return results;
    }
            
}
