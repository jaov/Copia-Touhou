/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author jesus.ochoa
 */
public class CargaImagen {

    private BufferedImage spritesheet;
    private BufferedImage[][] personaje;
    private int x, y, w, h, pasoH, pasoV,c,f;

    public CargaImagen(int x, int y, int w, int h, int c, int f,int pasoH, int pasoV, String url ) {
        this.c=c;
        this.f=f;
        this.personaje = new BufferedImage[f][c];
        try {
            this.spritesheet = ImageIO.read(new File(url));
        } catch (IOException ex) {
            System.out.println("no se cargo la imagen");
            Logger.getLogger(CargaImagen.class.getName()).log(Level.SEVERE, null, ex);
        }//trycatch
        System.out.println("si se cargo la imagen");
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                personaje[i][j] = spritesheet.getSubimage(x +(pasoH+w)*j, y +(pasoV+h)*i, w, h);
                System.out.println("se cargo la imagen en "+i+", "+j);
            }
        }
       
    }//constructor

    //<editor-fold defaultstate="collapsed" desc="setter y getter">
    public BufferedImage getSpritesheet() {
        return spritesheet;
    }
    
    public void setSpritesheet(BufferedImage spritesheet) {
        this.spritesheet = spritesheet;
    }
    
    public BufferedImage[][] getPersonaje() {
        return personaje;
    }
    
    public void setPersonaje(BufferedImage[][] personaje) {
        this.personaje = personaje;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getW() {
        return w;
    }
    
    public void setW(int w) {
        this.w = w;
    }
    
    public int getH() {
        return h;
    }
    
    public void setH(int h) {
        this.h = h;
    }
    
    public int getPasoH() {
        return pasoH;
    }
    
    public void setPasoH(int pasoH) {
        this.pasoH = pasoH;
    }
    
    public int getPasoV() {
        return pasoV;
    }
    
    public void setPasoV(int pasoV) {
        this.pasoV = pasoV;
    }

    public int getC() {
        return c;
    }

    public int getF() {
        return f;
    }
    
    public ImageIcon getImagen(int i, int j){
        return new ImageIcon(personaje[i][j]);
    }
//</editor-fold>
    
}//clase
