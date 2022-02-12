import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.Icon;

public class ActionAjouter extends BottinAbstractAction {
	
	public ActionAjouter(Bottin bottin, 
			VuePrincipale vue, String texte, Icon icon, 
			String description, Integer mnemonic) {
		super(bottin, vue, texte, icon, description, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		int index = vue.getIndex();
		index = index < 0 ? bottin.size() : index;
		gdc.faireCommande(new CommandeAjouter(bottin, index));
	}
}
