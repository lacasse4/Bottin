import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JOptionPane;

public class BottinDemo {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void createAndShowGUI() throws Exception {
		Bottin bottin = new Bottin();
		try {
			bottin.lire();
		} catch (IOException e) {
    		JOptionPane.showMessageDialog(null, 
	    			"Erreur", "Erreur à la lecture du bottin", 
	    			JOptionPane.ERROR_MESSAGE, null);
		}
		new VuePrincipale(bottin);
	}
}

