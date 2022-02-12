import java.awt.event.ActionEvent;

import javax.swing.Icon;

public class ActionDetruire extends BottinAbstractAction {
    private FicheDialog dialog;
	
	public ActionDetruire(Bottin bottin, 
			VuePrincipale vue, String texte, Icon icon, 
			String description, Integer mnemonic) {
		super(bottin, vue, texte, icon, description, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		int index = vue.getIndex();
		gdc.faireCommande(new CommandeDetruire(bottin, index));
	}
}
