/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package explorador.de.archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import vista.CrearArchivo;
import vista.CrearCarpeta;
import vista.Explorador;
import vista.Menu;
import vista.MenuDos;
import vista.PantallaCarga;

public class ExploradorDeArchivos {

    public static void main(String[] args) throws IOException {
//        File archivo = new File("C:\\Users\\lopez\\OneDrive\\Documentos\\Tarea\\5 SEMESTRE\\Administracion de Archivos\\C\\Pedro");
//        File listados[];
//        
//        if(archivo.exists()){
//            if(archivo.isDirectory()){
//                listados = archivo.listFiles();
//                for (File listado : listados) {
//                  System.out.println(listado);
//                }
//            }
//        }

//        if(archivo.mkdir()){
//            System.out.println("creado");
//        } else{
//            System.out.println("no creado");
//        }
//        File arch = new File("C:\\Users\\lopez\\OneDrive\\Documentos\\Tarea\\nuevo.docx");
//        try {
//            PrintWriter salida = new PrintWriter(new FileWriter(arch));
//            salida.close();
//            System.out.println("Se ha creado el archivo");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        String archivo1 = "C:\\Users\\lopez\\OneDrive\\Documentos\\Tarea\\5 SEMESTRE";
//        String archivo2 = "C:\\Users\\lopez\\OneDrive\\Documentos\\Tarea\\Nuevo\\5 SEMESTRE";
//
//        Path temp = Files.move(Paths.get(archivo1),
//                Paths.get(archivo2));
//
//        if (temp != null) {
//            System.out.println("File renamed and moved successfully");
//        } else {
//            System.out.println("Failed to move the file");
//        }
//        
//        ExploradorArchivos p = new ExploradorArchivos();
//        p.setVisible(true);

//        Explorador p = new Explorador();
//        p.setVisible(true);

//        MenuDos m = new MenuDos();
//        m.setVisible(true);
        
        //abrir
        //corta
        //copiar
        //eliminar
        //cambiar nombre
        
//        CrearArchivo ca = new CrearArchivo();
        
//        ca.setVisible(true);

        PantallaCarga p = new PantallaCarga();
        p.setVisible(true);
    }

}
