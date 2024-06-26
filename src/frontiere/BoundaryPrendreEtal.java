package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			System.out.println("Je suis désolée " + nomVendeur
					+ " mais il faut être un habitant de notre village pour commercer ici. ");
		} else {
			System.out.println("Bonjour " + nomVendeur + "Je vais regarder si je peux vous trouver un étal ");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				System.out.println("Désolée " + nomVendeur + " Je n'ai plus d'étal qui ne soit pas déjà occupé. ");
			} else {
				installerVendeur(nomVendeur);

			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait il reste un étal pour vous! ");
		System.out.println("Il me faudrait quelques renseignements: ");
		System.out.println("Quel produit souhaitez-vous vendre ? ");
		String produit = scan.next();
		int nbProduits = Clavier.entrerEntier("Combien souhaitez-vous en prendre ? ");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduits);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + "s'est installé à l'étal n°" + numeroEtal + 1);
		}
	}
}
