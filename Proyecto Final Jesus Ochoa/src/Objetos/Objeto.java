/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author jesus.ochoa
 */
public class Objeto extends JLabel{

    private int x;
    private int y,hp,orientacionH, orientacionV;
    private int indiceFP, indiceCP;
    boolean isAlive;

    public Objeto(int x, int y, Icon image, int tipo) {
        super(image);
        //this.setSize(image.getIconWidth(), image.getIconHeight());
        this.setBounds(x, y, image.getIconWidth(), image.getIconHeight());
        this.x = x;
        this.indiceFP=0;
        this.indiceCP=0;
        this.orientacionH=0;
        this.orientacionV=0;
        this.isAlive=true;
        //this.setVisible(true);
        this.y = y;
        this.hp=Resources.Datos.vectorhp[tipo];
        //this.setVisible(true);
        //0 avion, 1 barco, 2 gasolina, 3 misil, 4 pared
        
        
    }
    public Rectangle getRectangulo(){
        return new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
    
    public void cuandoColisiona(boolean esAliado){
        System.out.println("colision!");
        if (!esAliado) {
            this.hp--;
        }    
        
        if (hp<=0) {
            this.isAlive=false;
            System.out.println("murio "+this.getClass().getCanonicalName());
        }
    }
    
    

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setOrientacionH(int orientacionH) {
        this.orientacionH *= orientacionH;
    }

    public void setOrientacionV(int orientacionV) {
        this.orientacionV = orientacionV;
    }
    

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    

    public boolean isAlive() {
        return isAlive;
    }
    public void movY(int paso){
        this.setLocation(this.getX(), this.getY()+paso*this.orientacionV);
        
    }
    public void movX(int paso){
        this.setLocation(this.getX()+paso*this.orientacionH, this.getY());
    }
    
    
}
