package mizhfac;

public class LancerImp extends AbstractWarrior implements CanHitAndReportMixin {
    static final int ATTACK = 6;
    static final int INITIAL_HEALTH = 50;
    static final int PENETRATION = 50; // percents

    public LancerImp() {
        super(INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public void hit(CanAcceptDamage opponent) {
        var damageDealt = hitAndReportDealtDamage(opponent);
        if (opponent instanceof WarriorInArmy warriorInArmy) {
            var nextBenind = warriorInArmy.getWarriorBehind();
            if (nextBenind.isPresent()) {
                int secondDamage = damageDealt * PENETRATION / 100;
                CanHit proxy = () -> secondDamage;
                proxy.hit(nextBenind.get());
                nextBenind.get().acceptDamage(secondDamage);
            }
        }
    }
}
