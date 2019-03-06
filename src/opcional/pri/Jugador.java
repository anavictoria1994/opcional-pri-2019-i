/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opcional.pri;

/**
 *
 * @author juan
 */
public class Jugador {
    private int id;
    private String nombre;
    private String estado;
    
    public Jugador(String nombre, int id) {
        this.id = id;
        this.nombre = nombre;
        this.estado = "vivo";
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
