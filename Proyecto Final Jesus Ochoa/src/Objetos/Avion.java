/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Resources.Datos;
import javax.swing.Icon;


public class Avion extends Objeto{
    
    private int gasolina;
    private int municion;

    public int getMunicion() {
        return municion;
    }

    public void setMunicion(int municion) {
        this.municion = municion;
    }

    public Avion(int x, int y, Icon image, int tipo) {
        super(x, y, image, tipo);
        this.municion = Datos.MAX_MISILES-1;
        this.gasolina = 100;
    }

    public int getGasolina() {
        return gasolina;
    }

    public void setGasolina(int gasolina) {
        this.gasolina = gasolina;
    }
    public void cuandoColisiona(boolean esAliado){
        super.cuandoColisiona(esAliado);
        if (esAliado) {
            this.gasolina=100;
        }
        
    }
}
