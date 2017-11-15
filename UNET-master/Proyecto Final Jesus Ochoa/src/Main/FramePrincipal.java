/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Objetos.*;
import Resources.Datos;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author jesus.ochoa
 */
public class FramePrincipal extends JFrame{
    Avion avion;
    ArrayList <Objeto>objetos;

    public FramePrincipal() {
        super("River Raid");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        
    }
    
}
