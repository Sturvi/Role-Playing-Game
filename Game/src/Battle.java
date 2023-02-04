import java.util.Scanner;

public class Battle {

    /*This method conducts a battle between a hero and monsters. Returns null if both characters are dead
    and a draw is fixed. Returns true if the first fighter won.*/
    public static Boolean startBattle(Fighter fitstFighter, Fighter secondFighter) {
        boolean firstFighterDead;
        boolean secondFighterDead;

        do {
            System.out.println("\nУ " + fitstFighter.getName() + " Осталось здоровья: " + fitstFighter.getHealth());
            System.out.println("У " + secondFighter.getName() + " Осталось здоровья: " + secondFighter.getHealth());
            if (fitstFighter instanceof Hero) {
                useNextAction((Hero) fitstFighter);
            }
            secondFighterDead = attack(fitstFighter, secondFighter);
            firstFighterDead = attack(secondFighter, fitstFighter);
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

        String userChoice;
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

    /*Если после атаки обороняющий умер, возвращает true*/
    private static boolean attack(Fighter attacker, Fighter defender) {
        System.out.println("\n" + attacker.getName() + " Атакует");
        boolean critical = attacker.criticalTry(defender.getIntuition());
        boolean dodge = defender.dodgeTry(attacker.getDexterity());
        if (critical) {
            System.out.println(attacker.getName() + " С разбегу наносит критические удар!");
        }
        if (dodge) {
            System.out.println("Но " + defender.getName() + " уворачивается!");
        }

        if (dodge) {
            return defender.takingDamage(0);
        } else if (critical) {
            System.out.println("-" + (int) (attacker.getPower() * 2.5));
            System.out.println("У " +
                    defender.getName() +
                    " осталось " +
                    (defender.getHealth() - (int) (attacker.getPower() * 2.5)) +
                    " здоровья");
            return defender.takingDamage((int) (attacker.getPower() * 2.5));
        } else {
            System.out.println("-" + attacker.getPower());
            System.out.println("У " +
                    defender.getName() +
                    " осталось " +
                    (defender.getHealth() - attacker.getPower()) +
                    " здоровья");
            return defender.takingDamage(attacker.getPower());
        }
    }
}
