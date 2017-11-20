/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import javax.swing.Icon;


public class Enemigo extends Objeto {

    public Enemigo(int x, int y, Icon image, int tipo) {
        super(x, y, image, tipo);
        this.setVisible(true);
        this.setOrientacionV(1);
        this.setOrientacionH(-1);
    }
    @Override
    public void cuandoColisiona(boolean esAliado){
        super.cuandoColisiona(esAliado);
        if (esAliado) {
            this.setOrientacionH(-1);
        }
        if (!isAlive) {
            this.setLocation(-this.getWidth(), -this.getHeight());
            System.out.println(this.getLocation().toString());
        }
    }
    
}
