package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		String vendeur = "", quantite = "", produit = "";
		if (infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard ");
		}
		for (int i = 0; i < infosMarche.length; i++) {
			if (i == 0) {
				vendeur = infosMarche[i];
			} else if (i == 1) {
				quantite = infosMarche[i];
			} else {
				produit = infosMarche[i];
			}
		}
		System.out.println("-" + vendeur + "qui vend " + quantite + "produit ");
	}

}
