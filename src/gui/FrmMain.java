package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import funcion.Funciones;

public class FrmMain extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel pnlCentro, pnlNorte;
	public static NumField barraTxt;
	private JButton borrarC, borrarCE, signo, igual, mod, multi, div, resta, suma, dot, 
		uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero;
	private Dimension buttonSize = new Dimension(70, 50);
	public static char operador = 'n';
	public static Double n1;
    public static Double n2;
	public static Double res = null;
	
	public FrmMain () {
		setTitle("Calculadora");
		setIconImage(new ImageIcon("F:\\Tópicos avanzados de programación\\Calculadora\\src\\calculator.png").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350, 400);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		initComponents();
	}
	
	private void initComponents() {
		pnlCentro = new JPanel();
		pnlCentro.setLayout(new GridBagLayout());
		createButtons();
		add(pnlCentro, BorderLayout.CENTER);

		pnlNorte = new JPanel();
		barraTxt = new NumField();
		barraTxt.setMinimumSize(new Dimension(300, 60));
		barraTxt.setPreferredSize(new Dimension(300, 60));
		barraTxt.setMaximumSize(new Dimension(300, 60));
		barraTxt.setFont(new Font("Segoe UI Symbol", Font.BOLD, 24));
		pnlNorte.add(barraTxt);
		add(pnlNorte, BorderLayout.NORTH);
	}

	private void createButtons(){
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		//c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(1, 1, 1, 1);
		//c.ipadx = 0;
		//c.ipady = 7;
		
		borrarC = new JButton("C");
		borrarC.setPreferredSize(buttonSize);
		borrarC.addActionListener(this);
		pnlCentro.add(borrarC, c);
		
		c.gridx = 1;
		borrarCE = new JButton("CE");
		borrarCE.setPreferredSize(buttonSize);
		borrarCE.addActionListener(this);
		pnlCentro.add(borrarCE, c);

		c.gridx = 2;
		mod = new JButton("MOD");
		mod.setPreferredSize(buttonSize);
		mod.addActionListener(this);
		pnlCentro.add(mod, c);

		c.gridx = 3;
		multi = new JButton("*");
		multi.setPreferredSize(buttonSize);
		multi.addActionListener(this);
		pnlCentro.add(multi, c);

		c.gridy = 1;
		c.gridx = 0;
		siete = new JButton("7");
		siete.setPreferredSize(buttonSize);
		siete.addActionListener(this);
		pnlCentro.add(siete, c);

		c.gridx = 1;
		ocho = new JButton("8");
		ocho.setPreferredSize(buttonSize);
		ocho.addActionListener(this);
		pnlCentro.add(ocho, c);

		c.gridx = 2;
		nueve = new JButton("9");
		nueve.setPreferredSize(buttonSize);
		nueve.addActionListener(this);
		pnlCentro.add(nueve, c);

		c.gridx = 3;
		div = new JButton("/");
		div.setPreferredSize(buttonSize);
		div.addActionListener(this);
		pnlCentro.add(div, c);

		c.gridy = 2;
		c.gridx = 0;
		cuatro = new JButton("4");
		cuatro.setPreferredSize(buttonSize);
		cuatro.addActionListener(this);
		pnlCentro.add(cuatro, c);

		c.gridx = 1;
		cinco = new JButton("5");
		cinco.setPreferredSize(buttonSize);
		cinco.addActionListener(this);
		pnlCentro.add(cinco, c);

		c.gridx = 2;
		seis = new JButton("6");
		seis.setPreferredSize(buttonSize);
		seis.addActionListener(this);
		pnlCentro.add(seis, c);

		c.gridx = 3;
		resta = new JButton("-");
		resta.setPreferredSize(buttonSize);
		resta.addActionListener(this);
		pnlCentro.add(resta, c);

		c.gridy = 3;
		c.gridx = 0;
		uno = new JButton("1");
		uno.setPreferredSize(buttonSize);
		uno.addActionListener(this);
		pnlCentro.add(uno, c);

		c.gridx = 1;
		dos = new JButton("2");
		dos.setPreferredSize(buttonSize);
		dos.addActionListener(this);
		pnlCentro.add(dos, c);

		c.gridx = 2;
		tres = new JButton("3");
		tres.setPreferredSize(buttonSize);
		tres.addActionListener(this);
		pnlCentro.add(tres, c);

		c.gridx = 3;
		suma = new JButton("+");
		suma.setPreferredSize(buttonSize);
		suma.addActionListener(this);
		pnlCentro.add(suma, c);

		c.gridy = 4;
		c.gridx = 0;
		signo = new JButton("+/-");
		signo.setPreferredSize(buttonSize);
		signo.addActionListener(this);
		pnlCentro.add(signo, c);

		c.gridx = 1;
		cero = new JButton("0");
		cero.setPreferredSize(buttonSize);
		cero.addActionListener(this);
		pnlCentro.add(cero, c);

		c.gridx = 2;
		dot = new JButton(".");
		dot.setPreferredSize(buttonSize);
		dot.addActionListener(this);
		pnlCentro.add(dot, c);

		c.gridx = 3;
		igual = new JButton("=");
		igual.setPreferredSize(buttonSize);
		igual.addActionListener(this);
		pnlCentro.add(igual, c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Numeros		
		if (e.getSource() == uno || e.getSource() == dos || e.getSource() == tres || e.getSource() == cuatro || e.getSource() == cinco || e.getSource() == seis
			|| e.getSource() == siete || e.getSource() == ocho || e.getSource() == nueve || e.getSource() == cero) {
			JButton button = (JButton) e.getSource();
			if (res != null && operador == 'n' && !barraTxt.getText().equals(null) && res == Double.parseDouble(barraTxt.getText())) {
				barraTxt.setText(button.getText());
				n1 = null;
				res = null;
			} else if ((res != null && res == Double.parseDouble(barraTxt.getText()) || n1 != null && n1 == Double.parseDouble(barraTxt.getText()))) {
					barraTxt.setText(button.getText());
			} else
				barraTxt.setText(barraTxt.getText() + button.getText());
		}
		
		if (e.getSource() == dot) { //Otros botones
			if (res != null && operador == 'n' && res == Double.parseDouble(barraTxt.getText())){
				barraTxt.setText("0.");
				n1 = null;
				res = null;
			} else if (res != null && res == Double.parseDouble(barraTxt.getText()) || n1 != null && n1 == Double.parseDouble(barraTxt.getText())) {
				barraTxt.setText("0.");
			} else if (!barraTxt.getText().contains(Character.toString('.')))
				barraTxt.setText(barraTxt.getText() + "."); 
		} else if (e.getSource() == borrarC) {
			barraTxt.setText(null);
			res = null;
			n1 = null;
		} else if (e.getSource() == borrarCE && !barraTxt.getText().equals(null)){
			if (res == Double.parseDouble(barraTxt.getText())){
				res = null;
				n1 = null;
			}
			barraTxt.setText(null);
		} else if (e.getSource() == signo && !barraTxt.getText().equals(null)){
			Double num = (Double.parseDouble(barraTxt.getText())*-1.0);
			barraTxt.setText(num.toString());
		}
		
		if (e.getSource() == suma || e.getSource() == resta || e.getSource() == multi || e.getSource() == div || e.getSource() == mod || e.getSource() == igual){
			JButton button = (JButton) e.getSource();
			if (n1 != null && operador != 'n'){
				if (e.getSource() == igual){
					n2 = Double.parseDouble(barraTxt.getText());
					res = Funciones.operar(operador, n1, n2);
					barraTxt.setText(res.toString());
					operador = 'n';
					n1 = res;
				} else {
					n2 = Double.parseDouble(barraTxt.getText());
					res = Funciones.operar(operador, n1, n2);
					barraTxt.setText(res.toString());
					operador = button.getText().toLowerCase().charAt(0);
					n1 = res;	
				}
			} else if (res != null && res == Double.parseDouble(barraTxt.getText())) {
				operador = button.getText().toLowerCase().charAt(0);
			} else if (n1 != null && operador == 'n'){
					n2 = Double.parseDouble(barraTxt.getText());
					operador = button.getText().toLowerCase().charAt(0);
					res = Funciones.operar(operador, n1, n2);
					barraTxt.setText(res.toString());
					operador = 'n';
					n1 = res;
			} else {
				n1 = Double.parseDouble(barraTxt.getText());
				operador = button.getText().toLowerCase().charAt(0);
			}
		}
	}
}
