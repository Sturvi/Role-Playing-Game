import java.util.Scanner;

public class Game {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в увлекательное путешествие, Герой!");
        System.out.println("Для начала, представься:");
        String name = scanner.nextLine();

        System.out.println("Позволь взгялунуть на тебя, " + name);
        System.out.println("Ну и хлюпик...");

        Hero hero = new Hero(name);
        hero.levelUpp();


        mainMenu(hero);
    }

    private static void mainMenu(Hero hero) {
        while (true) {
            hero.printStats();

            System.out.println("""
                    Вы находитесь в главном меню!
                    Пожалуйста выберите действие
                    1 - Поиск приключений на попу
                    2 - Пойти к алхикику
                    3 - Выйти из игры!""");

            String userChoice = scanner.nextLine();

            boolean exit = false;
            switch (userChoice) {
                case ("1") -> startNewBattle(hero);
                case ("2") -> alchemistsShop(hero);
                case ("3") -> exit = true;
                default -> System.out.println("Вы ввели неправильную команду!");
            }

            if (exit) break;
        }
    }

    private static void alchemistsShop(Hero hero) {
        while (true) {
            System.out.println("""
                    Вы находитесь в лавке алхимика!
                    Пожалуйста, выберите действие:
                    1 - Купить зелье исцеления (100 монет)
                    2 - Вернуться в главное меню""");
            System.out.println("У вас в наличии:");
            System.out.println(hero.getMoney() + " золота.");
            System.out.println(hero.getPotion() + " зелья.");
            String userChoice = scanner.nextLine();

            if (userChoice.equals("1")) {
                buyPotion(hero);
            } else if (userChoice.equals("2"))
                break;
            else {
                System.out.println("Вы ввели неправильную команду!");
            }

        }
    }

    private static void buyPotion(Hero hero) {
        if (hero.getMoney() >= 100) {
            hero.setMoney(-100);
            hero.addPotion(1);
        } else {
            System.out.println("У вас недостаточно денег!");
        }
    }

    private static void startNewBattle(Hero hero) {
        Monster monster = Monster.getRandomMonster(hero.getLevel());
        Boolean heroWin = Battle.startBattle(hero, monster);
        if (heroWin == null) {
            System.out.println("Ничья. Вы не смогли одолеть монстра! :-(");
        } else if (heroWin) {
            int money = monster.getMoney();
            hero.setMoney(money);
            int experience = getRandomExperience(monster.getLevel());
            hero.addExperience(experience);
            System.out.println("Вы одержали победу! Вы получили: " + experience + " опыта и " + money + " золота!");
        } else {
            System.out.println("К сожалению, вы проиграли! :-(");
        }
        hero.restoreHealth();
    }

    private static int getRandomExperience(int level) {
        return switch (level) {
            case (1) -> (int) (Math.random() * 4 + 8);
            case (2) -> (int) (Math.random() * 6 + 18);
            case (3), default -> (int) (Math.random() * 8 + 28);
        };
    }

}
