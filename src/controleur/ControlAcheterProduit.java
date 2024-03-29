package controleur;

import java.util.Scanner;

import frontiere.Clavier;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public void acheterProduit(String nomAcheteur) {
		Scanner scanner = new Scanner(System.in);
		if (controlVerifierIdentite.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolée " + nomAcheteur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Quel produit vous voulez acheter ? ");
			String nomProduit = scanner.nextLine();
			System.out.println("Chez quel commerçant vous voulez acheter " + nomProduit);
			String nomCommercant = scanner.nextLine();
			int nbProduits = Clavier.entrerEntier("Combien de" + nomProduit + "Vous voulez acheter ");
			try {
				if (!controlTrouverEtalVendeur.trouverEtalVendeur(nomCommercant).getProduit().equals(nomProduit)) {
					System.out.println("Désolé, personne ne vend ce produit au marché.");
				} else {
					int quantiteAchete = controlTrouverEtalVendeur.trouverEtalVendeur(nomAcheteur)
							.acheterProduit(nbProduits);
					if (quantiteAchete < nbProduits) {
						System.out.println("Il ne reste plus en stock");
					} else {
						System.out.println("achat passé par succes");
					}
				}
			} catch (NullPointerException e) {
				System.out.println("Le vendeur n'existe pas");
			}
		}
	}

}
