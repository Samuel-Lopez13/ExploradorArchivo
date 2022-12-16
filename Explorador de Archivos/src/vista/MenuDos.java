/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author lopez
 */
public class MenuDos extends javax.swing.JFrame {

    /**
     * Creates new form MenuDos
     */
    public MenuDos() {
        setUndecorated(true);
        initComponents();
        setSize(120, 150);
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        disenos();
    }
    
    public Color color1 = new Color(0,81,200);
    public Color color2 = new Color(0,81,100);
    public Color color3 = new Color(0,81,135);
    
    public void disenos(){
        crearArchivo.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                crearArchivo.setBackground(color1);
            }
            
            @Override
            public void mouseEntered(MouseEvent e){
                crearArchivo.setBackground(color2);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                crearArchivo.setBackground(color3);
            }
        });
        
        crearCarpeta.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                crearCarpeta.setBackground(color1);
            }
            
            @Override
            public void mouseEntered(MouseEvent e){
                crearCarpeta.setBackground(color2);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                crearCarpeta.setBackground(color3);
            }
        });
        
        pegar.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                pegar.setBackground(color1);
            }
            
            @Override
            public void mouseEntered(MouseEvent e){
                pegar.setBackground(color2);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                pegar.setBackground(color3);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelito = new javax.swing.JPanel();
        crearCarpeta = new javax.swing.JLabel();
        pegar = new javax.swing.JLabel();
        crearArchivo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelito.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        crearCarpeta.setBackground(new java.awt.Color(0, 81, 135));
        crearCarpeta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        crearCarpeta.setForeground(new java.awt.Color(255, 255, 255));
        crearCarpeta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        crearCarpeta.setText("Crear Carpeta");
        crearCarpeta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        crearCarpeta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearCarpeta.setOpaque(true);
        panelito.add(crearCarpeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        pegar.setBackground(new java.awt.Color(0, 81, 135));
        pegar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pegar.setForeground(new java.awt.Color(255, 255, 255));
        pegar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pegar.setText("Pegar");
        pegar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pegar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pegar.setOpaque(true);
        panelito.add(pegar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 120, 50));

        crearArchivo.setBackground(new java.awt.Color(0, 81, 135));
        crearArchivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        crearArchivo.setForeground(new java.awt.Color(255, 255, 255));
        crearArchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        crearArchivo.setText("Crear Archivo");
        crearArchivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        crearArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearArchivo.setOpaque(true);
        panelito.add(crearArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 120, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel crearArchivo;
    public javax.swing.JLabel crearCarpeta;
    public javax.swing.JPanel panelito;
    public javax.swing.JLabel pegar;
    // End of variables declaration//GEN-END:variables
}
