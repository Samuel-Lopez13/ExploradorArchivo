/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;

/**
 *
 * @author lopez
 */
public class CrearArchivo extends javax.swing.JFrame {

    /**
     * Creates new form CrearArchivo
     */
    public CrearArchivo() {
        setUndecorated(true);
        initComponents();
        setSize(400, 200);
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        datosComboBox();
        colocarImagenes();
    }

    public void datosComboBox() {
        combo.addItem("");
        combo.addItem(".txt");
        combo.addItem(".docx");
        combo.addItem(".pptx");
        combo.addItem(".xlsx");
    }

    String extension;

//    String nameFile = "";
//
//    public String creacion() {
//        Aceptar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                nameFile = carpeta.getText();
//            }
//        });
//        return nameFile + extension;
//    }

    public void colocarImagenes() {
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                extension = combo.getSelectedItem().toString();
                if (extension.equals(".txt")) {
                    iconos.setIcon(new ImageIcon("src/img/txt1.png"));
                } else if (extension.equals(".docx")) {
                    iconos.setIcon(new ImageIcon("src/img/word1.png"));
                } else if (extension.equals(".pptx")) {
                    iconos.setIcon(new ImageIcon("src/img/powerPoint1.png"));
                } else if (extension.equals(".xlsx")) {
                    iconos.setIcon(new ImageIcon("src/img/excel1.png"));
                } else if (extension.equals("")) {
                    iconos.setIcon(new ImageIcon("src/img/documentos1.png"));
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        carpeta = new javax.swing.JTextField();
        iconos = new javax.swing.JLabel();
        cancelar = new vista.MyButton();
        Aceptar = new vista.MyButton();
        combo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 81, 135));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        carpeta.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        carpeta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(carpeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 160, 38));

        iconos.setBackground(new java.awt.Color(0, 81, 135));
        iconos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/documentos1.png"))); // NOI18N
        iconos.setText("jLabel1");
        iconos.setOpaque(true);
        jPanel1.add(iconos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 80, -1));

        cancelar.setBackground(new java.awt.Color(255, 255, 52));
        cancelar.setText("Cancelar");
        cancelar.setBorderPainted(false);
        cancelar.setFocusPainted(false);
        cancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelar.setRadius(30);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 100, 35));

        Aceptar.setBackground(new java.awt.Color(255, 255, 52));
        Aceptar.setText("Aceptar");
        Aceptar.setBorderPainted(false);
        Aceptar.setFocusPainted(false);
        Aceptar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Aceptar.setRadius(30);
        jPanel1.add(Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 100, 35));

        combo.setBackground(new java.awt.Color(255, 255, 102));
        combo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        combo.setOpaque(true);
        jPanel1.add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 70, 38));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed

    }//GEN-LAST:event_cancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public vista.MyButton Aceptar;
    public vista.MyButton cancelar;
    public javax.swing.JTextField carpeta;
    public javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel iconos;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
