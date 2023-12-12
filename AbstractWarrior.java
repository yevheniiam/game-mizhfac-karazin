package mizhfac;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractWarrior implements Warrior{
    private static int idCounter =0;
    private int health;
    private int initialHealth;
    private int  id = ++idCounter;

    public AbstractWarrior(int health) {
        this.health = health;
        this.initialHealth = health;
    }

 public void acceptDamage(int damage){
        setHealth(getHealth()- getAttack());
    }
     public int getHealth() {
        return health;
    }

    public abstract  int getAttack();
    protected void setHealth(int health) {
        this.health = Math.min(initialHealth,health);
    }


    @Override
    public String toString() {
        String name = getClass().getSimpleName();
        name = name.replaceAll("Imp", "");
        name = name.toUpperCase();
        return name +"#" + id +"{" +
                "h=" + health +
                ",a="+ getAttack()+
                '}';
    }
}
