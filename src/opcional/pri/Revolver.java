/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opcional.pri;

import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class Revolver implements InterfaceRevolver {
    private ArrayList<Integer> recamara;
    private int posicion;
    
    public Revolver() {
        this.recamara = new ArrayList(6);
        for (int i = 0; i < 6; i++) {
            this.recamara.add(0);
        }
        
        this.posicion = 0;
    }
    @Override
    public Boolean disparar() {
        Boolean resultado = this.recamara.get(posicion) == 1;
        posicion++;
        return resultado;
    }

    @Override
    public void ponerBala() {
        int aleatorio = (int)(Math.random() * 5);
        this.recamara.set(aleatorio, 1);
    }
    
}
