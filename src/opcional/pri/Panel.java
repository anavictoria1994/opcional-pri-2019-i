/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opcional.pri;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author juan
 */
public class Panel extends JPanel implements ActionListener {
    private JButton anadirJugador, iniciarJuego, disparar, nuevaRonda;
    private JTextField nombreCampo;
    private JTextArea turnoArea, estadoArea, jugadoresArea;
    private JLabel nombreLabel, turnoLabel, estadoLabel, jugadoresLabel;
    
    private Juego juego;
    
    public Panel() {
        this.juego = new Juego();
        
        this.setLayout(null);
        this.nombreLabel = new JLabel("Nombre:");
        this.add(nombreLabel);
        this.nombreLabel.setBounds(20, 20, 50, 20);
        
        this.nombreCampo = new JTextField();
        this.add(nombreCampo);
        this.nombreCampo.setBounds(80, 20, 125, 25);
        
        this.anadirJugador = new JButton("Anadir Jugador");
        this.anadirJugador.addActionListener(this);
        this.anadirJugador.setActionCommand("anadir");
        this.add(this.anadirJugador);
        this.anadirJugador.setBounds(120, 60, 125, 25);
        
        this.iniciarJuego = new JButton("Iniciar Juego");
        this.iniciarJuego.addActionListener(this);
        this.iniciarJuego.setActionCommand("iniciar");
        this.add(this.iniciarJuego);
        this.iniciarJuego.setBounds(120, 90, 125, 25);
        
        this.turnoLabel = new JLabel("Turno:");
        this.add(turnoLabel);
        this.turnoLabel.setBounds(20, 120, 50, 25);
        
        this.turnoArea = new JTextArea();
        this.turnoArea.setEditable(false);
        this.add(turnoArea);
        this.turnoArea.setBounds(80, 120, 125, 25);
        
        this.disparar = new JButton("Disparar");
        this.disparar.addActionListener(this);
        this.disparar.setActionCommand("disparar");
        this.add(this.disparar);
        this.disparar.setBounds(120, 160, 125, 25);
        
        this.estadoLabel = new JLabel("Estado del Juego:");
        this.add(estadoLabel);
        this.estadoLabel.setBounds(120, 190, 125, 25);
        
        this.estadoArea = new JTextArea();
        this.add(estadoArea);
        this.estadoArea.setEditable(false);
        this.estadoArea.setText(this.juego.estadoJuego());
        this.estadoArea.setBounds(20, 240, 200, 25);
        
        this.jugadoresLabel = new JLabel("Jugadores:");
        this.add(jugadoresLabel);
        this.jugadoresLabel.setBounds(120, 280, 125, 25);
        
        this.jugadoresArea = new JTextArea();
        this.add(jugadoresArea);
        this.jugadoresArea.setEditable(false);
        this.jugadoresArea.setBounds(10, 310, 250, 180);
        
        this.nuevaRonda = new JButton("Nueva Ronda");
        this.nuevaRonda.addActionListener(this);
        this.nuevaRonda.setActionCommand("nueva");
        this.add(this.nuevaRonda);
        this.nuevaRonda.setBounds(120, 500, 125, 25);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch(ae.getActionCommand()){
            case "anadir":
                String nombre = this.nombreCampo.getText();
                if(!nombre.isEmpty()){
                    Boolean exito = this.juego.agregarJugador(nombre);
                    if (exito) {
                        this.jugadoresArea.append(nombre + '\n');
                    }
                    this.nombreCampo.setText("");
                }
                break;
            case "iniciar":
                this.juego.iniciarJuego();
                this.estadoArea.setText(this.juego.estadoJuego());
                this.turnoArea.setText(this.juego.getNombreTurno());
                break;
            case "disparar":
                this.juego.disparar();
                this.estadoArea.setText(this.juego.estadoJuego());
                this.turnoArea.setText(this.juego.getNombreTurno());
                break;
            case "nueva":
                this.juego.nuevaRonda();
                this.estadoArea.setText(this.juego.estadoJuego());
                this.turnoArea.setText(this.juego.getNombreTurno());
                this.jugadoresArea.setText("");
                break;
        }
    }
}
