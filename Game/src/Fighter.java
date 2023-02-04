public abstract class Fighter {

    private final String name;
    private int power;
    private int dexterity;
    private int intuition;
    private int endurance;
    private int health;
    private int level;

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntuition() {
        return intuition;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setIntuition(int intuition) {
        this.intuition = intuition;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public Fighter(String name, int power, int dexterity, int intuition, int endurance) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intuition = intuition;
        this.endurance = endurance;
        this.health = endurance * 6;
        this.level = 0;
    }

    public Fighter(String name, int power, int dexterity, int intuition, int endurance, int level) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intuition = intuition;
        this.endurance = endurance;
        this.health = endurance * 6;
        this.level = level;
    }

    /*each dexterity point increases the chance to dodge by 10 percent. each opponent's dexterity point reduces this
    chance by 10 percent. The maximum chance to dodge is 10 percent. The same is true for a critical strike*/
    public boolean dodgeTry(int opponentsDexterity) {
        int probability = getDexterity() - opponentsDexterity;

        if (probability <= 0) return false;
        if (probability > 7) probability = 7;

        return (int) (Math.random() * 10) < probability;
    }

    public boolean criticalTry(int opponentsIntuition) {
        int probability = getIntuition() - opponentsIntuition;

        if (probability <= 0) return false;
        if (probability > 7) probability = 7;

        return (int) (Math.random() * 10) < probability;
    }

    /*this method returns true if the character died after taking damage*/
    public boolean takingDamage(int damage) {
        this.health -= damage;
        return health <= 0;
    }

    public void addHealth(int health) {
        this.health = Math.min(this.health + 6, getEndurance() * 6);
    }

    public void addLevel() {
        this.level++;
    }
}
