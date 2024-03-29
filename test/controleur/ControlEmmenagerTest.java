package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private ControlEmmenager controlEmmenager;
	private ControlAfficherVillage controlAfficherVillage;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village des comptes francaise", 10, 10);
		Chef chef = new Chef("Chef", 10, village);
		village.setChef(chef);
		controlEmmenager = new ControlEmmenager(village);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}

	@Test
	void testControlEmmenager() {
		assertNotNull(controlEmmenager);
	}

	@Test
	void testIsHabitant() {
		controlEmmenager.ajouterDruide("Obelix", 12, 1, 4);
		assertTrue(controlEmmenager.isHabitant("Obelix"));
		assertFalse(controlEmmenager.isHabitant("Asterix"));
		assertTrue(controlEmmenager.isHabitant("Chef"));
	}

	@Test
	void testAjouterDruide() {
		controlEmmenager.ajouterDruide("Obelix", 23, 25, 27);
		controlEmmenager.ajouterDruide("Obelix", 12, 11, 10);
		assertTrue(controlEmmenager.isHabitant("Obelix"));
		assertFalse(controlEmmenager.isHabitant("Loay"));
		assertEquals(controlAfficherVillage.donnerNomsVillageois().length, 2);
		assertTrue(controlEmmenager.isHabitant("Chef"));
	}

	@Test
	void testAjouterGaulois() {
		controlEmmenager.ajouterGaulois("Asterix", 13);
		assertTrue(controlEmmenager.isHabitant("Asterix"));
		assertFalse(controlEmmenager.isHabitant("Obelix"));
		assertTrue(controlEmmenager.isHabitant("Chef"));
	}

}
