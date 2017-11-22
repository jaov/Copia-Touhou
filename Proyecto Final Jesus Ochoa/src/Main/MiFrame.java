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
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Objetos.*;
import Resources.Datos;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.sound.sampled.*;

/**
 *
 * @author jesus.ochoa
 */
public class MiFrame extends JFrame {
    public static final int HEIGHT = 600, WIDTH = 800;
    Avion personaje;
    Gasolina gas;
    JLabel labelTexto, bg;
    JPanel mipanel;
    CargaImagen cargaImagen, cargaMisil, cargaEnemigo, cargaGasolina, cargaBG;
    int indiceC, indiceF, indiceM, indiceD;
    Enemigo e1,e2;
    int paso, puntuacion;
    int indicePaso;
    Timer animaciones;
    Misil[] misil;
    Misil m1;
    Clip musicaFondo;
    Random pos;

    public MiFrame() {

        super("River Raid");
        this.puntuacion = 0;
        this.indiceD = 0;
        this.paso = 1;
        this.indicePaso = 1;
        cargaImagen = new CargaImagen(18, 17, 30, 47, 8, 3, 2, 0, "src/Imagenes/Touhou.png");
        cargaMisil = new CargaImagen(271, 137, 28, 28, 8, 4, 4, 3, "src/Imagenes/Enemigos.png");
        cargaEnemigo = new CargaImagen(15, 9, 26, 26, 8, 4, 6, 6, "src/Imagenes/Enemigos.png");
        cargaGasolina = new CargaImagen(13, 199, 30, 30, 1, 1, 0, 0, "src/Imagenes/Enemigos.png");
        cargaBG = new CargaImagen(0,0,570,350,1,1,0,0,"src/Imagenes/bg1.jpg");
        pos = new Random();
        
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(this.getClass().getResource("./src/Resources/musica.mp3"));
            //AudioInputStream ais = AudioSystem.getAudioInputStream(new FileInputStream(new File("/Resources/musica.mp3"))); 
            AudioFormat format = ais.getFormat();
	    DataLine.Info info = new DataLine.Info(Clip.class, format);
	    //musicaFondo = AudioSystem.getClip();
            musicaFondo = (Clip)AudioSystem.getLine(info);
	    musicaFondo.open(ais);
            musicaFondo.start();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        indiceC = 0;
        indiceF = 0;
        indiceM = 0;

        int asdf = pos.nextInt(9);
        System.out.println("random: " + asdf);
        e1 = new Enemigo(pos.nextInt(9) * cargaEnemigo.getImagen(0, 0).getIconWidth(),
                pos.nextInt(5) * cargaEnemigo.getImagen(0, 0).getIconHeight(), cargaEnemigo.getImagen(0, 0), 1);
        this.add(e1);
        System.out.println(e1.getRectangulo().toString());
        
        e2 = new Enemigo(0,100,cargaEnemigo.getImagen(3, 0),1);
        this.add(e2);
        

        gas = new Gasolina(pos.nextInt(20) * cargaGasolina.getImagen(0, 0).getIconWidth(),
                pos.nextInt(14) * cargaGasolina.getImagen(0, 0).getIconHeight(), cargaGasolina.getImagen(0, 0), 2);
        MiFrame.this.add(gas);

        misil = new Misil[Datos.MAX_MISILES];
        for (int i = 0; i < Datos.MAX_MISILES; i++) {
            misil[i] = new Misil(cargaMisil.getImagen(0, 0).getIconWidth() * i,
                    Datos.HEIGHT - cargaMisil.getImagen(0, 0).getIconHeight() * 2, cargaMisil.getImagen(0, 0), 3, true

            );
            System.out.println(misil[i].getRectangulo().toString());

            //misil[i].setBounds(misil[i].getX(), misil[i].getY(), misil[i].getWidth(), misil[i].getHeight());

            MiFrame.this.add(misil[i]);
            misil[i].setVisible(true);
        }

        personaje = new Avion(0, 0, cargaImagen.getImagen(0, 0), 0);

        mipanel = new JPanel(null);
        mipanel.setLocation(0, 0);

        personaje.setBounds((WIDTH - personaje.getIcon().getIconWidth()) / 2,
                HEIGHT - personaje.getIcon().getIconHeight() * 2, personaje.getIcon().getIconWidth(),
                personaje.getIcon().getIconHeight());
        System.out.println(personaje.getRectangulo().toString());
        /*System.out.println("pos xy personaje: "+personaje.getX()+","+personaje.getY());
        System.out.println("personaje ancho: "+personaje.getWidth()+", alto: "+personaje.getHeight());*/
        labelTexto = new JLabel("Magia: " + personaje.getGasolina());
        labelTexto.setBounds(0, 0, 500, 60);
        //mipanel.setSize(800, 600);
        
        
        add(mipanel);
        add(labelTexto);
        
        bg = new JLabel(cargaBG.getImagen(0, 0));
        bg.setBounds(0, 0, 800, 600);
        bg.setSize(800, 600);
        bg.setVisible(true);
        MiFrame.this.add(bg);
        labelTexto.setLocation(0, 0);
        labelTexto.setVisible(true);
        getContentPane().add(mipanel);
        //this.getContentPane().setSize(800, 600);
        setSize(800, 600);
        System.out.println(this.getSize().toString());
        add(personaje);
        personaje.setVisible(true);

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setVisible(true);
        addKeyListener(new teclas());
        personaje.setFocusable(true);

        animaciones = new Timer(1000 / 10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indiceC++;
                indiceM++;
                
                personaje.setGasolina(personaje.getGasolina() - 2);
                labelTexto.setText("Magia: " + personaje.getGasolina() + "              Puntuacion: " + puntuacion+"        Vidas: "+personaje.getHp());
                if (indiceC >= cargaImagen.getC() && indiceF == 0) {
                    indiceC = 0;
                }
                ;
                if (indiceC >= cargaImagen.getC() && indiceF != 0) {
                    indiceC = cargaImagen.getC() - 3;
                }
                
                if (!personaje.isAlive()) {
                    animaciones.stop();
                    JOptionPane.showMessageDialog(null,"Perdiste: tu puntuación fue: "+MiFrame.this.puntuacion);
                    MiFrame.this.dispatchEvent(new WindowEvent(MiFrame.this,WindowEvent.WINDOW_CLOSING));
                    
                }
                if (personaje.getGasolina()<=0) {
                    //personaje.setHp(personaje.getHp()-1);
                    personaje.cuandoColisiona(false);
                    personaje.setGasolina(100);
                }
                
                e1.setLocation(e1.getX() + paso*10*e1.getOrientacionH(), e1.getY() + paso * 5);
                e2.setLocation(e2.getX()+paso*20, e2.getY());
                if (e1.getX()<=0 ||e1.getX()>=MiFrame.this.getWidth()-e1.getWidth()) {
                    e1.setOrientacionH(-1);
                }
                //e1.movX(paso * 10);
                if (e2.getRectangulo().intersects(personaje.getRectangulo())) {
                    e2.cuandoColisiona(false);

                    personaje.cuandoColisiona(false);
                }
                if (!e2.isAlive() || e2.getX() >= MiFrame.this.getWidth()) {
                    e2.setLocation(-e2.getWidth(), pos.nextInt(14) * e2.getHeight());
                    e2.setIsAlive(true);
                }
                if (e1.getRectangulo().intersects(personaje.getRectangulo())) {
                    e1.cuandoColisiona(false);

                    personaje.cuandoColisiona(false);
                }
                if (gas.getRectangulo().intersects(personaje.getRectangulo())) {
                    gas.cuandoColisiona(false);
                    personaje.cuandoColisiona(true);
                }

                if (gas.getY() >= MiFrame.this.getHeight() - gas.getHeight() || !gas.isAlive()) {
                    gas.setLocation(pos.nextInt(20) * 40, pos.nextInt(20) * 15);
                    gas.setIsAlive(true);
                }
                if (!e1.isAlive() || e1.getY() >= MiFrame.this.getHeight() - 100) {
                    e1.setLocation(pos.nextInt(14) * e1.getWidth(), pos.nextInt(14) * e1.getHeight());
                    e1.setIsAlive(true);
                }
                gas.setLocation(gas.getX(), gas.getY() + 10 * paso);
                for (Misil misil1 : misil) {
                    //misil1.movY(paso[indicePaso]);
                    misil1.setIcon(cargaMisil.getImagen(0, indiceC));
                    if (misil1.getY() >= 70 && misil1.getRectangulo().intersects(gas.getRectangulo())) {
                        misil1.cuandoColisiona(false);
                        gas.cuandoColisiona(false);
                        puntuacion += Datos.puntos[gas.getTipo()];
                    }
                    if (misil1.getRectangulo().intersects(e1.getRectangulo())) {
                        System.out.println("misil choca enemigo");
                        e1.cuandoColisiona(false);
                        misil1.cuandoColisiona(false);
                        if (!e1.isAlive()) {
                            puntuacion += Datos.puntos[e1.getTipo()];
                        }
                    }
                    if (misil1.getY() <= 0 || !misil1.isAlive()) {
                        personaje.setMunicion(personaje.getMunicion() + 1);
                        misil1.setLocation(misil1.getWidth() * personaje.getMunicion(),
                                MiFrame.this.getHeight() - misil1.getHeight() * 2);
                        misil1.setIsAlive(true);
                    }
                    if (misil1.getY() <= 486) {
                        misil1.setLocation(misil1.getX(), misil1.getY() - 10 * paso);
                    }
                    //System.out.println(misil1.getY());

                }
                personaje.setIcon(cargaImagen.getImagen(indiceF, indiceC));

                //mp.setLocation(mp.getX(), mp.getY()-10);
                indiceD++;
                if (indiceD >= cargaEnemigo.getC() - 4) {
                    indiceD = 0;
                }
                e1.setIcon(cargaEnemigo.getImagen(0, indiceD));
                e2.setIcon(cargaEnemigo.getImagen(3, indiceD));

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

                    personaje.setLocation(personaje.getX() + 10, personaje.getY());
                    //personaje.setIcon(cargaImagen.getImagen(2, 2));
                    indiceF = 2;
                    personaje.repaint();
                    repaint();
                } //if   
                break;

            case KeyEvent.VK_LEFT:
                if (personaje.getX() - 5 > 0) {

                    personaje.setLocation(personaje.getX() - 10, personaje.getY());
                    //personaje.setIcon(cargaImagen.getImagen(1, 2));
                    indiceF = 1;
                    personaje.repaint();
                    repaint();
                } //if
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("disparo!");
                /*misiles.add(new Misil(
                personaje.getX(),
                personaje.getY()-cargaMisil.getH(),
                cargaMisil.getImagen(0, 0),3,true));*/
                if (personaje.getMunicion() >= 0) {

                    misil[personaje.getMunicion()].setLocation(personaje.getX(), personaje.getY() - 20);

                    personaje.setMunicion(personaje.getMunicion() - 1);

                    System.out.println(personaje.getMunicion());
                }
                break;
            case KeyEvent.VK_UP:
                paso = 2;
            }//switch
             //System.out.println("ubicacion x,y: ("+personaje.getX()+","+personaje.getY()+")");
            System.out.println(personaje.getRectangulo().toString());
        }//keyPressed

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {

            case KeyEvent.VK_RIGHT:
                //personaje.setIcon(cargaImagen.getImagen(0, 0));
                indiceF = 0;
                break;

            case KeyEvent.VK_LEFT:
                //personaje.setIcon(cargaImagen.getImagen(0, 0));
                indiceF = 0;
                break;
            case KeyEvent.VK_UP:
                paso = 1;
                break;
            }//switch
        }
    }//classTeclas

}
