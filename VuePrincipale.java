package bottinmvc;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

/**
 * Vue principale de l'application Bottin
 * Vue créée avec Eclipse WindowsBuilder
 * @author Vincent Lacasse
 */
@SuppressWarnings("serial")
public class VuePrincipale extends JFrame implements ListSelectionListener, ListDataListener {
	public final static int N_CAR = 20;	// nombre de caracteres pour les TextFields
	public final static int N_ITEM = 5;	// nombre d'items affichés dans la liste
	public final static String CMD_VOIR     = "VOIR";
	public final static String CMD_AJOUTER  = "AJOUTER";
	public final static String CMD_EDITER   = "EDITER";
	public final static String CMD_DETRUIRE = "DETRUIRE";
	public final static String CMD_FERMER   = "FERMER";
	
	private Bottin bottin;
	private Controleur ctrl;

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtNumero;
	private JList<Fiche> liste;
	private JButton btnVoir;
	private JButton btnEditer;
	private JButton btnDetruire;
	private Fiche ficheVide = new Fiche();

	/**
	 * Create the frame.
	 */
	public VuePrincipale() {
		super("Bottin");
		bottin = new Bottin();
		ctrl = new Controleur(this, bottin); 
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInfos = new JPanel();
		contentPane.add(panelInfos, BorderLayout.NORTH);
		panelInfos.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.LEFT);
		panelInfos.add(lblNom);
		
		txtNom = new JTextField();
		panelInfos.add(txtNom);
		txtNom.setColumns(N_CAR);
		txtNom.setEditable(false);
		
		JLabel lblPrenom = new JLabel("Prenom");
		panelInfos.add(lblPrenom);
		
		txtPrenom = new JTextField();
		panelInfos.add(txtPrenom);
		txtPrenom.setColumns(N_CAR);
		txtPrenom.setEditable(false);
		
		JLabel lblNumero = new JLabel("Numero");
		panelInfos.add(lblNumero);
		
		txtNumero = new JTextField();
		panelInfos.add(txtNumero);
		txtNumero.setColumns(N_CAR);
		txtNumero.setEditable(false);

		setTextFields(ficheVide);
		
		liste = new JList<Fiche>();
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liste.setVisibleRowCount(N_ITEM);
        JScrollPane listScrollPane = new JScrollPane(liste);
        contentPane.add(listScrollPane, BorderLayout.CENTER);

        // Mettre bottin (qui "EST-UN" DefaultListModel) comme modèle de la JList
		liste.setModel(bottin);

        // Afficher nom, prénom et numéro dans la liste
		liste.setCellRenderer(new FicheCelRenderer());
		
		// Ajouter cette vue comme listener lors d'une changement de sélection de la liste.
		// Ceci permet de mettre à jour les champs de la vue (nom, prenom et numero) 
		// et ajuster l'état des boutons lorsque la sélection de la liste est modifiée
		liste.addListSelectionListener(this);
		
		// Ajouter cette vue comme listener lors d'un changement à un item de la liste.
		// Ceci permet de mettre à jour les champs de la vue (nom, prenom et numéro) lorsqu'un
		// item de la fiche est modifiée (bouton Éditer).
		bottin.addListDataListener(this);
		
		JPanel panelCommandes = new JPanel();
		contentPane.add(panelCommandes, BorderLayout.SOUTH);
				
		btnVoir = new JButton("Voir");
		btnVoir.setEnabled(false);
		btnVoir.setActionCommand(CMD_VOIR);
		btnVoir.addActionListener(ctrl);
		panelCommandes.add(btnVoir);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setActionCommand(CMD_AJOUTER);
		btnAjouter.addActionListener(ctrl);
		panelCommandes.add(btnAjouter);
		
		btnEditer = new JButton("Editer");
		btnEditer.setEnabled(false);
		btnEditer.setActionCommand(CMD_EDITER);
		btnEditer.addActionListener(ctrl);
		panelCommandes.add(btnEditer);
		
		btnDetruire = new JButton("Detruire");
		btnDetruire.setEnabled(false);
		btnDetruire.setActionCommand(CMD_DETRUIRE);
		btnDetruire.addActionListener(ctrl);
		panelCommandes.add(btnDetruire);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.setActionCommand(CMD_FERMER);
		btnFermer.addActionListener(ctrl);
		panelCommandes.add(btnFermer);		
		
		setBounds(100, 100, 534, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(contentPane);
		setLocationRelativeTo(null);
		setVisible(true);
		
		ctrl.lireBottin();
	}
	
	/**
	 * Activer ou déactiver les boutons Voir, Editer et Detruire
	 * @param active - boolean, si true, les boutons sont activés
	 */
	private void enableButtons(boolean active) { 
		btnVoir.setEnabled(active);
		btnEditer.setEnabled(active);
		btnDetruire.setEnabled(active);
	}
	
	/**
	 * Mettre à jour les chamops Nom, Prénom et Numero de la vue à partir d'une fiche
	 * @param fiche - fiche utilisée pour mettre à jour les champs
	 */
	private void setTextFields(Fiche fiche) {
		txtNom.setText(fiche.getNom());
		txtPrenom.setText(fiche.getPrenom());
		txtNumero.setText(fiche.getNumero());
	}
	
	public int getIndex() {
		return liste.getSelectedIndex();
	}
	
	/**
	 * Mettre à jour index et afficher les champs nom, prénom et numéro en conséquence
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
	    if (e.getValueIsAdjusting() == false) {
	    	int index = getIndex();
	    	if (index > -1) {
	    		enableButtons(true);
				setTextFields(bottin.get(index));
	    	}
	    	else {
	    		enableButtons(false);
	    		setTextFields(ficheVide);
	    	}		
	    }
	}

	@Override
	public void intervalAdded(ListDataEvent e) { }

	@Override
	public void intervalRemoved(ListDataEvent e) { }

	@Override
	public void contentsChanged(ListDataEvent e) {
		setTextFields(bottin.get(getIndex()));
	}
}
