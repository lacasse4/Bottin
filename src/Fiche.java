

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Fiche - une fiche du bottin t�l�phonique
 * @author Vincent Lacasse
 *
 */
public class Fiche {
	private String nom;
	private String prenom;
	private String numero;
	private String adresse;
	private String courriel;
	
	/**
	 * Cr�er une fiche � partir du nom, pr�nom, num�ro, adresse, courriel
	 * @param nom - nom de famille
	 * @param prenom - pr�nom
	 * @param numero - num�ro de t�l�phone
	 * @param adresse - adresse postale
	 * @param courriel - courriel
	 */
	public Fiche(String nom, String prenom, String numero, String adresse, String courriel) {
		setFiche(nom, prenom, numero, adresse, courriel);
	}
	
	/**
	 * Cr�er une fiche vide
	 */
	public Fiche() {
		this("", "", "", "", "");
	}
	
	/**
	 * Cr�er une fiche � partir d'une fiche existante
	 * @param fiche
	 */
	public Fiche(Fiche fiche) {
		setFiche(fiche);
	}
	
	/**
	 * G�n�rer une String qui contient nom, pr�nom, t�l�phone seulement
	 * @return String - chaine de caract�re contenant nom, pr�nom, t�l�phone
	 */
    public String getElementListe() {
		return getNom() + ", " + getPrenom() + ", " + getNumero();
    }

    /**
     * �crire la fiche dans un PrintWriter 
     * @param out - PrintWriter o� la fiche est �crite
     * @throws IOException
     */
	public void ecrire(PrintWriter out) throws IOException {
		out.println(nom);
		out.println(prenom);
		out.println(numero);
		out.println(adresse);
		out.println(courriel);
	}

	/**
	 * Lire et cr�er une fiche � partir d'un BufferedReader 
	 * @param in - BufferedReader d'o� on lit le texte de la fiche
	 * @return nouvelle fiche
	 * @throws IOException
	 */
	public static Fiche lire(BufferedReader in) throws IOException {
		return new Fiche(
				in.readLine(), // nom
				in.readLine(), // prenom
				in.readLine(), // telephone
				in.readLine(), // adresse
				in.readLine()  // courriel
				);
	}
	
	/**
	 * Initialise la fiche avec les valeurs de nom, pr�nom, num�ro, adresse et courriel
	 * @param nom
	 * @param prenom
	 * @param numero
	 * @param adresse
	 * @param courriel
	 */
	public void setFiche(String nom, String prenom, String numero, String adresse, String courriel) {
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.adresse = adresse;
		this.courriel = courriel;
	}
	
	/**
	 * Initialise la fiche � partir d'une autre fiche
	 * @param fiche
	 */
	public void setFiche(Fiche fiche) {
		setFiche(fiche.nom, fiche.prenom, fiche.numero, fiche.adresse, fiche.courriel);
	}

	/*
	 * Getters g�n�r�s automatiquement 
	 */
	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNumero() {
		return numero;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getCourriel() {
		return courriel;
	}
}
