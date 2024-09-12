package gui;

import javax.swing.JButton;
import javax.swing.JTextField;

import funcion.Funciones;

import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class NumField extends JTextField implements KeyListener, ActionListener {
	private static final long serialVersionUID = 1L;
	
	public NumField() {
		super();
		addKeyListener(this);
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    	char c = e.getKeyChar();

        if (!Character.isDigit(c) && c != '.' && c != '+' && c != '-' && c != '*' && c != '/' && c != '%'
                && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_ENTER) {
            e.consume();
        } else {
            if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0') {
                JButton button = (JButton) e.getSource();
                if (FrmMain.res != null && FrmMain.operador == 'n' && !getText().equals(null)
                        && FrmMain.res == Double.parseDouble(getText())) {
                    setText(button.getText());
                    FrmMain.n1 = null;
                    FrmMain.res = null;
                } else if ((FrmMain.res != null && FrmMain.res == Double.parseDouble(getText())
                        || FrmMain.n1 != null && FrmMain.n1 == Double.parseDouble(getText()))) {
                    setText(button.getText());
                } else
                    setText(getText() + button.getText());
            }

            if (c == '.') { // Otros botones
                if (FrmMain.res != null && FrmMain.operador == 'n' && FrmMain.res == Double.parseDouble(getText())) {
                    setText("0.");
                    FrmMain.n1 = null;
                    FrmMain.res = null;
                } else if (FrmMain.res != null && FrmMain.res == Double.parseDouble(getText())
                        || FrmMain.n1 != null && FrmMain.n1 == Double.parseDouble(getText())) {
                    setText("0.");
                } else if (!getText().contains(Character.toString('.')))
                    setText(getText() + ".");
            } /*else if (e.getSource() == borrarC) {
                setText(null);
                FrmMain.res = null;
                FrmMain.n1 = null;
            } else if (e.getSource() == borrarCE && !getText().equals(null)) {
                if (FrmMain.res == Double.parseDouble(getText())) {
                    FrmMain.res = null;
                    FrmMain.n1 = null;
                }
                setText(null);
            } else if (e.getSource() == signo && !getText().equals(null)) {
                Double num = (Double.parseDouble(getText()) * -1.0);
                setText(num.toString());
            }*/

            if (c == '+' && c == '-' && c == '*' && c == '/' && c == '%' && c == KeyEvent.VK_ENTER) {
                JButton button = (JButton) e.getSource();
                if (FrmMain.n1 != null && FrmMain.operador != 'n') {
                    if (c == KeyEvent.VK_ENTER) {
                        FrmMain.n2 = Double.parseDouble(getText());
                        FrmMain.res = Funciones.operar(FrmMain.operador, FrmMain.n1, FrmMain.n2);
                        setText(FrmMain.res.toString());
                        FrmMain.operador = 'n';
                        FrmMain.n1 = FrmMain.res;
                    } else {
                        FrmMain.n2 = Double.parseDouble(getText());
                        FrmMain.res = Funciones.operar(FrmMain.operador, FrmMain.n1, FrmMain.n2);
                        setText(FrmMain.res.toString());
                        FrmMain.operador = button.getText().toLowerCase().charAt(0);
                        FrmMain.n1 = FrmMain.res;
                    }
                } else if (FrmMain.res != null && FrmMain.res == Double.parseDouble(getText())) {
                    FrmMain.operador = button.getText().toLowerCase().charAt(0);
                } else if (FrmMain.n1 != null && FrmMain.operador == 'n') {
                    FrmMain.n2 = Double.parseDouble(getText());
                    FrmMain.operador = button.getText().toLowerCase().charAt(0);
                    FrmMain.res = Funciones.operar(FrmMain.operador, FrmMain.n1, FrmMain.n2);
                    setText(FrmMain.res.toString());
                    FrmMain.operador = 'n';
                    FrmMain.n1 = FrmMain.res;
                } else {
                    FrmMain.n1 = Double.parseDouble(getText());
                    FrmMain.operador = button.getText().toLowerCase().charAt(0);
                }
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
