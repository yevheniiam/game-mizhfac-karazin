package mizhfac;

public class KnightImp extends AbstractWarrior{
    public static final int ATTACK =7;
    static final int INITIAL_HEALTH = 50;
    public KnightImp(){
       super(INITIAL_HEALTH);
    }


    @Override
    public int getAttack() {
        return ATTACK;
    }
}

