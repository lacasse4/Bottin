
public class CommandeVoir implements Commande {
	
	private int index;
	private Bottin bottin;
	
	public CommandeVoir(Bottin bottin, int index) {
		this.index = index;
		this.bottin = bottin;
	}

	public boolean faire() {
		Fiche fiche = bottin.get(index);
		FicheDialog dialog = new FicheDialog(fiche, FicheDialog.Type.VOIR);
		dialog.setVisible(true);
		return false;
	}

	public void defaire() { }

	public void refaire() {	}
}
