package bottinmvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Controleur implements ActionListener {
	
	private Bottin bottin;
	private VuePrincipale vue;

	/**
	 * Cronstruteur du controleur
	 * @param vue - Vue pour ce controleur
	 * @param bottin - Modèle du programme
	 */
	public Controleur(VuePrincipale vue, Bottin bottin) {
		this.bottin = bottin;
		this.vue = vue;
	}

	/**
	 * Créer un nouveau dialogue pour visionner la fiche sélectionnée
	 * @param index - index de la fiche sélectionnée
	 */
	public void voirFiche(int index) {
		FicheDialog ficheDialog = new FicheDialog(bottin.get(index), FicheDialog.Type.VOIR);
		ficheDialog.setVisible(true);
	}
	
	/**
	 * Créer un nouveau dialogue pour ajouter une nouvelle fiche au bottin
	 */
	public void ajouterFiche() {
		FicheDialog ficheDialog = new FicheDialog(new Fiche(), FicheDialog.Type.AJOUTER);
		ficheDialog.setVisible(true);
		if (ficheDialog.isOKPressed()) {
			bottin.addElement(ficheDialog.getFiche());
		}
	}
	
	/**
	 * Créer un nouveau dialogue pour éditer une fiche existante
	 * @param index
	 */
	public void editerFiche(int index) {
		FicheDialog ficheDialog = new FicheDialog(bottin.get(index), FicheDialog.Type.EDITER);
		ficheDialog.setVisible(true);
		if (ficheDialog.isOKPressed()) {
			bottin.set(index, ficheDialog.getFiche());
		}
	}
	
	/**
	 * Détruire une fiche
	 * @param index
	 */
	public void detruireFiche(int index) {
		Fiche fiche = bottin.get(index);
		int option = JOptionPane.showConfirmDialog(vue, 
				"Voulez-vous détruire la fiche de " + fiche.getPrenom() + " " + fiche.getNom() + " ?",
				"Détruire une fiche",
				JOptionPane.YES_NO_OPTION);
		if (option == 0) {
			bottin.remove(index);
		}
	}

	/**
	 * Sauver le bottin et ferme l'application
	 */
	public void fermer() {
		ecrireBottin();
		System.exit(0);
	}
	
	/**
	 * Écrire le bottin dans un fichier texte
	 */
	private void ecrireBottin() {
		try {
			bottin.ecrire();
		} catch (IOException e) {
    		JOptionPane.showMessageDialog(null, 
	    			"Erreur", "Erreur à l'écriture du bottin", JOptionPane.ERROR_MESSAGE, null);
		}
	}
	
	/**
	 * Lire le bottin d'un fichier texte
	 */
	public void lireBottin() {
		try {
			bottin.lire();
		} catch (IOException e) {
    		JOptionPane.showMessageDialog(null, 
	    			"Erreur", "Erreur à la lecture du bottin", JOptionPane.ERROR_MESSAGE, null);
		}
	}
	
	/**
	 * Gérer les événements provenant des boutons
	 */
	public void actionPerformed(ActionEvent e) {
		int index = vue.getIndex();
		String commande = e.getActionCommand();
		if (commande.equals(VuePrincipale.CMD_VOIR)) {
			if (index > -1) {
				voirFiche(index);
			}
		}
		else if (commande.equals(VuePrincipale.CMD_AJOUTER)) {
			ajouterFiche();
		}
		else if (commande.equals(VuePrincipale.CMD_EDITER)) {
			if (index > -1) {
				editerFiche(index);
			}
		}
		else if (commande.equals(VuePrincipale.CMD_DETRUIRE)) {
			if (index > -1) {
				detruireFiche(index);
//	        	vue.updateIndex();
			}
		}
		else if (commande.equals(VuePrincipale.CMD_FERMER)) {
			fermer();
		}
	}
}
