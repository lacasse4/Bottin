

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * FicheDialog - Dialogue Swing pour afficher ou editer une fiche
 * Cr�er avec l'aide de Eclipse WindowBuilder
 * @author Vincent Lacasse
 *
 */
@SuppressWarnings("serial")
public class FicheDialog extends JDialog {
	public enum Type { VOIR, AJOUTER, EDITER }; 
	public static final String ACTION_OK = "OK";
	public static final String ACTION_CANCEL = "CANCEL";
	public static final int FIELD_LENGTH = 40;

	private boolean OKPressed;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtNumero;
	private JTextField txtAdresse;
	private JTextField txtCourriel;
	JButton okButton;
	JButton cancelButton;
	
	/**
	 * Create the dialog.
	 */
	public FicheDialog(Fiche fiche, Type type) {
		super((java.awt.Frame) null, true);
		setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
		
		switch (type) {
		case VOIR:
			setTitle("Voir une fiche"); 
			break;
		case AJOUTER: 
			setTitle("Ajouter une fiche");
			break;
		case EDITER: 
			setTitle("�diter une fiche"); 
			break;		
		}
		
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		contentPanel.setLayout(new GridLayout(5, 2, 0, 0));

		JLabel lblNom = new JLabel("Nom:");
		lblNom.setHorizontalAlignment(SwingConstants.LEFT);
		contentPanel.add(lblNom);

		txtNom = new JTextField();
		contentPanel.add(txtNom);
		txtNom.setColumns(FIELD_LENGTH);
		txtNom.setEditable(type != Type.VOIR);
		txtNom.setActionCommand(ACTION_OK);

		JLabel lblPrenom = new JLabel("Pr�nom:");	
		contentPanel.add(lblPrenom);

		txtPrenom = new JTextField();
		contentPanel.add(txtPrenom);
		txtPrenom.setColumns(FIELD_LENGTH);
		txtPrenom.setEditable(type != Type.VOIR);

		JLabel lblTelephone = new JLabel("T�l�phone:");
		contentPanel.add(lblTelephone);

		txtNumero = new JTextField();
		contentPanel.add(txtNumero);
		txtNumero.setColumns(FIELD_LENGTH);
		txtNumero.setEditable(type != Type.VOIR);

		JLabel lblAdresse = new JLabel("Adresse:");
		contentPanel.add(lblAdresse);

		txtAdresse = new JTextField();
		contentPanel.add(txtAdresse);
		txtAdresse.setColumns(FIELD_LENGTH);
		txtAdresse.setEditable(type != Type.VOIR);

		JLabel lblCourriel = new JLabel("Courriel:");
		contentPanel.add(lblCourriel);

		txtCourriel = new JTextField();
		contentPanel.add(txtCourriel);
		txtCourriel.setColumns(FIELD_LENGTH);
		txtCourriel.setEditable(type != Type.VOIR);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		okButton = new JButton("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		okButton.setActionCommand(ACTION_OK);
		
		cancelButton = new JButton("Cancel");
		buttonPane.add(cancelButton);
		cancelButton.setActionCommand(ACTION_CANCEL);

		// Mettre � jour les champs du dialogue avec la fiche fournie en param�tre.
		setTextFields(fiche);
		
		// On doit cr�er le controleur de fiche � la fin afin d'�viter un NullPointerException 
		FicheControleur fc = new FicheControleur(this);
		txtNom.addActionListener(fc);
		txtNom.getDocument().addDocumentListener(fc);
		okButton.addActionListener(fc);
		cancelButton.addActionListener(fc);		

		// Activer le bouton OK au d�but si on voit ou on �dite la fiche
		enableOK(type == Type.VOIR || type == Type.EDITER);
	
		// Rendre le bouton cancel visible que si on ajoute ou on �dite une fiche
		cancelButton.setVisible(type == Type.AJOUTER || type == Type.EDITER);
	}
	
	/**
	 * Activer ou d�sactiver le bouton OK
	 * @param active - boolean, si true le bouton est activ�
	 */
	public void enableOK(boolean active) {
		okButton.setEnabled(active);
	}

	/**
	 * Remplir les champs du dialogue avec une fiche
	 * @param fiche - fiche utilis�e pour remplir les champs
	 */
	private void setTextFields(Fiche fiche) {
		txtNom.setText(fiche.getNom());
		txtPrenom.setText(fiche.getPrenom());
		txtNumero.setText(fiche.getNumero());
		txtAdresse.setText(fiche.getAdresse());
		txtCourriel.setText(fiche.getCourriel());
	}
	
	/**
	 * Cr�er une nouvelle fiche � partir des champs du dialogue
	 * @return nouvelle fiche
	 */
	public Fiche getFiche() {
		return new Fiche(
				txtNom.getText(), 
				txtPrenom.getText(), 
				txtNumero.getText(), 
				txtAdresse.getText(), 
				txtCourriel.getText());
	}

	public boolean isOKPressed() {
		return OKPressed;
	}

	public void setOKPressed(boolean oKPressed) {
		OKPressed = oKPressed;
	}
	
}
