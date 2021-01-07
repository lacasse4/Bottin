import java.awt.event.ActionEvent;

import javax.swing.Icon;

public class FicheActionDetruire extends BottinAbstractAction {
 
	private static final long serialVersionUID = 7565089855842172027L;
	
	public FicheActionDetruire(Bottin bottin, 
			VuePrincipale vue, String texte, Icon icon, 
			String description, Integer mnemonic) {
		super(bottin, vue, texte, icon, description, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		int index = vue.getIndex();
		gdc.faireCommande(new FicheCommandeDetruire(bottin, index));
	}
}
