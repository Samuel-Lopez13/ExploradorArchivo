/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author lopez
 */
public class PantallaCarga extends JFrame {

    Diseno d = new Diseno();

    JProgressBar progreso;
    JLabel isc;
    JLabel uacam;
    JLabel fi;
    JLabel uac;
    JLabel fondoB;
    JLabel fondoA;
    
    JLabel gif;

    int contadorSprit = 2;
    int contadordeContador = 1;
    
    public PantallaCarga() {
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(d);
        cargar();
    }
    
    int x = 0;
    
    public void cargar() {
        Thread hilo = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    try {
                        sleep(60);
                        gif.setLocation(x, gif.getLocation().y);
                        if(contadorSprit == 2){
                            gif.setIcon(new ImageIcon("src/img/sprit2.png"));
                            if(contadordeContador == 3){
                                contadorSprit = 3;
                                contadordeContador = 1;
                            }
                            contadordeContador++;
                        } else if(contadorSprit == 3){
                            gif.setIcon(new ImageIcon("src/img/sprit3.png"));
                            if(contadordeContador == 3){
                                contadorSprit = 4;
                                contadordeContador = 1;
                            }
                            contadordeContador++;
                        } else if(contadorSprit == 4){
                            gif.setIcon(new ImageIcon("src/img/sprit3.png"));
                            if(contadordeContador == 3){
                                contadorSprit = 1;
                                contadordeContador = 1;
                            }
                            contadordeContador++;
                        } else if(contadorSprit == 1){
                            gif.setIcon(new ImageIcon("src/img/sprit1.png"));
                            if(contadordeContador == 3){
                                contadorSprit = 2;
                                contadordeContador = 1;
                            }
                            contadordeContador++;
                        }
                        x += 14;
                        progreso.setValue(i);
                    } catch (InterruptedException ex) {

                    }
                    if(i == 100){
                        Explorador principal = new Explorador();
                        principal.setVisible(true);
                        dispose();
                        break;
                    }
                }
            }
        };
        hilo.start();
    }

    private class Diseno extends JPanel {

        public Diseno() {
            setLayout(null);

            JPanel panelArriba = new JPanel();
            panelArriba.setLayout(null);
            panelArriba.setBounds(0, 0, 1366, 313);
            panelArriba.setBackground(Color.WHITE);
            add(panelArriba);

            JPanel panelAbajo = new JPanel();
            panelAbajo.setLayout(null);
            panelAbajo.setBounds(0, 313, 1366, 398);
            panelAbajo.setBackground(new Color(30, 41, 67));
            add(panelAbajo);

            fi = new JLabel();
            fi.setOpaque(true);
            fi.setBounds(28, 28, 214, 228);
            fi.setIcon(new ImageIcon("src/img/fi.png"));
            panelArriba.add(fi);

            uac = new JLabel();
            uac.setOpaque(true);
            uac.setBounds(1138, 28, 200, 244);
            uac.setBackground(Color.WHITE);
            uac.setIcon(new ImageIcon("src/img/uac.png"));
            panelArriba.add(uac);

            uacam = new JLabel();
            uacam.setOpaque(true);
            uacam.setBounds(277, 59, 840, 195);
            uacam.setBackground(Color.WHITE);
            uacam.setIcon(new ImageIcon("src/img/uacam.png"));
            panelArriba.add(uacam);

            isc = new JLabel();
            isc.setOpaque(true);
            isc.setBounds(321, 90, 752, 196);
            isc.setBackground(new Color(30, 41, 67));
            isc.setIcon(new ImageIcon("src/img/isc.png"));
            panelAbajo.add(isc);

            progreso = new JProgressBar();
            progreso.setBounds(0, 711, 1366, 57);
            progreso.setBackground(new Color(253, 229, 12));
            progreso.setBorder(null);
            progreso.setStringPainted(true);
            add(progreso);
            
            gif = new JLabel();
            gif.setBounds(0, 290, 80, 110);
            gif.setBackground(new Color(30, 41, 67));
//            gif.setBackground(Color.red);
            gif.setIcon(new ImageIcon("src/img/sprit1.png"));
            gif.setOpaque(true);
            panelAbajo.add(gif);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }

    }
}
