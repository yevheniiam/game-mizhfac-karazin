package mizhfac;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Wizard extends AbstractWarrior implements CanCastSpell, CanTeleport, SpecialAbility{

    private static final int SPELL_DAMAGE = 10;
    private static final int INITIAL_HEALTH = 50;

    public Wizard() {
        super(INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return SPELL_DAMAGE;
    }

    @Override
    public void castSpell(Warrior target) {
        log.info("Wizard casts a spell on {}", target);
        target.acceptDamage(getAttack());
    }

    @Override
    public void teleport() {
        log.info("Wizard teleports to a different location");
    }
    @Override
    public void performSpecialAbility(Warrior warrior) {
        if (warrior instanceof CanTeleport) {
            ((CanTeleport) warrior).teleport();
        }
    }
}