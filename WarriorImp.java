package mizhfac;

public class WarriorImp extends AbstractWarrior {
    static final int INITIAL_HEALTH = 50;
 static final int ATTACK = 5;

    public WarriorImp() {
        super(INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }
}
