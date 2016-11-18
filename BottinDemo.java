package bottinmvc;

import java.awt.EventQueue;

public class BottinDemo {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void createAndShowGUI() throws Exception {
		new VuePrincipale();
	}
}

