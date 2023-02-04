import java.util.Scanner;

public class Hero extends Fighter {
    private int money;
    private int experience;
    int potion;

    public int getPotion() {
        return potion;
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

    public Hero(String name) {
        super(name, 3, 3, 3, 3);
    }

    public void usePotion() {
        if (getPotion() > 0) {
            potion--;
            addHealth(6);
        }
    }

    public void addPotion(int potion) {
        this.potion += potion;
    }

    public void addExperience(int experience) {
        if ((getExperience() < 100 && getExperience() + experience >= 100) ||
                (getExperience() < 250 && getExperience() + experience >= 250) ||
                (getExperience() < 500 && getExperience() + experience >= 500)) {
            this.experience += experience;
            levelUpp();
        }

        this.experience += experience;
    }

    public void levelUpp() {
        addLevel();
        int tempPower;
        int tempDexterity;
        int tempIntuition;
        int tempEndurance;

        while (true) {
            int abilityPoint = 5;
            tempDexterity = 0;
            tempIntuition = 0;
            tempEndurance = 0;

            System.out.println("\nУ вас есть 5 очков улучшения.\n" +
                    "Статы вашего героя:\n" +
                    "Сила: " + getPower() +
                    "\nЛовкость:" + getDexterity() +
                    "\nИнтуиция: " + getIntuition() +
                    "\nВыносливость: " + getEndurance() +
                    "\nЗдоровье: " + getEndurance() * 6);

            int keyboardImport = keyboardImportAbility(abilityPoint, "Силу");
            tempPower = keyboardImport;
            abilityPoint -= keyboardImport;

            if (abilityPoint == 0 && finishCreatHero(tempPower, tempDexterity, tempIntuition, tempEndurance)) {
                break;
            } else if (abilityPoint <= 0) {
                System.out.println("Вы превысили количество очков улучшения. Попробуйте снова");
                continue;
            }

            keyboardImport = keyboardImportAbility(abilityPoint, "Ловкость");
            tempDexterity = keyboardImport;
            abilityPoint -= keyboardImport;

            if (abilityPoint == 0 && finishCreatHero(tempPower, tempDexterity, tempIntuition, tempEndurance)) {
                break;
            } else if (abilityPoint <= 0) {
                System.out.println("Вы превысили количество очков улучшения. Попробуйте снова");
                continue;
            }

            keyboardImport = keyboardImportAbility(abilityPoint, "Интуиция");
            tempIntuition = keyboardImport;
            abilityPoint -= keyboardImport;

            if (abilityPoint == 0 && finishCreatHero(tempPower, tempDexterity, tempIntuition, tempEndurance)) {
                break;
            } else if (abilityPoint <= 0) {
                System.out.println("Вы превысили количество очков улучшения. Попробуйте снова");
                continue;
            }

            tempEndurance = abilityPoint;
            if (finishCreatHero(tempPower, tempDexterity, tempIntuition, tempEndurance)) {
                break;
            }
        }

        setPower(getPower() + tempPower);
        setDexterity(getDexterity() + tempDexterity);
        setIntuition(getIntuition() + tempIntuition);
        setEndurance(getEndurance() + tempEndurance);
    }

    private boolean finishCreatHero(int power, int dexterity, int intuition, int endurance) {
        System.out.println("\nВы потратили все очки усиления.\n" +
                "Статы вашего героя:\n" +
                "Сила: " + (getPower() + power) +
                "\nЛовкость:" + (getDexterity() + dexterity) +
                "\nИнтуиция: " + (getIntuition() + intuition) +
                "\nВыносливость: " + (getEndurance() + endurance) +
                "\nЗдоровье: " + ((getEndurance() + endurance) * 6));
        System.out.println("Если все правильно, наберите слово Да\n" +
                "наберите Нет, что бы начать заново");
        String command;
        do {
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();
        } while (!command.equals("Да") && !command.equals("Нет"));

        return command.equals("Да");
    }

    private static int keyboardImportAbility(int abilityPoint, String ability) {
        System.out.println("\nНа сколько ты хотел бы увеличить " + ability + "? Доступно " + abilityPoint + " очка усиления");

        Scanner scanner = new Scanner(System.in);

        int keyboardImport;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Вы ввели неправильне данные. Попробуйте снова");
                scanner.nextLine();
            }
            keyboardImport = scanner.nextInt();
            if (keyboardImport < 0 || keyboardImport > abilityPoint) {
                System.out.println("Вы ввели неправильное значение. Попробуйте снова.");
                System.out.println("На сколько ты хотел бы увеличить " + ability + "? Доступно " + abilityPoint + " очка усиления");
            }
        } while (keyboardImport < 0 || keyboardImport > abilityPoint);

        return keyboardImport;
    }

    public void restoreHealth() {
        setHealth(getEndurance() * 6);
    }

    public void printStats() {
        System.out.println("\nВы потратили все очки усиления.\n" +
                "Статы вашего героя:\n" +
                "Сила: " + (getPower()) +
                "\nЛовкость:" + (getDexterity()) +
                "\nИнтуиция: " + (getIntuition()) +
                "\nВыносливость: " + (getEndurance()) +
                "\nЗдоровье: " + (getHealth()) +
                "\nЗолото: " + getMoney());
    }
}
