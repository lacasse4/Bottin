import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Icon;

public class FicheActionDefaire extends BottinAbstractAction implements PropertyChangeListener {
	
	private static final long serialVersionUID = 3330570928347098003L;

	public FicheActionDefaire(Bottin bottin,
			VuePrincipale vue, String texte, Icon icon, 
			String description, Integer mnemonic) {
		super(bottin, vue, texte, icon, description, mnemonic);
		gdc.addPropertyChangeListener(this);
		setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		gdc.faireCommande(new FicheCommandeDefaire());
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		setEnabled(gdc.peutDefaire());		
	}

}
