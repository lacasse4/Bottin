import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Icon;

public class FicheActionRefaire extends BottinAbstractAction implements PropertyChangeListener {
	
	private static final long serialVersionUID = -6414412507090572915L;

	public FicheActionRefaire(Bottin bottin,
			VuePrincipale vue, String texte, Icon icon, 
			String description, Integer mnemonic) {
		super(bottin, vue, texte, icon, description, mnemonic);
		gdc.addPropertyChangeListener(this);
		setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		gdc.faireCommande(new FicheCommandeRefaire());
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		setEnabled(gdc.peutRefaire());		
	}
}
