import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;

public class FicheActionDefaire extends BottinAbstractAction implements Observer {
	
	public FicheActionDefaire(Bottin bottin, 
			VuePrincipale vue, String texte, Icon icon, 
			String description, Integer mnemonic) {
		super(bottin, vue, texte, icon, description, mnemonic);
		gdc.addObserver(this);
		setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		gdc.faireCommande(new FicheCommandeDefaire());
	}
	
	public void update(Observable o, Object arg) { 
		setEnabled(gdc.peutDefaire());
	}

}
