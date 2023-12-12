package mizhfac;

public class DefenderImp extends AbstractWarrior implements HasDefence {
    static final int INITIAL_HEALTH = 60;
    static final int ATTACK = 3;
    static final int DEFENCE = 2;

    public DefenderImp() {
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

    @Override
    public void acceptDamage(int damage) {
        int reduceDamage = Math.max(0, damage - getDefence());
        super.acceptDamage(reduceDamage);
    }
}
