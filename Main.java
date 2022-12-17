import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();

        int userInput = scanner.nextInt();

        while (userInput != 0) {

            if (userInput == 1) {

                System.out.println("Введите количество пройденных шагов:");
                int steps = scanner.nextInt();
                stepTracker.saveStepsPerDay(scanner, steps);
                System.out.println("Количество пройденных шагов: " + steps);

            } else if (userInput == 2) {

                System.out.println("Введите номер месяца, где: \"Цифра 0 - Январь\", \"Цифра 1 - Февраль\" и т.д.");
                int month = scanner.nextInt();
                stepTracker.printStatistic(scanner, month);

            } else if (userInput == 3) {

                System.out.println("Введите требуемое количество шагов");
                int targetStepsCount = scanner.nextInt();
                stepTracker.changePurposeOfDailySteps(targetStepsCount);

            } else {
                System.out.println("Такой команды нет");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}

