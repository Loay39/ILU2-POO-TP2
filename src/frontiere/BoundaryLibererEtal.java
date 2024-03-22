package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {

		String[] donneesEtal;
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché ");
		} else {
			donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = Boolean.parseBoolean(donneesEtal[0]);
			if (etalOccupe) {
				System.out
						.println("Vous avez vendu " + donneesEtal[4] + "sur " + donneesEtal[3] + " " + donneesEtal[2]);
				System.out.println("Au revoir " + nomVendeur + "passez une bonne journée ");
			}
		}
	}

}
