public class Monster extends Fighter {
    private int level;
    private int money;

    private Monster(String name, int power, int dexterity, int intuition, int endurance, int level) {
        super(name, power, dexterity, intuition, endurance);
        this.level = level;
    }

    public static Monster getRandomMonster(int level) throws IllegalArgumentException {
        Monster monster = null;
        int random = (int) (Math.random() * 3);

        switch (random) {
            case (0) -> {
                monster = getNewGoblin(level);
            }
            case (1) -> {
                monster = getNewSkeleton(level);
            }
            case (2) -> {
                monster = getNewOrc(level);
            }
        }

        assert monster != null;
        monster.setMoney((int) (Math.random() * (level * 10)));

        return monster;
    }

    private static Monster getNewOrc(int level) throws IllegalArgumentException {
        switch (level) {
            case (1) -> {
                return new Monster("Skeleton", 5, 3, 3, 4, 1);
            }
            case (2) -> {
                return new Monster("Skeleton", 10, 3, 3, 6, 2);
            }
            case (3) -> {
                return new Monster("Skeleton", 12, 3, 3, 8, 3);
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }

    private static Monster getNewSkeleton(int level) throws IllegalArgumentException {
        switch (level) {
            case (1) -> {
                return new Monster("Skeleton", 3, 5, 3, 4, 1);
            }
            case (2) -> {
                return new Monster("Skeleton", 3, 8, 3, 5, 2);
            }
            case (3) -> {
                return new Monster("Skeleton", 3, 11, 3, 6, 3);
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }

    private static Monster getNewGoblin(int level) throws IllegalArgumentException {
        switch (level) {
            case (1) -> {
                return new Monster("Goblin", 3, 3, 5, 4, 1);
            }
            case (2) -> {
                return new Monster("Goblin", 4, 3, 7, 5, 2);
            }
            case (3) -> {
                return new Monster("Goblin", 5, 3, 9, 6, 3);
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }


    public int getLevel() {
        return level;
    }

    public int getMoney() {
        return money;
    }

    private void setMoney(int money) {
        this.money = money;
    }
}
