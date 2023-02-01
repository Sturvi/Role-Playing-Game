import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Hero hero = creatNewHero();
        Monster monster = Monster.getRandomMonster(1);

        Boolean test = Battle.startBattle(hero, monster);
        if (test == null)
            System.out.println("Ничья");
        else if (test) {
            System.out.println("Победа");
        } else {
            System.out.println("Жора");
        }


    }

    private static Hero creatNewHero() {
        System.out.println("Добро пожаловать в увлекательное путешествие, Герой!");
        System.out.println("Для начала, представься:");
        String name = scanner.nextLine();

        System.out.println("Позволь взгялунуть на тебя, " + name);
        System.out.println("Ну и хлюпик...");

        int power = 3;
        int dexterity = 3;
        int intuition = 3;
        int endurance = 3;
        while (true) {
            System.out.println("""
                    Твои параметры на данный момент:
                    Сила: 3
                    Ловкость: 3
                    Интуиция: 3
                    Выносливость: 3  (Одна единица выносливости дает 6 единиц жизни)
                    Ты можешь увелить любой из этих параметров. Всего у тебя 4 очка усиления. Используй их с умом""");

            int abilityPoint = 4;

            int keyboardImport = keyboardImportAbility(abilityPoint, "Силу");
            power += keyboardImport;
            abilityPoint -= keyboardImport;

            if (abilityPoint == 0 && finishCreatHero(power, dexterity, intuition, endurance)) {
                break;
            } else if (abilityPoint == 0) {
                continue;
            }

            keyboardImport = keyboardImportAbility(abilityPoint, "Ловкость");
            dexterity += keyboardImport;
            abilityPoint -= keyboardImport;

            if (abilityPoint == 0 && finishCreatHero(power, dexterity, intuition, endurance)) {
                break;
            } else if (abilityPoint == 0) {
                continue;
            }

            keyboardImport = keyboardImportAbility(abilityPoint, "Интуиция");
            intuition += keyboardImport;
            abilityPoint -= keyboardImport;

            if (abilityPoint == 0 && finishCreatHero(power, dexterity, intuition, endurance)) {
                break;
            } else if (abilityPoint == 0) {
                continue;
            }

            endurance += abilityPoint;
            if (finishCreatHero(power, dexterity, intuition, endurance)) {
                break;
            }
        }

        return new Hero(name, power, dexterity, intuition, endurance);
    }

    private static int keyboardImportAbility(int abilityPoint, String ability) {
        System.out.println("\nНа сколько ты хотел бы увеличить " + ability + "? Доступно " + abilityPoint + " очка усиления");


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

    private static boolean finishCreatHero(int power, int dexterity, int intuition, int endurance) {
        System.out.println("\nВы потратили все очки усиления.\n" +
                "Статы вашего героя:\n" +
                "Сила: " + power +
                "\nЛовкость:" + dexterity +
                "\nИнтуиция: " + intuition +
                "\nВыносливость: " + endurance +
                "\nЗдоровье: " + endurance * 6);
        System.out.println("Если все правильно, наберите слово Да\n" +
                "наберите Нет, что бы начать заново");
        String command;
        do {
            command = scanner.nextLine();
        } while (!command.equals("Да") && !command.equals("Нет"));

        return command.equals("Да");
    }
}
