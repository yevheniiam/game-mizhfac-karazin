package mizhfac;

public class VampireImp extends AbstractWarrior implements CanHitAndReportMixin {
    static final int ATTACK = 4;
    static final int INITIAL_HEALTH= 40;
    static final int VAMPIRISM= 50;
public VampireImp(){
    super(INITIAL_HEALTH);
}
public int getVampirism(){
    return VAMPIRISM;
}
    @Override
    public int getAttack() {
        return 0;
    }

    @Override
    public void hit(CanAcceptDamage opponent) {

        var damageDealt = hitAndReportDealtDamage(opponent);
        var healing = damageDealt * getVampirism() /100;
        setHealth(getHealth()+ healing);

    }


}
