public class Monster extends Fighter {
    private int money;

    public int getMoney() {
        return money;
    }

    private void setMoney(int money) {
        this.money = money;
    }

    private Monster(String name, int power, int dexterity, int intuition, int endurance, int level) {
        super(name, power, dexterity, intuition, endurance, level);
    }

    public static Monster getRandomMonster(int level) throws IllegalArgumentException {
        Monster monster = null;
        int random = (int) (Math.random() * 3);

        switch (random) {
            case (0) -> monster = getNewGoblin(level);
            case (1) -> monster = getNewSkeleton(level);
            case (2) -> monster = getNewOrc(level);
        }

        assert monster != null;

        monster.setMoney((int) (Math.random() * (level * 10 + 20)));

        return monster;
    }

    private static Monster getNewOrc(int level) throws IllegalArgumentException {
        switch (level) {
            case (1) -> {
                return new Monster("Orc", 5, 3, 3, 5, 1);
            }
            case (2) -> {
                return new Monster("Orc", 8, 3, 3, 6, 2);
            }
            case (3) -> {
                return new Monster("Orc", 11, 3, 3, 7, 3);
            }
            default -> throw new IllegalArgumentException();
        }
    }

    private static Monster getNewSkeleton(int level) throws IllegalArgumentException {
        switch (level) {
            case (1) -> {
                return new Monster("Skeleton", 3, 6, 3, 4, 1);
            }
            case (2) -> {
                return new Monster("Skeleton", 3, 9, 3, 5, 2);
            }
            case (3) -> {
                return new Monster("Skeleton", 3, 12, 3, 6, 3);
            }
            default -> throw new IllegalArgumentException();
        }
    }

    private static Monster getNewGoblin(int level) throws IllegalArgumentException {
        switch (level) {
            case (1) -> {
                return new Monster("Goblin", 3, 3, 6, 4, 1);
            }
            case (2) -> {
                return new Monster("Goblin", 4, 3, 8, 5, 2);
            }
            case (3) -> {
                return new Monster("Goblin", 5, 3, 10, 6, 3);
            }
            default -> throw new IllegalArgumentException();
        }
    }
}
