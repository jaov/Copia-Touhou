/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import javax.swing.Icon;


public class Enemigos extends Objeto {

    public Enemigos(int x, int y, Icon image, int tipo) {
        super(x, y, image, tipo);
    }
    public void cuandoColisiona(boolean esAliado){
        super.cuandoColisiona(esAliado);
        if (esAliado) {
            this.setOrientacionH(-1);
        }
    }
    
}
