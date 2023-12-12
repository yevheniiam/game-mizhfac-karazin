package mizhfac;

    public enum WarriorClasses {
        WARRIOR, KNIGHT, DEFENDER, VAMPIRE, LANCER, HEALER, WIZARD,WARLORD;

        public static Warrior factory(WarriorClasses warriorClasses) {
            return switch (warriorClasses) {
                case WARRIOR -> new WarriorImp();
                case KNIGHT -> new KnightImp();
                case DEFENDER -> new DefenderImp();
                case VAMPIRE -> new VampireImp();
                case LANCER -> new LancerImp();
                case HEALER -> new HealerImpl();
                case WIZARD -> new Wizard();
                case WARLORD -> new Warlord();
            };
        }

        public Warrior make() {
            return factory((this));
        }

        public static void main(String[] args) {
            WarriorClasses w = WARRIOR;
            Warrior warrior1 = w.make();
            Warrior warrior2 = WarriorClasses.factory(w);

        }
    }
