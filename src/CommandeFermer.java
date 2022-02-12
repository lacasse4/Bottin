import java.io.IOException;

import javax.swing.JOptionPane;

public class CommandeFermer implements Commande {

	private Bottin bottin;
	
	public CommandeFermer(Bottin bottin) {
		this.bottin = bottin;
	}

	public boolean faire() {
		try {
			bottin.ecrire();
		} catch (IOException e) {
    		JOptionPane.showMessageDialog(null, 
    				"Erreur � l'�criture du bottin" + " " + e.getMessage(), "Erreur",  
	    			JOptionPane.ERROR_MESSAGE, null);
		} finally {
			System.exit(0);
		}
		return false;
	}

	public void defaire() {	}

	public void refaire() {	}
}
