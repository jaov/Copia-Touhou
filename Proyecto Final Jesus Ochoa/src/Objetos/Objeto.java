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
    boolean isAlive;

    public Objeto(int x, int y, Icon image, int tipo) {
        super(image);
        this.x = x;
        this.orientacionH=0;
        this.orientacionV=0;
        this.y = y;
        this.hp=Resources.Datos.vectorhp[tipo];

        //0 avion, 1 barco, 2 gasolina, 3 misil, 4 pared
        
        
    }
    public Rectangle getRectangulo(){
        return new Rectangle(x, y, this.getWidth(), this.getHeight());
    }
    
    public void cuandoColisiona(boolean esAliado){
        if (!esAliado) {
            this.hp--;
        }    
        
        if (hp<=0) {
            this.isAlive=false;
        }
    }
    
    public void moverse(){
        this.x+=orientacionH;
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
        this.y+=paso*this.orientacionV;
    }
    public void movX(int paso){
        this.x+=paso*this.orientacionH;
    }
    
    
}
