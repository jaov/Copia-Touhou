/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import javax.swing.Icon;


public class Misil extends Objeto {

    public Misil(int x, int y, Icon image, int tipo, boolean lanzaAliado) {
        super(x, y, image, tipo);
        if (lanzaAliado) {
            this.setOrientacionV(-1);
        }
        else this.setOrientacionV(1);
    }

    
}
