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
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        setUndecorated(true);
        initComponents();
        setSize(120, 200);
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        disenos();
    }
    
    public Color color1 = new Color(0,81,200);
    public Color color2 = new Color(0,81,100);
    public Color color3 = new Color(0,81,135);
    
    public void disenos(){
        abrir.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                abrir.setBackground(color1);
            }
            
            @Override
            public void mouseEntered(MouseEvent e){
                abrir.setBackground(color2);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                abrir.setBackground(color3);
            }
        });
        
        copiar.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                copiar.setBackground(color1);
            }
            
            @Override
            public void mouseEntered(MouseEvent e){
                copiar.setBackground(color2);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                copiar.setBackground(color3);
            }
        });
        
        eliminar.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                eliminar.setBackground(color1);
            }
            
            @Override
            public void mouseEntered(MouseEvent e){
                eliminar.setBackground(color2);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                eliminar.setBackground(color3);
            }
        });
        
        cambiarNombre.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                cambiarNombre.setBackground(color1);
            }
            
            @Override
            public void mouseEntered(MouseEvent e){
                cambiarNombre.setBackground(color2);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                cambiarNombre.setBackground(color3);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cambiarNombre = new javax.swing.JLabel();
        abrir = new javax.swing.JLabel();
        copiar = new javax.swing.JLabel();
        eliminar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 81, 135));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cambiarNombre.setBackground(new java.awt.Color(0, 81, 135));
        cambiarNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cambiarNombre.setForeground(new java.awt.Color(255, 255, 255));
        cambiarNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cambiarNombre.setText("Cambiar Nombre");
        cambiarNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cambiarNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cambiarNombre.setOpaque(true);
        jPanel1.add(cambiarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 120, 50));

        abrir.setBackground(new java.awt.Color(0, 81, 135));
        abrir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        abrir.setForeground(new java.awt.Color(255, 255, 255));
        abrir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        abrir.setText("Abrir");
        abrir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        abrir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        abrir.setOpaque(true);
        jPanel1.add(abrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        copiar.setBackground(new java.awt.Color(0, 81, 135));
        copiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        copiar.setForeground(new java.awt.Color(255, 255, 255));
        copiar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copiar.setText("Copiar");
        copiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        copiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        copiar.setOpaque(true);
        jPanel1.add(copiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 120, 50));

        eliminar.setBackground(new java.awt.Color(0, 81, 135));
        eliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        eliminar.setForeground(new java.awt.Color(255, 255, 255));
        eliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eliminar.setText("Eliminar");
        eliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminar.setOpaque(true);
        jPanel1.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 120, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel abrir;
    public javax.swing.JLabel cambiarNombre;
    public javax.swing.JLabel copiar;
    public javax.swing.JLabel eliminar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
