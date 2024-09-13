package gui;

import javax.swing.JTextField;
import funcion.Funciones;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MathField extends JTextField implements KeyListener {
	private static final long serialVersionUID = 1L;
	
	public MathField() {
		super();
		addKeyListener(this);
	}
	
    @Override
    public void keyTyped(KeyEvent e) {
        Funciones.accionarTecla(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}
