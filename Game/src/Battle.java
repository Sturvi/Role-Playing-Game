import java.util.Scanner;

public class Battle {

    public static Boolean startBattle(Fighter fitstFighter, Fighter secondFighter) {
        boolean firstFighterDead = false;
        boolean secondFighterDead = false;

        do {
            secondFighterDead = !attack(fitstFighter, secondFighter);
            firstFighterDead = !attack(secondFighter, fitstFighter);
            if (fitstFighter instanceof Hero) {
                useNextAction((Hero) fitstFighter);
            }
        } while (!firstFighterDead && !secondFighterDead);


        if (firstFighterDead && secondFighterDead) {
            return null;
        } else {
            return !firstFighterDead;
        }
    }

    private static void useNextAction(Hero hero) {
        System.out.println("Нажмите 1 для нанесения следуюзей атаки");
        System.out.println("Нажмите 2, чтобы выпить пиво. У вас в наличии " + hero.getPotion() + " бутылок");

        String userChoice = "";
        Scanner scanner = new Scanner(System.in);
        do {
            userChoice = scanner.nextLine();
            if (userChoice.equals("2")) {
                if (hero.getPotion() == 0) {
                    System.out.println("К сожалению у вас нет пива в наличии... придется продолжить бой трезвым. " +
                            "Прими судьбу и продолжи бой");
                } else {
                    hero.usePotion();
                    System.out.println("Теперь ваше здоровье равно " + hero.getHealth() + " единицам.");
                }
            } else if (!userChoice.equals("1")) {
                System.out.println("Вы сделали неправильный выбор. Попробуйте снова");
            }
        } while (!userChoice.equals("1"));
    }

    private static boolean attack(Fighter attacker, Fighter defender) {
        System.out.println("\n" + attacker.getName() + " Атакует");
        boolean critical = attacker.criticalTry(defender.intuition);
        boolean dodge = defender.dodgeTry(attacker.dexterity);
        if (critical) {
            System.out.println(attacker.getName() + "С разбегу наносит критические удар!");
        }
        if (dodge) {
            System.out.println("Но " + defender.getName() + " уворачивается!");
        }

        if (dodge) {
            return defender.takingDamage(0);
        } else if (critical) {
            System.out.println("-" + (int) (attacker.attack() * 2.5));
            System.out.println(defender.getHealth());
            System.out.println("У " +
                    defender.getName() +
                    " осталось " +
                    (defender.getHealth() - (int) (attacker.attack() * 2.5)) +
                    " здоровья");
            return defender.takingDamage((int) (attacker.attack() * 2.5));
        } else {
            System.out.println("-" + attacker.attack());
            System.out.println(defender.getHealth());

            System.out.println("У " +
                    defender.getName() +
                    " осталось " +
                    (defender.getHealth() - attacker.attack()) +
                    " здоровья");
            return defender.takingDamage(attacker.attack());
        }
    }
}
