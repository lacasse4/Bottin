import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Icon;

public class ActionDefaire extends BottinAbstractAction implements PropertyChangeListener {
	
	public ActionDefaire(Bottin bottin, 
			VuePrincipale vue, String texte, Icon icon, 
			String description, Integer mnemonic) {
		super(bottin, vue, texte, icon, description, mnemonic);
		gdc.addPropertyChangeListener(this);
		setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		gdc.faireCommande(new CommandeDefaire());
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		setEnabled(gdc.peutDefaire());		
	}

}
