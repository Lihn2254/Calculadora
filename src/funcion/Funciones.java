package funcion;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import gui.FrmMain;

public class Funciones {
    private static Double n1, n2, res;
    private static char operador;

    public static Double operar(char operador, Double n1, Double n2){
        res = null;
        if (operador == '+'){
            res = n1 + n2;
        } else if (operador == '-'){
            res = n1 - n2;
        } else if (operador == '*'){
            res = n1*n2;
        } else if (operador == '/'){
            res = n1/n2;
        } else if (operador == 'm'){
            res = n1%n2;
        }
        return res;
    }

    public static void accionarBoton(ActionEvent e) {
        if (e.getSource() == FrmMain.uno || e.getSource() == FrmMain.dos || e.getSource() == FrmMain.tres || e.getSource() == FrmMain.cuatro || e.getSource() == FrmMain.cinco || e.getSource() == FrmMain.seis
			|| e.getSource() == FrmMain.siete || e.getSource() == FrmMain.ocho || e.getSource() == FrmMain.nueve || e.getSource() == FrmMain.cero) {
			JButton button = (JButton) e.getSource();
			if (res != null && operador == 'n' && !FrmMain.barraTxt.getText().equals(null) && res == Double.parseDouble(FrmMain.barraTxt.getText())) {
				FrmMain.barraTxt.setText(button.getText());
				n1 = null;
				res = null;
			} else if (res != null && res == Double.parseDouble(FrmMain.barraTxt.getText()) || n1 != null && n1 == Double.parseDouble(FrmMain.barraTxt.getText())) {
                FrmMain.barraTxt.setText(button.getText());
			} else {
                FrmMain.barraTxt.setText(FrmMain.barraTxt.getText() + button.getText());
            }
		}
		
		//Otros botones
		if (e.getSource() == FrmMain.dot) { 
			if (res != null && operador == 'n' && res == Double.parseDouble(FrmMain.barraTxt.getText())){
				FrmMain.barraTxt.setText("0.");
				n1 = null;
				res = null;
			} else if (res != null && res == Double.parseDouble(FrmMain.barraTxt.getText()) || n1 != null && n1 == Double.parseDouble(FrmMain.barraTxt.getText())) {
				FrmMain.barraTxt.setText("0.");
			} else if (!FrmMain.barraTxt.getText().contains(Character.toString('.')))
                FrmMain.barraTxt.setText(FrmMain.barraTxt.getText() + "."); 
		} else if (e.getSource() == FrmMain.borrarC) {
			FrmMain.barraTxt.setText(null);
			res = null;
			n1 = null;
		} else if (e.getSource() == FrmMain.borrarCE && !FrmMain.barraTxt.getText().equals(null)){
			if (res != null && res == Double.parseDouble(FrmMain.barraTxt.getText())){
				res = null;
				n1 = null;
			}
			FrmMain.barraTxt.setText(null);
		} else if (e.getSource() == FrmMain.signo){
            if (!FrmMain.barraTxt.getText().equals(null)){
                Double num = (Double.parseDouble(FrmMain.barraTxt.getText())*-1.0);
                if (res != null && res == Double.parseDouble(FrmMain.barraTxt.getText())) {
                    res = num;
                }
                FrmMain.barraTxt.setText(num.toString());
            }
		}
		
		//Operadores
		if (e.getSource() == FrmMain.suma || e.getSource() == FrmMain.resta || e.getSource() == FrmMain.multi || e.getSource() == FrmMain.div || e.getSource() == FrmMain.mod || e.getSource() == FrmMain.igual){
			JButton button = (JButton) e.getSource();
			if (n1 != null && operador != 'n'){
				if (e.getSource() == FrmMain.igual){
					n2 = Double.parseDouble(FrmMain.barraTxt.getText());
					res = operar(operador, n1, n2);
					FrmMain.barraTxt.setText(res.toString());
					operador = 'n';
					n1 = res;
				} else {
					n2 = Double.parseDouble(FrmMain.barraTxt.getText());
					res = operar(operador, n1, n2);
					FrmMain.barraTxt.setText(res.toString());
					operador = button.getText().toLowerCase().charAt(0);
					n1 = res;	
				}
			} else if (res != null && res == Double.parseDouble(FrmMain.barraTxt.getText())) {
				operador = button.getText().toLowerCase().charAt(0);
			} else if (n1 != null && operador == 'n'){
					n2 = Double.parseDouble(FrmMain.barraTxt.getText());
					operador = button.getText().toLowerCase().charAt(0);
					res = operar(operador, n1, n2);
					FrmMain.barraTxt.setText(res.toString());
					operador = 'n';
					n1 = res;
			} else {
				n1 = Double.parseDouble(FrmMain.barraTxt.getText());
				operador = button.getText().toLowerCase().charAt(0);
			}
		}
    }

    public static void accionarTecla(KeyEvent e) {
        char c = e.getKeyChar();

        //Numeros
        if (!Character.isDigit(c) && c != '.' && c != '+' && c != '-' && c != '*' && c != '/' && c != '%'
                && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_ENTER) {
            e.consume();
        } else {
            if (Character.isDigit(c)) {
                e.consume();
                if (res != null && operador == 'n' && !FrmMain.barraTxt.getText().equals(null)
                        && res == Double.parseDouble(FrmMain.barraTxt.getText())) {
                    FrmMain.barraTxt.setText(String.valueOf(c));
                    n1 = null;
                    res = null;
                } else if ((res != null && res == Double.parseDouble(FrmMain.barraTxt.getText())
                        || n1 != null && n1 == Double.parseDouble(FrmMain.barraTxt.getText()))) {
                    FrmMain.barraTxt.setText(String.valueOf(c));
                } else
                    FrmMain.barraTxt.setText(FrmMain.barraTxt.getText() + String.valueOf(c));
            }

            if (c == '.') { // Otros botones
                e.consume();
                if (res != null && operador == 'n'
                        && res == Double.parseDouble(FrmMain.barraTxt.getText())) {
                    FrmMain.barraTxt.setText("0.");
                    n1 = null;
                    res = null;
                } else if (res != null && res == Double.parseDouble(FrmMain.barraTxt.getText())
                        || n1 != null && n1 == Double.parseDouble(FrmMain.barraTxt.getText())) {
                    FrmMain.barraTxt.setText("0.");
                } else if (!FrmMain.barraTxt.getText().contains(Character.toString('.')))
                    FrmMain.barraTxt.setText(FrmMain.barraTxt.getText() + ".");
            }

            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == KeyEvent.VK_ENTER) {
                e.consume();
                if (n1 != null && operador != 'n') {
                    if (c == KeyEvent.VK_ENTER) {
                        n2 = Double.parseDouble(FrmMain.barraTxt.getText());
                        res = Funciones.operar(operador, n1, n2);
                        FrmMain.barraTxt.setText(res.toString());
                        operador = 'n';
                        n1 = res;
                    } else {
                        n2 = Double.parseDouble(FrmMain.barraTxt.getText());
                        res = Funciones.operar(operador, n1, n2);
                        FrmMain.barraTxt.setText(res.toString());
                        operador = String.valueOf(c).toLowerCase().charAt(0);
                        n1 = res;
                    }
                } else if (res != null && res == Double.parseDouble(FrmMain.barraTxt.getText())) {
                    operador = String.valueOf(c).toLowerCase().charAt(0);
                } else if (n1 != null && operador == 'n') {
                    n2 = Double.parseDouble(FrmMain.barraTxt.getText());
                    operador = String.valueOf(c).toLowerCase().charAt(0);
                    res = Funciones.operar(operador, n1, n2);
                    FrmMain.barraTxt.setText(res.toString());
                    operador = 'n';
                    n1 = res;
                } else {
                    n1 = Double.parseDouble(FrmMain.barraTxt.getText());
                    operador = String.valueOf(c).toLowerCase().charAt(0);
                }
            }
        }
    }
}
