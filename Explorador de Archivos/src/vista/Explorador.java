/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Explorador extends javax.swing.JFrame {

    //Boton Izquierdo
    //(e.getModifiers() & 16) !=0
    //Boton Derecho
    //(e.getModifiers() & 4) !=0
    //Boton Central
    //(e.getModifiers() & 8) !=0
    private File archivo;
    private File listFile[];
    private String pathR;
    String reference = "";
    private int size = 1;
    
    String carDescargas = "C:\\Users\\lopez\\Downloads";
    String carDocumentos = "C:\\Users\\lopez\\OneDrive\\Documentos";
    String carImagenes = "C:\\Users\\lopez\\OneDrive\\Imágenes";
    String carVideos = "C:\\Users\\lopez\\Videos";
    String carMusica = "C:\\Users\\lopez\\Music";

    public Explorador() {
        setUndecorated(true);
        initComponents();
//        setSize(1316, 639);
        setSize(1300, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Explorador de Archivos");
        panelSuperior.setName(carDocumentos);
        panelCentral.setLayout(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom c = new ScrollBarCustom();
        c.setOrientation(JScrollBar.HORIZONTAL);
        scroll.setHorizontalScrollBar(c);
        crearBotones();
        iniciarMenu();
    }

    //guarda los archivos de un path
    public void datos() {
        //le pasa por parametro una carpeta ya existente
        archivo = new File(panelSuperior.getName());
        //se preguta si existe y si es un directorio
        if (archivo.exists()) {
            if (archivo.isDirectory()) {
                //si esto se cumple crea un arreglo con todas los archivos
                //que hay en el directorio
                listFile = archivo.listFiles();
            }
        }
    }

    //este metodo resetea la pantalla para que se muestren los datos
    //el programa al repintar no se ve nada y hay que modificar las dimensiones
    public void nuevo() {
        if (size == 1) {
            setSize(1315, 639);
            size = 0;
        } else if (size == 0) {
            setSize(1316, 639);
            size = 1;
        }
    }

    int x = 13;
    int y = 13;
    int bandera = 1;

    boolean directorioo = false;

    public void crearBotones() {
        //le paso los datos del arreglo
        datos();

        //recorro el arreglo de archivos
        int i = 0;
        for (i = 0; i < listFile.length; i++) {

            //creo un boton
            MyButton btn;
            //le paso la lista de nombres de archivos que tengo guardado
            btn = new MyButton(listFile[i].getName());
            //Se agrega el diseño del boton
            btn.setHorizontalAlignment((int) CENTER_ALIGNMENT);
            btn.setBackground(new Color(217, 217, 217));
            btn.setFocusable(false);
            btn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
            btn.setForeground(Color.BLACK);
            btn.setBorderPainted(false);
            btn.setRadius(30);

            char tamano[] = listFile[i].getName().toCharArray();
            int contadorPunto = 0;

            String extencion = "";

            for (int j = tamano.length; j > 0; j--) {
                if (String.valueOf(tamano[j - 1]).equals(".")) {
                    contadorPunto++;
                    break;
                } else {
                    extencion += tamano[j - 1];
                }
            }

            char[] extencionM = extencion.toCharArray();
            String extencionV = "";

            for (int j = extencionM.length; j > 0; j--) {
                extencionV += String.valueOf(extencionM[j - 1]);
            }

            if (contadorPunto == 0) {
                btn.setIcon(new ImageIcon("src/img/carpeta1.png"));
            } else {
                btn.setIcon(new ImageIcon("src/img/documentos1.png"));
            }

            if (extencionV.equals("pdf")) {
                btn.setIcon(new ImageIcon("src/img/pdf1.png"));
            } else if (extencionV.equals("docx")) {
                btn.setIcon(new ImageIcon("src/img/word1.png"));
            } else if (extencionV.equals("mp4")) {
                btn.setIcon(new ImageIcon("src/img/mp41.png"));
            } else if (extencionV.equals("mp3")) {
                btn.setIcon(new ImageIcon("src/img/mp31.png"));
            } else if (extencionV.equals("pptx")) {
                btn.setIcon(new ImageIcon("src/img/powerPoint1.png"));
            } else if (extencionV.equals("xlsx")) {
                btn.setIcon(new ImageIcon("src/img/excel1.png"));
            } else if (extencionV.equals("txt")) {
                btn.setIcon(new ImageIcon("src/img/txt1.png"));
            } else if (extencionV.equals("jpg")) {
                btn.setIcon(new ImageIcon("src/img/jpg1.png"));
            } else if (extencionV.equals("png")) {
                btn.setIcon(new ImageIcon("src/img/png1.png"));
            }

            btn.setHorizontalTextPosition(SwingConstants.CENTER);
            btn.setVerticalTextPosition(SwingConstants.BOTTOM);
            //guardo el path para usarlo despues
            String path = listFile[i].getPath();
            cortarUltimo(path);

            //esto es para guardar el ultimo path para utilizarlo
            //en regresar
            pathR = path;
            //es para las posiciones de los archivos
            btn.setBounds(x, y, 120, 170);
            x += 133;

            if (x == 1077) {
                x = 13;
                y += 183;
            }

            int modulos = 0;

            if (listFile.length % 8 == 0) {
                modulos = 0;
            } else {
                modulos += 183;
            }

            btn.setName(path);
            if (btn.getName().equals(reference)) {
                btn.setBackground(new Color(47, 50, 108));
            }

            //dependiendo cambiara el tamaño del panel para poder mostrar el scroll
            panelCentral.setPreferredSize(new Dimension(1060, y + modulos));

            //se agrega el boton en el panel
            panelCentral.add(btn);

            boolean directorio = listFile[i].isDirectory();
            String nombre = listFile[i].getName();

            btn.addMouseListener(new ClickListener() {

                @Override
                public void singleClick(MouseEvent e) {
                    if ((e.getModifiers() & 16) != 0) {
                        if (directorio) {
                            directorioo = true;
                        } else {
                            directorioo = false;
                        }

                        reference = btn.getName();
                        mover = path;
                        nombreC = "\\" + nombre;

                        panelCentral.removeAll();
                        x = 13;
                        y = 13;
                        crearBotones();
                        nuevo();
                        repaint();
                    }
                }

                @Override
                public void doubleClick(MouseEvent e) {
                    if ((e.getModifiers() & 16) != 0) {
                        if (directorio) {
                            //primero remuevo todo lo que hay en el panel
                            panelCentral.removeAll();
                            //le cambio el path a la carpeta siguiente
                            panelSuperior.setName(path);
                            //ejecuto los siguientes metodos
                            //se resetea las posiciones de las carpetas
                            x = 13;
                            y = 13;
                            crearBotones();
                            nuevo();
                            repaint();
                        } else {
                            //me devulve mi desktop
                            Desktop dt = Desktop.getDesktop();
                            try {
                                //y le pasa como parametro el path del archivo para
                                //abrirlo
                                dt.open(new File(path));
                            } catch (IOException ex) {
                            }
                        }
                    }
                }
            });

            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if ((e.getModifiers() & 4) != 0) {
                        Point punto = MouseInfo.getPointerInfo().getLocation();
                        int xx = punto.x - 60;
                        int yy = punto.y - 100;
                        Menu m = new Menu();
                        m.setVisible(true);
                        m.setLocation(xx, yy);

                        m.abrir.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mousePressed(MouseEvent e) {
                                if (directorio) {
                                    //primero remuevo todo lo que hay en el panel
                                    panelCentral.removeAll();
                                    //le cambio el path a la carpeta siguiente
                                    panelSuperior.setName(path);
                                    //ejecuto los siguientes metodos
                                    //se resetea las posiciones de las carpetas
                                    x = 13;
                                    y = 13;
                                    crearBotones();
                                    nuevo();
                                    repaint();
                                } else {
                                    //me devulve mi desktop
                                    Desktop dt = Desktop.getDesktop();
                                    try {
                                        //y le pasa como parametro el path del archivo para
                                        //abrirlo
                                        dt.open(new File(path));
                                    } catch (IOException ex) {
                                    }
                                }
                                m.dispose();
                            }
                        });

                        m.copiar.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mousePressed(MouseEvent e) {
                                mover = path;
                                nombreC = "\\" + nombre;
                                m.dispose();
                            }
                        });

                        m.eliminar.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mousePressed(MouseEvent e) {
                                mover = path;
                                nombreC = "\\" + nombre;
                                File f = new File(mover);
                                if (f.delete()) {
                                    x = 13;
                                    y = 13;
                                    panelCentral.removeAll();
                                    crearBotones();
                                    nuevo();
                                    repaint();
                                } else {
                                    System.out.println("no se elimino");
                                }
                                m.dispose();
                            }
                        });

                        m.cambiarNombre.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mousePressed(MouseEvent e) {
                                mover = path;
                                nombreC = "\\" + nombre;
                                if (directorio) {
                                    directorioo = true;
                                } else {
                                    directorioo = false;
                                }
                                metodoRenombrar();
                                m.dispose();
                            }
                        });
                    }
                }
            });

            if (!btn.getName().equals(reference)) {
                btn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btn.setBackground(new Color(150, 150, 150));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btn.setBackground(new Color(217, 217, 217));
                    }
                });
            }
        }

        if (listFile.length == 0) {
            String valor = panelSuperior.getName();
            url.setText(valor);
        }
    }

    boolean one = true;
    boolean two = true;
    boolean tree = true;

    public void iniciarMenu() {
        panelCentral.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if ((e.getModifiers() & 4) != 0) {
                    Point punto = MouseInfo.getPointerInfo().getLocation();
                    int x = punto.x - 60;
                    int y = punto.y - 75;
                    MenuDos md = new MenuDos();
                    md.setVisible(true);
                    md.setLocation(x, y);

//                    md.crearArchivo.addMouseListener(new MouseAdapter(){
//                        @Override
//                        public void mouseExited(MouseEvent e) {
//                            one = true;
//                        }
//                        
//                        @Override
//                        public void mouseEntered(MouseEvent e) {
//                            one = false;
//                            System.out.println(one + " " + two + " " + tree);
//                        }
//                    });
//                    
//                    md.crearCarpeta.addMouseListener(new MouseAdapter(){
//                        @Override
//                        public void mouseExited(MouseEvent e) {
//                            two = true;
//                        }
//                        
//                        @Override
//                        public void mouseEntered(MouseEvent e) {
//                            two = false;
//                            System.out.println(one + " " + two + " " + tree);
//                        }
//                    });
//                    
//                    md.pegar.addMouseListener(new MouseAdapter(){
//                        @Override
//                        public void mouseExited(MouseEvent e) {
//                            tree = true;
//                        }
//                        
//                        @Override
//                        public void mouseEntered(MouseEvent e) {
//                            tree = false;
//                            System.out.println(one + " " + two + " " + tree);
//                        }
//                    });
                    md.crearArchivo.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            metodoCrearArchivos();
                            md.dispose();
                        }
                    });

                    md.crearCarpeta.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            metodoCrearCarpeta();
                            md.dispose();
                        }
                    });

                    md.pegar.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            metodoPegar();
                            md.dispose();
                        }
                    });
                }
            }
        });
    }

    String mover;
    String nombreC;
    String to;
    String anterior;

    public void btnRegresar() {
        reference = "";
        //tomo el path ultimo path Guardado y lo pongo en un arreglo
        char caracterInvertido[];
        String pathFinal = "";
        if (listFile.length == 0) {
            caracterInvertido = new char[panelSuperior.getName().length()];
            String nuevoValor = "";
            pathFinal = "";
            int contador = 0;

            //toma los caracteres y lo invierte
            for (int i = panelSuperior.getName().length(); i > 0; i--) {
                caracterInvertido[contador] = panelSuperior.getName().charAt(i - 1);
                contador++;
            }

            boolean bandera = true;
            int c = 0;

            for (int i = 0; i < panelSuperior.getName().length(); i++) {
                //la bandera es para que ya no vuelva a entrar estando en negativo
                if (bandera) {
                    //como ya esta invertido va a buscar una coincidencia de \
                    //que indica que alli acaba una carpeta
                    if (String.valueOf(caracterInvertido[i]).equals("\\")) {
                        //este contador es porque si hay una carpeta vacia pues la 
                        //bandera solo recorrera una vez pero si no esta vacia la
                        //ara dos veces.
                        //ya que son dos carpetas que tiene que retroceder para
                        //salir uno porque te devuelve el path de uno en el que estas
                        //y aparte en el que quieres regresar
                        c++;
                        if (listFile.length == 0) {
                            bandera = false;
                        }
                        if (c == 2) {
                            bandera = false;
                        }
                    }
                } else {
                    //una vez encuentra eso pues nuevoValor = a los caracteres despues
                    //De los que no tomo
                    nuevoValor += String.valueOf(caracterInvertido[i]);
                }
            }

            //vuelve a invertir la cadena y la deja como deberia estar
            for (int i = nuevoValor.length(); i > 0; i--) {
                pathFinal += nuevoValor.charAt(i - 1);
            }
        } else {
            caracterInvertido = new char[pathR.length()];
            String nuevoValor = "";
            pathFinal = "";
            int contador = 0;

            //toma los caracteres y lo invierte
            for (int i = pathR.length(); i > 0; i--) {
                caracterInvertido[contador] = pathR.charAt(i - 1);
                contador++;
            }

            boolean bandera = true;
            int c = 0;

            for (int i = 0; i < pathR.length(); i++) {
                //la bandera es para que ya no vuelva a entrar estando en negativo
                if (bandera) {
                    //como ya esta invertido va a buscar una coincidencia de \
                    //que indica que alli acaba una carpeta
                    if (String.valueOf(caracterInvertido[i]).equals("\\")) {
                        //este contador es porque si hay una carpeta vacia pues la 
                        //bandera solo recorrera una vez pero si no esta vacia la
                        //ara dos veces.
                        //ya que son dos carpetas que tiene que retroceder para
                        //salir uno porque te devuelve el path de uno en el que estas
                        //y aparte en el que quieres regresar
                        c++;
                        if (listFile.length == 0) {
                            bandera = false;
                        }
                        if (c == 2) {
                            bandera = false;
                        }
                    }
                } else {
                    //una vez encuentra eso pues nuevoValor = a los caracteres despues
                    //De los que no tomo
                    nuevoValor += String.valueOf(caracterInvertido[i]);
                }
            }

            //vuelve a invertir la cadena y la deja como deberia estar
            for (int i = nuevoValor.length(); i > 0; i--) {
                pathFinal += nuevoValor.charAt(i - 1);
            }
        }

        //se remueve todo
        panelCentral.removeAll();
        //le paso el path al panel donde guardo
        //este solo es una ayuda pudo ser a cualquier componente estaico
        panelSuperior.setName(pathFinal);
        //se resetea las posiciones de las carpetas
        x = 13;
        y = 13;
        //y ejecuto los siguientes metodos
        crearBotones();
        nuevo();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        regresar = new javax.swing.JLabel();
        crearArchivo = new javax.swing.JButton();
        crearCarpeta = new javax.swing.JButton();
        pegar = new javax.swing.JButton();
        renombrar = new javax.swing.JButton();
        url = new javax.swing.JLabel();
        eliminar = new javax.swing.JButton();
        panelLateral = new javax.swing.JPanel();
        musica = new javax.swing.JLabel();
        descargar = new javax.swing.JLabel();
        documentos = new javax.swing.JLabel();
        imagenes = new javax.swing.JLabel();
        videos = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        panelCentral = new panelNuevo();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSuperior.setBackground(new java.awt.Color(47, 52, 63));

        regresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Flecha.png"))); // NOI18N
        regresar.setVerifyInputWhenFocusTarget(false);
        regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regresarMouseClicked(evt);
            }
        });

        crearArchivo.setBackground(new java.awt.Color(255, 255, 0));
        crearArchivo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        crearArchivo.setText("Crear Archivo");
        crearArchivo.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 102, 0), new java.awt.Color(102, 102, 0)));
        crearArchivo.setFocusable(false);
        crearArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearArchivoActionPerformed(evt);
            }
        });

        crearCarpeta.setBackground(new java.awt.Color(255, 255, 0));
        crearCarpeta.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        crearCarpeta.setText("Crear Carpeta");
        crearCarpeta.setToolTipText("");
        crearCarpeta.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 102, 0), new java.awt.Color(102, 102, 0)));
        crearCarpeta.setDoubleBuffered(true);
        crearCarpeta.setFocusable(false);
        crearCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearCarpetaActionPerformed(evt);
            }
        });

        pegar.setBackground(new java.awt.Color(255, 255, 0));
        pegar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        pegar.setText("Pegar");
        pegar.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 102, 0), new java.awt.Color(102, 102, 0)));
        pegar.setFocusable(false);
        pegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegarActionPerformed(evt);
            }
        });

        renombrar.setBackground(new java.awt.Color(255, 255, 0));
        renombrar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        renombrar.setText("Renombrar");
        renombrar.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 102, 0), new java.awt.Color(102, 102, 0)));
        renombrar.setFocusable(false);
        renombrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renombrarActionPerformed(evt);
            }
        });

        url.setOpaque(true);

        eliminar.setBackground(new java.awt.Color(255, 255, 0));
        eliminar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 102, 0), new java.awt.Color(102, 102, 0)));
        eliminar.setFocusable(false);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(regresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(crearCarpeta, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(crearArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(url, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addGap(103, 716, Short.MAX_VALUE)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(renombrar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pegar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pegar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(renombrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crearCarpeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crearArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(panelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 100));

        panelLateral.setBackground(new java.awt.Color(47, 52, 63));
        panelLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        musica.setBackground(new java.awt.Color(47, 52, 63));
        musica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        musica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Musica.png"))); // NOI18N
        musica.setOpaque(true);
        musica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                musicaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                musicaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                musicaMouseExited(evt);
            }
        });
        panelLateral.add(musica, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 220, 80));

        descargar.setBackground(new java.awt.Color(47, 52, 63));
        descargar.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        descargar.setForeground(new java.awt.Color(255, 255, 255));
        descargar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Descargas.png"))); // NOI18N
        descargar.setOpaque(true);
        descargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descargarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                descargarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                descargarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                descargarMousePressed(evt);
            }
        });
        panelLateral.add(descargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 80));

        documentos.setBackground(new java.awt.Color(47, 52, 63));
        documentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        documentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Documentos.png"))); // NOI18N
        documentos.setOpaque(true);
        documentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                documentosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                documentosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                documentosMouseExited(evt);
            }
        });
        panelLateral.add(documentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 220, 80));

        imagenes.setBackground(new java.awt.Color(47, 52, 63));
        imagenes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Imagenes.png"))); // NOI18N
        imagenes.setOpaque(true);
        imagenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagenesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                imagenesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                imagenesMouseExited(evt);
            }
        });
        panelLateral.add(imagenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 220, 80));

        videos.setBackground(new java.awt.Color(47, 52, 63));
        videos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        videos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Videos.png"))); // NOI18N
        videos.setOpaque(true);
        videos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                videosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                videosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                videosMouseExited(evt);
            }
        });
        panelLateral.add(videos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 220, 80));

        getContentPane().add(panelLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 220, 500));

        panelCentral.setPreferredSize(new java.awt.Dimension(1080, 498));

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        scroll.setViewportView(panelCentral);

        getContentPane().add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 1080, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cortarUltimo(String pathR) {
        char caracterInvertido[] = new char[pathR.length()];
        String nuevoValor = "";
        String pathFinal = "";
        int contador = 0;

        //toma los caracteres y lo invierte
        for (int i = pathR.length(); i > 0; i--) {
            caracterInvertido[contador] = pathR.charAt(i - 1);
            contador++;
        }

        boolean bandera = true;
        int c = 0;

        for (int i = 0; i < pathR.length(); i++) {
            //la bandera es para que ya no vuelva a entrar estando en negativo
            if (bandera) {
                //como ya esta invertido va a buscar una coincidencia de \
                //que indica que alli acaba una carpeta
                if (String.valueOf(caracterInvertido[i]).equals("\\")) {
                    //este contador es porque si hay una carpeta vacia pues la 
                    //bandera solo recorrera una vez pero si no esta vacia la
                    //ara dos veces.
                    //ya que son dos carpetas que tiene que retroceder para
                    //salir uno porque te devuelve el path de uno en el que estas
                    //y aparte en el que quieres regresar
//                    c++;
//                    if (listFile.length == 0) {
                    bandera = false;
//                    }
//                    if (c == 1) {
                    bandera = false;
//                    }
                }
            } else {
                //una vez encuentra eso pues nuevoValor = a los caracteres despues
                //De los que no tomo
                nuevoValor += String.valueOf(caracterInvertido[i]);
            }
        }

        //vuelve a invertir la cadena y la deja como deberia estar
        for (int i = nuevoValor.length(); i > 0; i--) {
            pathFinal += nuevoValor.charAt(i - 1);
        }

        url.setText(pathFinal);
    }

    private void regresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarMouseClicked
        btnRegresar();
    }//GEN-LAST:event_regresarMouseClicked

    public void metodoCrearCarpeta() {
        CrearCarpeta ca = new CrearCarpeta();
        ca.setVisible(true);

        ca.Aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = ca.carpeta.getText();
                ca.dispose();

                char caracterInvertido[];
                String pathFinal = "";

                if (listFile.length == 0) {
                    //tomo el path ultimo path Guardado y lo pongo en un arreglo
                    caracterInvertido = new char[panelSuperior.getName().length()];
                    String nuevoValor = "";
                    pathFinal = "";
                    int contador = 0;

                    //toma los caracteres y lo invierte
                    for (int i = panelSuperior.getName().length(); i > 0; i--) {
                        caracterInvertido[contador] = panelSuperior.getName().charAt(i - 1);
                        contador++;
                    }

                    boolean bandera = true;
                    int c = 0;

                    for (int i = 0; i < panelSuperior.getName().length(); i++) {
                        //la bandera es para que ya no vuelva a entrar estando en negativo
                        if (bandera && listFile.length != 0) {
                            //como ya esta invertido va a buscar una coincidencia de \
                            //que indica que alli acaba una carpeta
                            if (String.valueOf(caracterInvertido[i]).equals("\\")) {
                                //bandera solo recorrera una vez
                                bandera = false;
                            }
                        } else {
                            //una vez encuentra eso pues nuevoValor = a los caracteres despues
                            //De los que no tomo
                            nuevoValor += String.valueOf(caracterInvertido[i]);
                        }
                    }

                    //vuelve a invertir la cadena y la deja como deberia estar
                    for (int i = nuevoValor.length(); i > 0; i--) {
                        pathFinal += nuevoValor.charAt(i - 1);
                    }

                    String nuevaCarpeta = pathFinal + "\\" + nombre;

                    File archivo = new File(nuevaCarpeta);
                    if (archivo.mkdir()) {
                        System.out.println("creado");
                    } else {
                        System.out.println("no creado");
                    }
                } else {
                    //tomo el path ultimo path Guardado y lo pongo en un arreglo
                    caracterInvertido = new char[pathR.length()];
                    String nuevoValor = "";
                    pathFinal = "";
                    int contador = 0;

                    //toma los caracteres y lo invierte
                    for (int i = pathR.length(); i > 0; i--) {
                        caracterInvertido[contador] = pathR.charAt(i - 1);
                        contador++;
                    }

                    boolean bandera = true;
                    int c = 0;

                    for (int i = 0; i < pathR.length(); i++) {
                        //la bandera es para que ya no vuelva a entrar estando en negativo
                        if (bandera && listFile.length != 0) {
                            //como ya esta invertido va a buscar una coincidencia de \
                            //que indica que alli acaba una carpeta
                            if (String.valueOf(caracterInvertido[i]).equals("\\")) {
                                //bandera solo recorrera una vez
                                bandera = false;
                            }
                        } else {
                            //una vez encuentra eso pues nuevoValor = a los caracteres despues
                            //De los que no tomo
                            nuevoValor += String.valueOf(caracterInvertido[i]);
                        }
                    }

                    //vuelve a invertir la cadena y la deja como deberia estar
                    for (int i = nuevoValor.length(); i > 0; i--) {
                        pathFinal += nuevoValor.charAt(i - 1);
                    }

                    String nuevaCarpeta = pathFinal + "\\" + nombre;

                    File archivo = new File(nuevaCarpeta);
                    if (archivo.mkdir()) {
                        System.out.println("creado");
                    } else {
                        System.out.println("no creado");
                    }
                }

                //se remueve todo
                panelCentral.removeAll();
                //le paso el path al panel donde guardo
                //este solo es una ayuda pudo ser a cualquier componente estaico
                panelSuperior.setName(pathFinal);
                //se resetea las posiciones de las carpetas
                x = 13;
                y = 13;
                //y ejecuto los siguientes metodos
                crearBotones();
                nuevo();
                repaint();
            }
        });

        ca.cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ca.dispose();
            }
        });
    }

    private void crearCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearCarpetaActionPerformed
        metodoCrearCarpeta();
    }//GEN-LAST:event_crearCarpetaActionPerformed

    public void metodoCrearArchivos() {
        CrearArchivo ca = new CrearArchivo();
        ca.setVisible(true);

        ca.Aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = ca.carpeta.getText() + ca.combo.getSelectedItem().toString();
                ca.dispose();
                char caracterInvertido[];
                String pathFinal = "";

                if (listFile.length == 0) {
                    //tomo el path ultimo path Guardado y lo pongo en un arreglo
                    caracterInvertido = new char[panelSuperior.getName().length()];
                    String nuevoValor = "";
                    pathFinal = "";
                    int contador = 0;

                    //toma los caracteres y lo invierte
                    for (int i = panelSuperior.getName().length(); i > 0; i--) {
                        caracterInvertido[contador] = panelSuperior.getName().charAt(i - 1);
                        contador++;
                    }

                    boolean bandera = true;
                    int c = 0;

                    for (int i = 0; i < panelSuperior.getName().length(); i++) {
                        //la bandera es para que ya no vuelva a entrar estando en negativo
                        if (bandera && listFile.length != 0) {
                            //como ya esta invertido va a buscar una coincidencia de \
                            //que indica que alli acaba una carpeta
                            if (String.valueOf(caracterInvertido[i]).equals("\\")) {
                                //bandera solo recorrera una vez
                                bandera = false;
                            }
                        } else {
                            //una vez encuentra eso pues nuevoValor = a los caracteres despues
                            //De los que no tomo
                            nuevoValor += String.valueOf(caracterInvertido[i]);
                        }
                    }

                    //vuelve a invertir la cadena y la deja como deberia estar
                    for (int i = nuevoValor.length(); i > 0; i--) {
                        pathFinal += nuevoValor.charAt(i - 1);
                    }

                    String nuevaCarpeta = pathFinal + "\\" + nombre;

                    File archivo = new File(nuevaCarpeta);
                    try {
                        PrintWriter salida = new PrintWriter(new FileWriter(archivo));
                        salida.close();
                        System.out.println("Se ha creado el archivo");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    //tomo el path ultimo path Guardado y lo pongo en un arreglo
                    caracterInvertido = new char[pathR.length()];
                    String nuevoValor = "";
                    pathFinal = "";
                    int contador = 0;

                    //toma los caracteres y lo invierte
                    for (int i = pathR.length(); i > 0; i--) {
                        caracterInvertido[contador] = pathR.charAt(i - 1);
                        contador++;
                    }

                    boolean bandera = true;
                    int c = 0;

                    for (int i = 0; i < pathR.length(); i++) {
                        //la bandera es para que ya no vuelva a entrar estando en negativo
                        if (bandera && listFile.length != 0) {
                            //como ya esta invertido va a buscar una coincidencia de \
                            //que indica que alli acaba una carpeta
                            if (String.valueOf(caracterInvertido[i]).equals("\\")) {
                                //bandera solo recorrera una vez
                                bandera = false;
                            }
                        } else {
                            //una vez encuentra eso pues nuevoValor = a los caracteres despues
                            //De los que no tomo
                            nuevoValor += String.valueOf(caracterInvertido[i]);
                        }
                    }

                    //vuelve a invertir la cadena y la deja como deberia estar
                    for (int i = nuevoValor.length(); i > 0; i--) {
                        pathFinal += nuevoValor.charAt(i - 1);
                    }

                    String nuevaCarpeta = pathFinal + "\\" + nombre;

                    File archivo = new File(nuevaCarpeta);
                    try {
                        PrintWriter salida = new PrintWriter(new FileWriter(archivo));
                        salida.close();
                        System.out.println("Se ha creado el archivo");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

                //se remueve todo
                panelCentral.removeAll();
                //le paso el path al panel donde guardo
                //este solo es una ayuda pudo ser a cualquier componente estaico
                panelSuperior.setName(pathFinal);
                //se resetea las posiciones de las carpetas
                x = 13;
                y = 13;
                //y ejecuto los siguientes metodos
                crearBotones();
                nuevo();
                repaint();
            }
        });

        ca.cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ca.dispose();
            }
        });
    }

    private void crearArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearArchivoActionPerformed
        metodoCrearArchivos();
    }//GEN-LAST:event_crearArchivoActionPerformed

    public void metodoPegar() {
        to = panelSuperior.getName();

        String archivo1 = mover;
        String archivo2 = to + nombreC;

        try {
            Path temp = Files.move(Paths.get(archivo1), Paths.get(archivo2));
            if (temp != null) {
                panelCentral.removeAll();
                //ejecuto los siguientes metodos
                //se resetea las posiciones de las carpetas
                x = 13;
                y = 13;
                crearBotones();
                nuevo();
                repaint();
            } else {
                System.out.println("Failed to move the file");
            }
        } catch (IOException ex) {
            Logger.getLogger(Explorador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pegarActionPerformed
        metodoPegar();
    }//GEN-LAST:event_pegarActionPerformed

    public void metodoRenombrar() {
        if (directorioo) {
            CrearCarpeta ca = new CrearCarpeta();
            ca.setVisible(true);

            ca.Aceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //tomo el path ultimo path Guardado y lo pongo en un arreglo
                    char caracterInvertido[] = new char[pathR.length()];
                    String nuevoValor = "";
                    String pathFinal = "";
                    int contador = 0;

                    //toma los caracteres y lo invierte
                    for (int i = pathR.length(); i > 0; i--) {
                        caracterInvertido[contador] = pathR.charAt(i - 1);
                        contador++;
                    }

                    boolean bandera = true;
                    int c = 0;

                    for (int i = 0; i < pathR.length(); i++) {
                        //la bandera es para que ya no vuelva a entrar estando en negativo
                        if (bandera) {
                            //como ya esta invertido va a buscar una coincidencia de \
                            //que indica que alli acaba una carpeta
                            if (String.valueOf(caracterInvertido[i]).equals("\\")) {
                                //este contador es porque si hay una carpeta vacia pues la 
                                //bandera solo recorrera una vez pero si no esta vacia la
                                //ara dos veces.
                                //ya que son dos carpetas que tiene que retroceder para
                                //salir uno porque te devuelve el path de uno en el que estas
                                //y aparte en el que quieres regresar
//                    c++;
//                    if (listFile.length == 0) {
                                bandera = false;
//                    }
//                    if (c == 2) {
//                        bandera = false;
//                    }
                            }
                        } else {
                            //una vez encuentra eso pues nuevoValor = a los caracteres despues
                            //De los que no tomo
                            nuevoValor += String.valueOf(caracterInvertido[i]);
                        }
                    }

                    //vuelve a invertir la cadena y la deja como deberia estar
                    for (int i = nuevoValor.length(); i > 0; i--) {
                        pathFinal += nuevoValor.charAt(i - 1);
                    }

                    anterior = ca.carpeta.getText();
                    ca.dispose();
//                anterior = JOptionPane.showInputDialog("Renombrar");

                    String archivo1 = mover;
                    String archivo2 = pathFinal + "\\" + anterior;

                    try {
                        Path temp = Files.move(Paths.get(archivo1), Paths.get(archivo2));
                        if (temp != null) {
                            panelCentral.removeAll();
                            //ejecuto los siguientes metodos
                            //se resetea las posiciones de las carpetas
                            x = 13;
                            y = 13;
                            crearBotones();
                            nuevo();
                            repaint();
                        } else {
                            System.out.println("Failed to move the file");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Explorador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            ca.cancelar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ca.dispose();
                }
            });
        } else {
            CrearArchivo ca = new CrearArchivo();
            ca.setVisible(true);

            ca.Aceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //tomo el path ultimo path Guardado y lo pongo en un arreglo
                    char caracterInvertido[] = new char[pathR.length()];
                    String nuevoValor = "";
                    String pathFinal = "";
                    int contador = 0;

                    //toma los caracteres y lo invierte
                    for (int i = pathR.length(); i > 0; i--) {
                        caracterInvertido[contador] = pathR.charAt(i - 1);
                        contador++;
                    }

                    boolean bandera = true;
                    int c = 0;

                    for (int i = 0; i < pathR.length(); i++) {
                        //la bandera es para que ya no vuelva a entrar estando en negativo
                        if (bandera) {
                            //como ya esta invertido va a buscar una coincidencia de \
                            //que indica que alli acaba una carpeta
                            if (String.valueOf(caracterInvertido[i]).equals("\\")) {
                                //este contador es porque si hay una carpeta vacia pues la 
                                //bandera solo recorrera una vez pero si no esta vacia la
                                //ara dos veces.
                                //ya que son dos carpetas que tiene que retroceder para
                                //salir uno porque te devuelve el path de uno en el que estas
                                //y aparte en el que quieres regresar
//                    c++;
//                    if (listFile.length == 0) {
                                bandera = false;
//                    }
//                    if (c == 2) {
//                        bandera = false;
//                    }
                            }
                        } else {
                            //una vez encuentra eso pues nuevoValor = a los caracteres despues
                            //De los que no tomo
                            nuevoValor += String.valueOf(caracterInvertido[i]);
                        }
                    }

                    //vuelve a invertir la cadena y la deja como deberia estar
                    for (int i = nuevoValor.length(); i > 0; i--) {
                        pathFinal += nuevoValor.charAt(i - 1);
                    }

                    anterior = ca.carpeta.getText() + ca.combo.getSelectedItem().toString();
                    ca.dispose();
//                anterior = JOptionPane.showInputDialog("Renombrar");

                    String archivo1 = mover;
                    String archivo2 = pathFinal + "\\" + anterior;

                    try {
                        Path temp = Files.move(Paths.get(archivo1), Paths.get(archivo2));
                        if (temp != null) {
                            panelCentral.removeAll();
                            //ejecuto los siguientes metodos
                            //se resetea las posiciones de las carpetas
                            x = 13;
                            y = 13;
                            crearBotones();
                            nuevo();
                            repaint();
                        } else {
                            System.out.println("Failed to move the file");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Explorador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            ca.cancelar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ca.dispose();
                }
            });
        }
    }

    private void renombrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renombrarActionPerformed
        metodoRenombrar();
    }//GEN-LAST:event_renombrarActionPerformed

    private void descargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descargarMouseClicked
        //se remueve todo
        panelCentral.removeAll();
        //le paso el path al panel donde guardo
        //este solo es una ayuda pudo ser a cualquier componente estaico
        panelSuperior.setName(carDescargas);
        //se resetea las posiciones de las carpetas
        x = 13;
        y = 13;
        //y ejecuto los siguientes metodos
        crearBotones();
        nuevo();
        repaint();
    }//GEN-LAST:event_descargarMouseClicked

    private void documentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_documentosMouseClicked
        //se remueve todo
        panelCentral.removeAll();
        //le paso el path al panel donde guardo
        //este solo es una ayuda pudo ser a cualquier componente estaico
        panelSuperior.setName(carDocumentos);
        //se resetea las posiciones de las carpetas
        x = 13;
        y = 13;
        //y ejecuto los siguientes metodos
        crearBotones();
        nuevo();
        repaint();
    }//GEN-LAST:event_documentosMouseClicked

    private void imagenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenesMouseClicked
        //se remueve todo
        panelCentral.removeAll();
        //le paso el path al panel donde guardo
        //este solo es una ayuda pudo ser a cualquier componente estaico
        panelSuperior.setName(carImagenes);
        //se resetea las posiciones de las carpetas
        x = 13;
        y = 13;
        //y ejecuto los siguientes metodos
        crearBotones();
        nuevo();
        repaint();
    }//GEN-LAST:event_imagenesMouseClicked

    private void videosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_videosMouseClicked
        //se remueve todo
        panelCentral.removeAll();
        //le paso el path al panel donde guardo
        //este solo es una ayuda pudo ser a cualquier componente estaico
        panelSuperior.setName(carVideos);
        //se resetea las posiciones de las carpetas
        x = 13;
        y = 13;
        //y ejecuto los siguientes metodos
        crearBotones();
        nuevo();
        repaint();
    }//GEN-LAST:event_videosMouseClicked

    private void musicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musicaMouseClicked
        //se remueve todo
        panelCentral.removeAll();
        //le paso el path al panel donde guardo
        //este solo es una ayuda pudo ser a cualquier componente estaico
        panelSuperior.setName(carMusica);
        //se resetea las posiciones de las carpetas
        x = 13;
        y = 13;
        //y ejecuto los siguientes metodos
        crearBotones();
        nuevo();
        repaint();
    }//GEN-LAST:event_musicaMouseClicked

    private void descargarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descargarMousePressed
    }//GEN-LAST:event_descargarMousePressed

    private void descargarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descargarMouseEntered
        descargar.setBackground(new Color(47, 50, 108));
    }//GEN-LAST:event_descargarMouseEntered

    private void descargarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descargarMouseExited
        descargar.setBackground(new Color(47, 52, 63));
    }//GEN-LAST:event_descargarMouseExited

    private void documentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_documentosMouseEntered
        documentos.setBackground(new Color(47, 50, 108));
    }//GEN-LAST:event_documentosMouseEntered

    private void documentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_documentosMouseExited
        documentos.setBackground(new Color(47, 52, 63));
    }//GEN-LAST:event_documentosMouseExited

    private void imagenesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenesMouseEntered
        imagenes.setBackground(new Color(47, 50, 108));
    }//GEN-LAST:event_imagenesMouseEntered

    private void imagenesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenesMouseExited
        imagenes.setBackground(new Color(47, 52, 63));
    }//GEN-LAST:event_imagenesMouseExited

    private void videosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_videosMouseEntered
        videos.setBackground(new Color(47, 50, 108));
    }//GEN-LAST:event_videosMouseEntered

    private void videosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_videosMouseExited
        videos.setBackground(new Color(47, 52, 63));
    }//GEN-LAST:event_videosMouseExited

    private void musicaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musicaMouseEntered
        musica.setBackground(new Color(47, 50, 108));
    }//GEN-LAST:event_musicaMouseEntered

    private void musicaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musicaMouseExited
        musica.setBackground(new Color(47, 52, 63));
    }//GEN-LAST:event_musicaMouseExited

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        File f = new File(mover);

        eliminar(f);
        x = 13;
        y = 13;
        panelCentral.removeAll();
        crearBotones();
        nuevo();
        repaint();
    }//GEN-LAST:event_eliminarActionPerformed

    public void eliminar(File f) {
        if (f.isDirectory()) {
            for (File f1 : f.listFiles()) {
                eliminar(f1);
            }
        }
        f.delete();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crearArchivo;
    private javax.swing.JButton crearCarpeta;
    private javax.swing.JLabel descargar;
    private javax.swing.JLabel documentos;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel imagenes;
    private javax.swing.JLabel musica;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelLateral;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JButton pegar;
    private javax.swing.JLabel regresar;
    private javax.swing.JButton renombrar;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JLabel url;
    private javax.swing.JLabel videos;
    // End of variables declaration//GEN-END:variables
}
