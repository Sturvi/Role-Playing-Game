public class Battle {

    public static Boolean startBattle(Fighter fitstFighter, Fighter secondFighter) {
        boolean firstFighterDead = false;
        boolean secondFighterDead = false;

        do {
            secondFighterDead = !attack(fitstFighter, secondFighter);
            firstFighterDead = !attack(secondFighter, fitstFighter);
        } while (!firstFighterDead && !secondFighterDead);


        if (firstFighterDead && secondFighterDead) {
            return null;
        } else {
            return !firstFighterDead;
        }
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
