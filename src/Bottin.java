

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.DefaultListModel;

/**
 * Bottin - Bottin téléphonique
 * @author Vincent Lacasse
 *
 */
@SuppressWarnings("serial")
public class Bottin extends DefaultListModel<Fiche> {
	public final static String NOM_FICHIER = "Bottin.txt";

	/**
	 * Constructeur du bottin 
	 */
	public Bottin() {
		super();
	}

	/**
	 * Lire le bottin à partir d'un fichier texte
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void lire() throws FileNotFoundException, IOException {
		
		File fichier = new File(NOM_FICHIER);

		if (fichier.exists()) {
			FileReader fr = new FileReader(fichier);
			BufferedReader br = new BufferedReader(fr);

			while(br.ready()) {
				Fiche f = Fiche.lire(br);
				addElement(f);
			}

			br.close();
		}
	}

	/**
	 * Écrire le bottin dans un fichier texte
	 * @throws IOException
	 */
	public void ecrire() throws IOException {
		
		File fichier = new File(NOM_FICHIER);
		
		FileWriter fw = new FileWriter(fichier, false);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);

		for (int i = 0; i < size(); i++) {
			get(i).ecrire(pw);
		}
		
		pw.close();
	}
}
