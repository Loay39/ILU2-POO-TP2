package controleur;

import org.junit.jupiter.api.BeforeEach;

import villagegaulois.Village;

class ControlAfficherVillageTest {
	ControlEmmenager controlEmmenanger;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Let me do it 4 u", 3, 6);
		controlEmmenanger.ajouterGaulois("Luigi", 13);
		controlEmmenanger.ajouterGaulois("Mamma mia marcello ", 1234569);

	}

	/*
	 * @Test void testDonnerNomsVillageois() {
	 * 
	 * }
	 * 
	 * @Test void testDonnerNomVillage() { fail("Not yet implemented"); }
	 * 
	 * @Test void testDonnerNbEtals() { fail("Not yet implemented"); }
	 */

}
