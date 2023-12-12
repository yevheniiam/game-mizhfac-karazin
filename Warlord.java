package mizhfac;

public class Warlord extends AbstractWarrior implements CanHit, HasDefence {
    static final int INITIAL_HEALTH = 100;
    static final int ATTACK = 4;
    static final int DEFENCE = 2;

    public Warlord() {
        super(INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public int getDefence() {
        return DEFENCE;
    }
}
