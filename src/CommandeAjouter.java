
public class CommandeAjouter implements Commande {

	private int index;
	private Bottin bottin;
	private Fiche ficheRetiree = null;
	
	public CommandeAjouter(Bottin bottin, int index) {
		this.bottin = bottin;
		this.index = index;
	}

	public boolean faire() {
		FicheDialog dialog = new FicheDialog(new Fiche(), FicheDialog.Type.AJOUTER);
		dialog.setVisible(true);
		if (dialog.isOKPressed()) {
			Fiche fiche = dialog.getFiche();
			bottin.add(index, fiche);
			return true;
		}
		return false;
	}

	public void refaire() {
		bottin.add(index, ficheRetiree);
	}
	
	public void defaire() {
		ficheRetiree = bottin.remove(index);
	}
}
