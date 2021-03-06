/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.imp.heatmapsurveyapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author dml
 */
public class PlannerPage extends javax.swing.JPanel implements MouseListener, HeatMapPanel.OnEventListener, LayersPanel.LayerListSelectionListener {

    private static final int POINT_SIZE = 8;
    private static final int ICON_SIZE = 32;
    
    private float currentValue;
    private HashMap<String, WifiStats.WifiNetwork> currentNetworks;
    private HashMap<String, Float> currentLayers;

    /**
     * Creates new form PlannerPanel
     */
    public PlannerPage() {
        initComponents();
        initPanel();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtImport = new javax.swing.JButton();
        PnHeatMap = new com.imp.heatmapsurveyapp.HeatMapPanel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        BtNewRouter = new javax.swing.JButton();
        BtUndo = new javax.swing.JButton();
        LbText = new javax.swing.JLabel();
        BtHeatMap = new javax.swing.JButton();
        BtExport = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BtGetSignal = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1268, 677));

        BtImport.setText("Import");
        BtImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtImportActionPerformed(evt);
            }
        });

        label1.setText("-100 dBM");

        label2.setText("-50 dBM");

        label3.setText("-75 dBM");

        label4.setText("-87 dBM");

        label5.setText("-62 dBM");

        javax.swing.GroupLayout PnHeatMapLayout = new javax.swing.GroupLayout(PnHeatMap);
        PnHeatMap.setLayout(PnHeatMapLayout);
        PnHeatMapLayout.setHorizontalGroup(
            PnHeatMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnHeatMapLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PnHeatMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        PnHeatMapLayout.setVerticalGroup(
            PnHeatMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnHeatMapLayout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        BtNewRouter.setText("Router");
        BtNewRouter.setVisible(false);
        BtNewRouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtNewRouterActionPerformed(evt);
            }
        });

        BtUndo.setText("Undo");
        BtUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtUndoActionPerformed(evt);
            }
        });

        LbText.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        LbText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbText.setText("Announcement");

        BtHeatMap.setText("Heat Map");
        BtHeatMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtHeatMapActionPerformed(evt);
            }
        });

        BtExport.setText("Export");
        BtExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExportActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RSSI");

        BtGetSignal.setText("Get Signal");
        BtGetSignal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtGetSignalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtImport, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(BtHeatMap)
                .addGap(27, 27, 27)
                .addComponent(BtExport, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(464, 464, 464))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtGetSignal, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(PnHeatMap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtUndo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtNewRouter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(301, 301, 301)
                .addComponent(LbText, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addGap(355, 355, 355))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(LbText)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(PnHeatMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtGetSignal)
                .addGap(18, 18, 18)
                .addComponent(BtNewRouter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtUndo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtImport)
                    .addComponent(BtHeatMap)
                    .addComponent(BtExport))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtImportActionPerformed
        // TODO add your handling code here:
        
        selectImportFile();
    }//GEN-LAST:event_BtImportActionPerformed

    private void BtNewRouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtNewRouterActionPerformed
        mode = "router";
        setAnnouncement("Click on a router location...");
    }//GEN-LAST:event_BtNewRouterActionPerformed

    private void BtHeatMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtHeatMapActionPerformed
        mode = "";
        displayHeatMap = ! displayHeatMap;
        
        if (displayHeatMap) {
            setAnnouncement("Showing Heat Map");
        } else {
            setAnnouncement("Hiding Heat Map");
        }
        
        repaint();
    }//GEN-LAST:event_BtHeatMapActionPerformed

    private void BtUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtUndoActionPerformed
        undo();
    }//GEN-LAST:event_BtUndoActionPerformed

    private void BtExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExportActionPerformed
        selectExportFile();
    }//GEN-LAST:event_BtExportActionPerformed

    private void BtGetSignalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGetSignalActionPerformed
        try
        {
            WifiStats wifi = new WifiStats();
            HashMap<String, WifiStats.WifiNetwork> networks = wifi.GetNetworks();
            
            if (networks != null) {
                
                /*
                for (WifiStats.WifiNetwork network : networks.values()) {
                    for (HashMap.Entry<String, String> data : network.entrySet()) {
                        System.out.format("%s=%s\r\n", data.getKey(), data.getValue());                        
                    }                    
                    System.out.format("%s=%.1f %.1f\r\n", network.getSSID(), network.getSignal(), network.getRSSI());
                    System.out.println("-----------------------------");
                }
                */
                //selectWifiNetworks(networks.values().toArray());
                
                if (currentLayers  == null)
                    currentLayers = new HashMap<>();
                
                ArrayList<ListItem> items = new ArrayList<>();
                for (HashMap.Entry<String, WifiStats.WifiNetwork> network : networks.entrySet()) {
                
                    ListItem li = new ListItem(network.getKey(), network.getValue());
                    
                    String SSID = "";
                    String BSSID = "";
                    String signal = "";
                    for (HashMap.Entry<String, String> data : network.getValue().entrySet()) {
                        if ("SSID".equals(data.getKey())) {
                            SSID = data.getValue();
                        }
                        else if ("BSSID".equals(data.getKey())) {
                            BSSID = data.getValue();
                        }
                        else if ("SIGNAL".equals(data.getKey())) {
                            signal = data.getValue();
                        }
                        //System.out.format("%s=%s\r\n", data.getKey(), data.getValue());                        
                    } 
                    
                    li.text = SSID + " (" + signal + ") "  + BSSID;
                    
                    items.add(li);
                    
                    currentLayers.put(SSID, network.getValue().getRSSI());
                }                
                
                layersPanel.setItems(items);
                
                this.mode = "point";
                
            }
        }
        catch(Exception ex)
        {
            showMessageBox(ex.toString());
        }        
    }//GEN-LAST:event_BtGetSignalActionPerformed

    private Image imgPlan;
    private BufferedImage imgPlanOverlay;
    private Image imgRouter;
    private String mode;
    private ArrayList<DataPoint> points;    
    private boolean displayHeatMap;
    private LayersPanel layersPanel;
    
    private void initPanel() {        
        addMouseListener(this);
        mode = "";
        points = new ArrayList<>();          
        PnHeatMap.setEventListener(this);        
        imgRouter = loadImageFile(new File("assets/wifi-router.png"));
        displayHeatMap = false;
        
        setAnnouncement("Click on Level or Router to place...");        
        
        layersPanel = new LayersPanel();
        layersPanel.setLayerSelectedListener((LayersPanel.LayerListSelectionListener) this);
        JFrame frame = new JFrame();
        frame.setTitle("LayerPanel");
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(280, 480));
        frame.setLocation(this.getLocation());
        frame.add(layersPanel, BorderLayout.CENTER);
        frame.show();        
    }
    
    private JFrame getParentFrame()
    {
        return (JFrame) SwingUtilities.getWindowAncestor(this);
    }
    
    private Image loadImageFile(File file) {
        try {
            return ImageIO.read(file);                    
        } catch(Exception ex) {
            
        }
        return null;
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.        
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(new Color(255, 255, 255, 255));
        g.clearRect(0, 0, getWidth(), getHeight());
        render(g);
    }
    
    private String imgHeatMapLayerName;
    
    private int imgSx;
    private int imgSy;
    private int imgWidth;
    private int imgHeight;
    
    public void render(Graphics g) {
        
        System.out.println("render");
        
        int w = getWidth();
        int h = getHeight();
        
        if (imgPlan != null) {
            
            int iw = imgWidth;
            int ih = imgHeight;
            imgSx = (w / 2) - (iw / 2);
            imgSy = (h / 2) - (ih / 2);
            
            g.drawImage(imgPlan, imgSx, imgSy, this);

            if (displayHeatMap) {                
                renderHeatMap(imgPlanOverlay.createGraphics(), imgHeatMapLayerName);
            }
        
            g.drawImage(imgPlanOverlay, imgSx, imgSy, this);
        }
        

        g.setColor(Color.ORANGE);
        
        DataPoint pb = null;
        for(DataPoint pa : points) {
            
            if (DataPoint.POINT == pa.type ) {
                
                int px = pa.x - (POINT_SIZE/2);
                int py = pa.y - (POINT_SIZE/2);
                
                px += imgSx;
                py += imgSy;
                
                g.setColor(Color.BLACK);
                g.drawString("#" + pa.number + " " + HeatMapPanel.formatValue(pa.value), px, py);
                
                g.setColor(PnHeatMap.getHeatMapColor(pa.value));
                g.fillOval(px, py, POINT_SIZE, POINT_SIZE);                
                
                g.setColor(Color.BLACK);
                g.drawOval(px, py, POINT_SIZE, POINT_SIZE);
                if (pb != null) {
                    g.drawLine(pa.x + imgSx, pa.y + imgSy, pb.x + imgSx, pb.y + imgSy);
                }
                pb = pa;
                
                
            } else if (DataPoint.ROUTER == pa.type ) {
            
                int px = pa.x - (ICON_SIZE/2);
                int py = pa.y - (ICON_SIZE/2);
                
                px += imgSx;
                py += imgSy;

                g.drawImage(imgRouter, px, py, ICON_SIZE, ICON_SIZE, null);
            }
        }
        
        
    }
    
    private void renderHeatMap(Graphics g, String layer_name) {
        
        System.out.println("renderHeatMap");
        
        int iw = imgPlanOverlay.getWidth(null);
        int ih = imgPlanOverlay.getHeight(null);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(new Color(255, 255, 255, 0));
        g.clearRect(0, 0, iw, ih);
        
        Color color;
        int px;
        int py;
        int alpha = 72;
        
        for(DataPoint pa : points) {
            
            if (DataPoint.POINT == pa.type ) {
                
                int sz = 128;
                px = pa.x - (sz/2);
                py = pa.y - (sz/2);
                
                color = PnHeatMap.getHeatMapColor(pa.getValue(layer_name));
                
                color = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha); 
                g.setColor(color);
                g.fillOval(px, py, sz, sz);
            } 
            
            if (DataPoint.ROUTER == pa.type ) {
                
                int sz = 256;
                
                color = PnHeatMap.getHeatMapColor(PnHeatMap.minimumValue);
                color = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha / 3);                
                px = pa.x - (sz/2);
                py = pa.y - (sz/2);
                g.setColor(color);
                g.fillOval(px, py, sz, sz);
                
                color = PnHeatMap.getHeatMapColor(PnHeatMap.minimumValue + 32);
                color = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha / 2);                                                
                sz = 196;
                px = pa.x - (sz/2);
                py = pa.y - (sz/2);
                g.setColor(color);
                g.fillOval(px, py, sz, sz);

                color = PnHeatMap.getHeatMapColor(PnHeatMap.maximumValue - 32);
                color = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
                sz = 128;
                px = pa.x - (sz/2);
                py = pa.y - (sz/2);
                g.setColor(color);
                g.fillOval(px, py, sz, sz);
               

                color = PnHeatMap.getHeatMapColor(PnHeatMap.maximumValue);
                color = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);                                                
                sz = 72;
                px = pa.x - (sz/2);
                py = pa.y - (sz/2);
                g.setColor(color);
                g.fillOval(px, py, sz, sz);
                
            } 
            
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtExport;
    private javax.swing.JButton BtGetSignal;
    private javax.swing.JButton BtHeatMap;
    private javax.swing.JButton BtImport;
    private javax.swing.JButton BtNewRouter;
    private javax.swing.JButton BtUndo;
    private javax.swing.JLabel LbText;
    private com.imp.heatmapsurveyapp.HeatMapPanel PnHeatMap;
    private javax.swing.JLabel jLabel1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    // End of variables declaration//GEN-END:variables

    private void selectImportFile() {
        JFileChooser chooser = new JFileChooser();
        
        FileFilter imageFilter = new FileNameExtensionFilter(
            "Image files", ImageIO.getReaderFileSuffixes());        
        
        chooser.addChoosableFileFilter(imageFilter);
        chooser.setAcceptAllFileFilterUsed(false);

        String dir = System.getProperty("user.dir");        
        dir = Paths.get(dir, "images").toString();
        chooser.setCurrentDirectory(new File(dir));
        
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();            

            loadBaseImage(file);
            
        }
    }
    
    public void loadBaseImage(File file) {
        imgPlan = loadImageFile(file).getScaledInstance(700, 500, java.awt.Image.SCALE_SMOOTH);
        if (imgPlan != null) {
            imgWidth = imgPlan.getWidth(null);
            imgHeight = imgPlan.getHeight(null);
           
            imgPlanOverlay = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_4BYTE_ABGR);
            
        }
        repaint();
    }
    
    private void selectExportFile() {
        JFileChooser chooser = new JFileChooser();
        
        FileFilter imageFilter = new FileNameExtensionFilter("Image File (.png)", "png");                
        chooser.addChoosableFileFilter(imageFilter);

        String dir = System.getProperty("user.dir");
        dir = Paths.get(dir, "exports").toString();
        chooser.setCurrentDirectory(new File(dir));
        
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            saveExportImage(file);
        }
    }
    
    
    
    private void saveExportImage(File file) {
        try {
            // render sceen
            BufferedImage screen = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR);        

            Graphics g = screen.createGraphics();
            Graphics2D g2d = (Graphics2D) g;
            g2d.setBackground(new Color(0, 255, 0, 64));
            g.clearRect(0, 0, screen.getWidth(), screen.getHeight());

            render(g);

            // crop main image only        
            BufferedImage image = screen.getSubimage(imgSx, imgSy, imgWidth -1, imgHeight -1 );
        
            // add .png to filename
            String fullname = file.getAbsolutePath();
            if (!fullname.contains("."))
                file = new File(fullname  + ".png");
            
            // save image file
            ImageIO.write(image, "png", file);            
            showMessageBox("Saved");            
            
        } catch(Exception ex) {
            showMessageBox(ex.getMessage());
        }
                
    }
    
    
    public void mouseClickAction(int x, int y) {
        //return super.mouseUp(evt, x, y);        
        if (imgPlan == null) { // first click to import 
            mode = "";
            selectImportFile();
            return;
        }
        
        x -= imgSx;
        y -= imgSy;
        
        // add point mode
        if ("point".equals(mode)) {            
            DataPoint p = new DataPoint(x, y, currentValue);
            
            p.layers = new HashMap<>();
            p.layers.putAll(currentLayers);
            p.number = points.size();
            points.add(p);                
            
            repaint();            
            setAnnouncement("Added a point.");            
            
        } else if ("router".equals(mode)) {
            
            DataPoint p = null;
            
            for(DataPoint ps : points) {
                if (ps.type == DataPoint.ROUTER) {
                    p = ps;
                    break;
                }
            }
            if (p == null) {
                p = new DataPoint(DataPoint.ROUTER, x, y, currentValue);
                p.number = points.size();            
                points.add(p);                
            } else {
                p.x = x;
                p.y = y;
            }
            
            
            repaint();
            setAnnouncement("Added a router.");
            
        }        
    }
    
    @Override
    public void OnLevelSelected(Object sender, float value) {        
        mode = "point";
        currentValue = value;
        
        String text = HeatMapPanel.formatValue(currentValue);        
        setAnnouncement("Click to set a " + text + " point ...");
    }   
    
    private void showMessageBox(String text) {
        JOptionPane.showMessageDialog(this, text);
    }

    private void setAnnouncement(String text) {
        LbText.setVisible(true);
        LbText.setText(text);
                
        // announceement timeout
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LbText.setVisible(false);
            }            
        });        
        timer.setRepeats(false);
        timer.start();        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseClickAction(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    private void undo() {
        if (points.isEmpty()) return;
        
        points.remove(points.size()-1);
        
        setAnnouncement("Undo step.");
        repaint();
    }

    private void selectWifiNetworks(Object[] values) {
        
        Object result = JOptionPane.showInputDialog(null, 
                "Select wifi network", "Select Wifi Network", 
                JOptionPane.QUESTION_MESSAGE,
                null,
                values,
                null);
        
        if (result != null) {
            
            WifiStats.WifiNetwork network = (WifiStats.WifiNetwork) result;
            //JOptionPane.showMessageDialog(null, result.toString());            
            OnLevelSelected(this, network.getRSSI());
        }
    }
    

    @Override
    public void OnLayerListItemSelected(ListItem item) {
        
        WifiStats.WifiNetwork network = (WifiStats.WifiNetwork) item.data;
        
        imgHeatMapLayerName = network.getSSID();
        currentValue = network.getRSSI();
        System.out.println("Layer: " + imgHeatMapLayerName);
        
        setAnnouncement("Showing " + imgHeatMapLayerName);    
        
        repaint();
    }

   
    
    
}
