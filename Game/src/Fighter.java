public abstract class Fighter {
    String name;
    int power;
    int dexterity;
    int intuition;
    int endurance;
    int health;

    public Fighter(String name, int power, int dexterity, int intuition, int endurance) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intuition = intuition;
        this.endurance = endurance;
        this.health = endurance * 6;
    }

    public int attack () {
        return power;
    }

    /*each dexterity point increases the chance to dodge by 10 percent. each opponent's dexterity point reduces this
    chance by 10 percent. The maximum chance to dodge is 10 percent. The same is true for a critical strike*/
    public boolean dodgeTry (int opponentsDexterity){
        int probability = dexterity - opponentsDexterity;

        if (probability <= 0)
            return false;
        if (probability > 7)
            probability = 7;

        return (int)(Math.random() * 10) < probability;
    }

    public boolean criticalTry (int opponentsIntuition){
        int probability = opponentsIntuition - intuition;

        if (probability <= 0)
            return false;
        if (probability > 7)
            probability = 7;

        return (int)(Math.random() * 10) < probability;
    }


    public String getName() {
        return name;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntuition() {
        return intuition;
    }

    public int getHealth() {
        return health;
    }

    /*this method returns true if the character is still alive after taking damage*/
    public boolean takingDamage(int damage) {
        this.health -= damage;
        return health > 0;
    }
}
