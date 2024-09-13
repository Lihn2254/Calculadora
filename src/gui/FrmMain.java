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
	public static MathField barraTxt;
	public static JButton borrarC, borrarCE, signo, igual, mod, multi, div, resta, suma, dot, 
		uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero;
	private Dimension buttonSize = new Dimension(70, 50);
	
	public FrmMain () {
		setTitle("Calculadora");
		setIconImage(new ImageIcon("src\\calculator.png").getImage());
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
		barraTxt = new MathField();
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
		c.insets = new Insets(1, 1, 1, 1);
		
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
		Funciones.accionarBoton(e);
	}
}