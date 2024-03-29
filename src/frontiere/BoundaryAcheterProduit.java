package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import controleur.ControlVerifierIdentite;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private BoundaryAfficherMarche boundaryAfficherMarche;
	private BoundaryAcheterProduit boundaryAcheterProduit;
	private ControlAcheterProduit controlAcheterProduit;
	private ControlVerifierIdentite controlVerifierIdentite;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;

	}

	public void acheterProduit(String nomAcheteur) {
		boundaryAfficherMarche.afficherMarche(nomAcheteur);
		controlAcheterProduit.acheterProduit(nomAcheteur);
	}

}
