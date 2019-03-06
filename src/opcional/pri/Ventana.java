/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opcional.pri;

import javax.swing.JFrame;

/**
 *
 * @author juan
 */
public class Ventana extends JFrame {
    private Panel panel;
    
    public Ventana() {
        this.panel = new Panel();
        this.add(panel);
        this.setTitle("Ruleta Rusa");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
