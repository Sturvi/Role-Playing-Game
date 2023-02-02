public class Hero extends Fighter {
    private int money;
    private int experience;
    private int level;

    public int getPotion() {
        return potion;
    }

    public void usePotion (){
        if (potion > 0){
            potion--;
            health = Math.min(health + 6, experience * 6);
        }
    }

    public void addPotion(int potion) {
        if (potion > 0) {
            this.potion += potion;
        }
    }

    int potion;

    public Hero(String name, int power, int dexterity, int intuition, int endurance) {
        super(name, power, dexterity, intuition, endurance);
        this.level = 1;
        this.money = 0;
        this.experience = 0;
        this.potion = 0;
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money += money;
        this.money = Math.max(this.money, 0);
    }

    public int getExperience() {
        return experience;
    }

    public void addExperience(int experience) {
        this.experience += experience;
        if (this.experience < 100) {
            this.level = 0;
        } else if (this.experience < 200) {
            this.level = 1;
        } else {
            this.level = 2;
        }
    }

    public int getLevel() {
        return level;
    }

}
