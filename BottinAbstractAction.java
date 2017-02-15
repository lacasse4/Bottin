import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;
import javax.swing.Icon;

public abstract class BottinAbstractAction extends AbstractAction {

	protected final static GestionnaireDeCommandes gdc = new GestionnaireDeCommandes();
	protected Bottin bottin;
    protected VuePrincipale vue;

	public BottinAbstractAction(Bottin bottin, 
			VuePrincipale vue, String texte, Icon icon, 
			String description, Integer mnemonic) {
		super(texte, icon);
		putValue(SHORT_DESCRIPTION, description);
		putValue(MNEMONIC_KEY, mnemonic);
		this.bottin = bottin;
		this.vue = vue;
	}
}
