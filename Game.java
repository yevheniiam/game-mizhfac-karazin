package mizhfac;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    public static boolean fight(Warrior first, Warrior second) {
        while (first.isAlive()) {
            applySpecialAbilities(first, second);

            if (!second.isAlive()) {
                return false;
            }

            applySpecialAbilities(second, first);
        }
        return false;
    }


    public static boolean fight (Army first , Army second){
        log.info("Army {} fights against army{} ",first , second);
        var it1 = first.firstAliveIterator();
        var it2 = second.firstAliveIterator();
        while (it1.hasNext()&& it2.hasNext()){

            fight((Army) it1.next(), (Army) it2.next());
        }
        return it1.hasNext();
    }
    public static boolean straightFight(Army first, Army second) {
        log.info("Army {} fights against army{} ", first, second);

        while (!first.isEmpty() && !second.isEmpty()) {
            var it1 = first.iterator();
            var it2 = second.iterator();
            while (it1.hasNext() && it2.hasNext()) {
                fight((Army) it1.next(), (Army) it2.next());
            }
        }
        return !first.isEmpty();
    }
    public static void applySpecialAbilities(Warrior attacker, Warrior defender) {
        if (attacker instanceof SpecialAbility) {
            ((SpecialAbility) attacker).performSpecialAbility(defender);
        }
    }


}
