/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author jesus.ochoa
 */
public class MiFrame extends JFrame{
    public static final int HEIGHT=600, WIDTH=800;
    JLabel personaje, random;
    JLabel labelTexto;
    JPanel mipanel;
    CargaImagen cargaImagen;
    int indice;


    public MiFrame() {
        
        super("River Raid");
        indice=0;
        
        random = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Random_picture_of_shark.png")));
        cargaImagen = new CargaImagen(18,17,30,46,8,3,3,0,"src/Imagenes/Touhou.png");
        personaje = new JLabel(new ImageIcon(cargaImagen.getImagen(0, 0)));
        
        mipanel = new JPanel(null);
        mipanel.setLocation(0,0);
        
        random.setBounds(0,0,random.getIcon().getIconWidth(),random.getIcon().getIconHeight());
        
        random.setVisible(true);
        
        personaje.setBounds(
                (WIDTH-personaje.getIcon().getIconWidth())/2,
                HEIGHT-personaje.getIcon().getIconHeight()*2,
                personaje.getIcon().getIconWidth(),
                personaje.getIcon().getIconHeight());
        System.out.println("pos xy personaje: "+personaje.getX()+","+personaje.getY());
        System.out.println("personaje ancho: "+personaje.getWidth()+", alto: "+personaje.getHeight());
        labelTexto = new JLabel("Por Favor");
        labelTexto.setBounds(0,400, 100,40);
        //mipanel.setSize(800, 600);
        add(random);
        add(mipanel);
        add(labelTexto);
        labelTexto.setLocation(0, 0);
        labelTexto.setVisible(true);
        getContentPane().add(mipanel);
        //this.getContentPane().setSize(800, 600);
        setSize(800,600);

        add(personaje);
        personaje.setVisible(true);
        ;
        
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
         addKeyListener(new teclas());
        personaje.setFocusable(true);
        
        
        
    }
        public class teclas extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {

                case KeyEvent.VK_RIGHT:
                    if (personaje.getX() + 10 < (WIDTH - personaje.getWidth())) {
                        personaje.setLocation(personaje.getX()+10, personaje.getY());
                        if (indice<cargaImagen.getC()) {
                            personaje.setIcon(new ImageIcon(cargaImagen.getImagen(1, indice++)));
                        }
                        if (indice==cargaImagen.getC()-1) {
                            personaje.setIcon(new ImageIcon(cargaImagen.getImagen(1, indice)));
                        }
                        
                        personaje.repaint();
                        repaint();
                    }//if   
                    break;

                case KeyEvent.VK_LEFT:
                    if (personaje.getX() - 5 > 0) {
                        personaje.setLocation(personaje.getX()-10, personaje.getY());
                        if (indice<cargaImagen.getC()) {
                            personaje.setIcon(new ImageIcon(cargaImagen.getImagen(2, indice++)));
                        }
                        if (indice==cargaImagen.getC()-1) {
                            personaje.setIcon(new ImageIcon(cargaImagen.getImagen(2, indice)));
                        }
                        personaje.repaint();
                        repaint();
                    }//if
                    break;
            }//switch
            System.out.println("ubicacion x,y: ("+personaje.getX()+","+personaje.getY()+")");
        }//keyPressed
    }//classTeclas
    
    
}
