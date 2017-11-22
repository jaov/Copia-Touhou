/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author ochoa
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejaArchivos {

    private BufferedWriter bw;
    private String nombre;
    private int puntuacion;

    private static final String FILENAME = "Resources/leaderboard.txt";

    public void ManejaArchivos() {

        try {
            bw = new BufferedWriter(new FileWriter(FILENAME));
            //bw.write("Puntuacion\tTiempo\n");

            // como es un try with resources no hay que cerrar
            

        } catch (IOException e) {

            e.printStackTrace();

        }
        finally{
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(ManejaArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
           System.out.println("Done"); 
        }

    }//constructor
    public void agregarLinea(String arg){
        PrintWriter pw = new PrintWriter(bw);
        pw.println(arg);
        pw.close();
    }
    public void topTen(int puntuacion){
        String[] aux;
        Scanner scan = new Scanner(FILENAME);
        String linea = scan.nextLine();
        while (linea!=null){
            aux = linea.split(" ");
            this.nombre = aux[0];
            this.puntuacion = Integer.valueOf(aux[1]);
            
        }
        
        
    }
}//class
