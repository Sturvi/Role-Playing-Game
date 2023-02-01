import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в увлекательное путешествие, Герой!");
        System.out.println("Для начала, представься:");
        String name = scanner.nextLine();

        System.out.println("Позволь взгялунуть на тебя, " + name);
        System.out.println("Ну и хлюпик...");

        while (true) {
            System.out.println("""
                    Твои параметры на данный момент:
                    Сила: 3
                    Ловкость: 3
                    Интуиция: 3
                    Выносливость 3  (Одна единица выносливости дает 6 единиц жизни)
                    Ты можешь увелить любой из этих параметров. Всего у тебя 4 очка усиления. Используй их с умом""");

            int abilityPoint = 4;
            System.out.println("На сколько ты хотел бы увеличить силу? Доступно " + abilityPoint + " очка усиления");
            int power;
            while (!scanner.hasNextInt()) {
                System.out.println("Вы ввели неправильне данные. Попробуйте снова");
                scanner.nextLine();
            }
            power = scanner.nextInt();

        }

    }
}
