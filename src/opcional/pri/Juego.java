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
public class Juego implements InterfaceJuego {
    private ArrayList<Jugador> jugadores;
    private Revolver revolver;
    private String estado;
    private int id;
    private int turno;
    
    public Juego() {
        this.inizializar();
    }
    
    public Boolean agregarJugador(String nombre) {
        if (this.estado.equals("nuevo")) {
            this.jugadores.add(new Jugador(nombre, this.id));
            this.id++;
            return true;
        }
        return false;
    }
    
    private void inizializar() {
        this.id = 0;
        this.turno = 0;
        
        this.jugadores = null;
        this.jugadores = new ArrayList();

        this.revolver = null;
        this.revolver = new Revolver();

        this.estado = null;
        this.estado = "nuevo";
    }
    
    private Jugador getJugadorTurno(){
        return this.jugadores.get(this.turno);
    }
    
    public String getNombreTurno() {
        if (!this.estado.equals("nuevo")){
            Jugador aux = this.getJugadorTurno();
            return aux.getNombre() + "(" + aux.getEstado()  + ")";
        }
        return "";
    }
    
    public void disparar() {
        if (this.estado.equals("jugando")) {
            if (this.revolver.disparar()) {
                this.getJugadorTurno().setEstado("muerto");
                this.estado = "terminado";
            } else {
                if (++this.turno >= this.jugadores.size()) {
                    this.turno = 0;
                }
            }
        }
    }

    @Override
    public void iniciarJuego() {
        if(this.jugadores.size() > 1 && this.estado.equals("nuevo")) {
            this.estado = "jugando";
            this.revolver.ponerBala();
        }
    }

    @Override
    public String estadoJuego() {
        return this.estado;
    }

    @Override
    public void nuevaRonda() {
        if(this.estado.equals("terminado")){
            this.inizializar();
        }
    }
    
}
