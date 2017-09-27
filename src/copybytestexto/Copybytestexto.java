/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copybytestexto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otorradomiguez
 */
public class Copybytestexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creamos dos variables File con la ruta de los ficheros texto1 y texto2
        File archivo1 = new File("/home/local/DANIELCASTELAO/otorradomiguez/NetBeansProjects/copybytestexto/texto1.txt");
        File archivoNuevo = new File("/home/local/DANIELCASTELAO/otorradomiguez/NetBeansProjects/copybytestexto/texto2.txt");
        //añadimos byte a byte el contenido de texto1 al final de texto2
        copiarArchivo(archivo1, archivoNuevo, true);
    }

    //Añade el contenido de archivo a archivoNuevo si añadir es true, si es false sobrescribe
    //el contenido de archivo Nuevo
    public static void copiarArchivo(File archivo, File archivoNuevo, boolean añadir) {
        //Aqui guardamos el byte actual
        int byteActual = 0;
        try {
            //Creamos el input y el output streams
            FileInputStream fInput = new FileInputStream(archivo);
            //El true indica que se añaden al final del archivo los bytes que le pasemos con write()
            FileOutputStream fOutput = new FileOutputStream(archivoNuevo, añadir);
            //mientras el read() no devuelva -1 indicando que llego al final va leyendo byte a byte
            while (byteActual != -1) {
                byteActual = fInput.read();
                System.out.println("Byte actual: " + byteActual + " Letra: " + (char) byteActual);
                if (byteActual != -1) {
                    //escribe el byte en el OutputStream de archivoNuevo
                    fOutput.write(byteActual);
                } //cerramos los streams al acabar, es decir cuando byteActual sea -1
                else {
                    fOutput.close();
                    fInput.close();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Copybytestexto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Copybytestexto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
