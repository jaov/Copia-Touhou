/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import Objetos.*;
import Resources.Datos;
import java.awt.Rectangle;
/**
 *
 * @author jesus.ochoa
 */
public class MiFrame extends JFrame{
    public static final int HEIGHT=600, WIDTH=800;
    Avion personaje;
    JLabel labelTexto;
    JPanel mipanel;
    CargaImagen cargaImagen, cargaMisil,cargaEnemigo;
    int indiceC, indiceF, indiceM;
   
    Timer animaciones;
    Misil[] misil;
    JLabel mp,nme;


    public MiFrame() {
        
        super("River Raid");
        
        
        indiceC=0;
        indiceF=0;
        indiceM=0;
        
        //random = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Random_picture_of_shark.png")));
        cargaImagen = new CargaImagen(18,17,30,47,8,3,2,0,"src/Imagenes/Touhou.png");
        cargaMisil = new CargaImagen(271,137,28,28,8,4,4,3,"src/Imagenes/Enemigos.png");
        cargaEnemigo = new CargaImagen(15,9,26,26,8,4,6,6,"src/Imagenes/Enemigos.png");
        
        mp = new JLabel(cargaMisil.getImagen(0, 0));
        add(mp);
        mp.setBounds(200, 200, mp.getIcon().getIconWidth(), mp.getIcon().getIconHeight());
        mp.setVisible(true);
        
        nme = new JLabel(cargaEnemigo.getImagen(0, 0));
        nme.setBounds(400, 200, nme.getIcon().getIconWidth(), nme.getIcon().getIconHeight());
        nme.setVisible(true);
        add(nme);
        
        misil = new Misil[Datos.MAX_MISILES];
        for (int i = 0; i < Datos.MAX_MISILES; i++) {
            misil[i] = new Misil(
                    cargaMisil.getImagen(0, 0).getIconWidth()*i,
                    Datos.HEIGHT-cargaMisil.getImagen(0, 0).getIconHeight()*2,
                    cargaMisil.getImagen(0, 0),3,true
            );
            //misil[i].setBounds(misil[i].getX(), misil[i].getY(), misil[i].getWidth(), misil[i].getHeight());
            
            MiFrame.this.add(misil[i]);
            misil[i].setVisible(true);
        }
        
        
        personaje = new Avion(0,0,cargaImagen.getImagen(0, 0),0);
        
        mipanel = new JPanel(null);
        mipanel.setLocation(0,0);
        
        
        
        personaje.setBounds(
                (WIDTH-personaje.getIcon().getIconWidth())/2,
                HEIGHT-personaje.getIcon().getIconHeight()*2,
                personaje.getIcon().getIconWidth(),
                personaje.getIcon().getIconHeight());
        System.out.println("pos xy personaje: "+personaje.getX()+","+personaje.getY());
        System.out.println("personaje ancho: "+personaje.getWidth()+", alto: "+personaje.getHeight());
        labelTexto = new JLabel("Magia:");
        labelTexto.setBounds(0,400, 100,40);
        //mipanel.setSize(800, 600);
        
        add(mipanel);
        add(labelTexto);
        labelTexto.setLocation(0, 0);
        labelTexto.setVisible(true);
        getContentPane().add(mipanel);
        //this.getContentPane().setSize(800, 600);
        setSize(800,600);

        add(personaje);
        personaje.setVisible(true);
        
        
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
         addKeyListener(new teclas());
        personaje.setFocusable(true);
        
        animaciones = new Timer(1000/10, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                indiceC++;
                if(indiceC>=cargaImagen.getC() && indiceF==0){
                    indiceC=0;
                };
                if (indiceC>=cargaImagen.getC() && indiceF!=0) {
                    indiceC=cargaImagen.getC()-3;
                }
                
                personaje.setIcon(cargaImagen.getImagen(indiceF, indiceC));
                mp.setIcon(cargaMisil.getImagen(0, indiceC));
                nme.setIcon(cargaEnemigo.getImagen(0, indiceC));
               // mp.setLocation(mp.getX(),mp.getY()+10);
                
            }//actionperformed
        });//timer
        animaciones.start();
        
        
    }//constructor
        
        public class teclas extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                

                case KeyEvent.VK_RIGHT:
                    if (personaje.getX() + 10 < (WIDTH - personaje.getWidth())) {
                        
                        personaje.setLocation(personaje.getX()+10, personaje.getY());
                        //personaje.setIcon(cargaImagen.getImagen(2, 2));
                        indiceF=2;
                        personaje.repaint();
                        repaint();
                    }//if   
                    break;

                case KeyEvent.VK_LEFT:
                    if (personaje.getX() - 5 > 0) {
                        
                        personaje.setLocation(personaje.getX()-10, personaje.getY());
                        //personaje.setIcon(cargaImagen.getImagen(1, 2));
                        indiceF=1;
                        personaje.repaint();
                        repaint();
                    }//if
                    break;
                case KeyEvent.VK_SPACE:
                    System.out.println("disparo!");
                    /*for (Misil misil1 : misil) {
                    misil1 = new Misil(
                    personaje.getX(),
                    personaje.getY()-cargaMisil.getImagen(0, 0).getIconHeight(),
                    cargaMisil.getImagen(0, 0),3,true);
                    misil1.setVisible(true);
                    //add(misil1);
                    MiFrame.this.add(misil1);
                    MiFrame.this.repaint();
                    
                    }*/
                    
                    
                    break;
            }//switch
            System.out.println("ubicacion x,y: ("+personaje.getX()+","+personaje.getY()+")");
        }//keyPressed
        @Override
        public void keyReleased(KeyEvent e){
                        switch (e.getKeyCode()) {

                case KeyEvent.VK_RIGHT:
                    //personaje.setIcon(cargaImagen.getImagen(0, 0));
                    indiceF=0;
                    break;

                case KeyEvent.VK_LEFT:
                    //personaje.setIcon(cargaImagen.getImagen(0, 0));
                    indiceF=0;
                    break;
            }//switch
        }
    }//classTeclas
    
    
}
