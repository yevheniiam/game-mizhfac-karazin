package mizhfac;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static mizhfac.WarriorClasses.*;
public class BattleTest {


    @Test
    void testWizardInitialHealth() {
        Wizard wizard = new Wizard();

        // Ensure wizard's initial health is set correctly
        assertEquals(50, wizard.getHealth());
    }

    @Test
    void testWizardAttack() {
        Wizard wizard = new Wizard();

        // Ensure wizard's attack is equal to spell damage
        assertEquals(10, wizard.getAttack());
    }


    @Test
    void testWizardCastSpellOnDefender() {
        Wizard wizard = new Wizard();
        DefenderImp target = new DefenderImp();

        int initialHealth = target.getHealth();
        wizard.castSpell(target);

        // Check if the target's health is reduced, considering defender's defense
        assertTrue(initialHealth > target.getHealth());  // Defender's defense might prevent full damage
    }

    @Test
    void testWizardIsAliveAfterCastingSpell() {
        Wizard wizard = new Wizard();
        WarriorImp target = new WarriorImp();

        // Ensure the wizard is alive after casting a spell
        wizard.castSpell(target);
        assertTrue(wizard.isAlive());
    }
    @Test
    void testMoveUnits() {
        Army army = new Army();
        army.addUnits(WarriorClasses.WARLORD, 1);
        army.addUnits(WarriorClasses.DEFENDER, 2);
        army.addUnits(WarriorClasses.HEALER, 1);
        army.addUnits(WarriorClasses.WARRIOR, 3);

        // Ensure that the Warlord is initially in the front
        assertTrue(army.iterator().next() instanceof Warlord);

        // Move units and check if the Healer is placed after the first Healer
        army.move_units();

        boolean firstHealerFound = false;
        for (Warrior warrior : army) {
            if (warrior instanceof HealerImpl) {
                if (!firstHealerFound) {
                    firstHealerFound = true;
                } else {
                    assertTrue(army.iterator().next() instanceof HealerImpl);
                    break;
                }
            }
        }
    }
}

