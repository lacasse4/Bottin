import java.awt.event.ActionEvent;
import javax.swing.Icon;

public class FicheActionEditer extends BottinAbstractAction {

	private static final long serialVersionUID = -4907665048113960782L;
	
	public FicheActionEditer(Bottin bottin, 
			VuePrincipale vue, String texte, Icon icon, 
			String description, Integer mnemonic) {
		super(bottin, vue, texte, icon, description, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		int index = vue.getIndex();
		gdc.faireCommande(new FicheCommandeEditer(bottin, index));
	}
}
