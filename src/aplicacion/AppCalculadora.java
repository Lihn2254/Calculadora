package aplicacion;

//import java.awt.GraphicsEnvironment;

import gui.FrmMain;

public class AppCalculadora {

	public static void main(String[] args) {

		/*GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String []fontFamilies = ge.getAvailableFontFamilyNames();
		for (String string : fontFamilies) {
			System.out.println(string);
		}*/
		
		FrmMain MainFrame = new FrmMain();
		MainFrame.setVisible(true);
	}

}
