package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isVendeur(String nomVendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		boolean etalPasNul = true;
		try {
			etalPasNul = !etal.equals(null);
		} catch (NullPointerException e) {
			etalPasNul = false;
		} finally {
			return etalPasNul;
		}
	}

	/**
	 * 
	 * @param produit
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'étal est occupé [1] : nom du vendeur [2] : produit
	 *         vendu [3] : quantité de produit à vendre au début du marché [4] :
	 *         quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		String[] infosEtal = new String[4];
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		infosEtal = etal.etatEtal();
		etal.libererEtal();
		return infosEtal;
	}

}
