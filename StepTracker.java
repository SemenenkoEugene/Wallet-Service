import java.util.Scanner;

public class StepTracker {

    int steps = 0;
    int targetStepsPerDay = 10_000;
    int[][] monthToData = new int[12][30];


    // Сохранение пройденных шагов за определенный день месяца
    public void saveStepsPerDay(Scanner scanner, int stepsPerDay) {

        System.out.println("Введите номер месяца, где: \"Цифра 0 - Январь\", \"Цифра 1 - Февраль\" и т.д.");
        int numberMonth = scanner.nextInt();

        System.out.println("Введите номер дня от 1 до 30:");
        int numberDay = scanner.nextInt();

        if (stepsPerDay < 0) {
            System.out.println("Введите положительное число");
            return;
        }
        if (numberDay < 1 || numberDay > 30) {
            System.out.println("Номер дня введен не верно");
            return;
        }
        if (numberMonth < 0 || numberMonth > 12) {
            System.out.println("Номер месяца введен не верно.");
            return;
        }
        monthToData[numberMonth][numberDay] = stepsPerDay;
    }

    // Изменение целевого количества шагов
    public void changePurposeOfDailySteps(int targetStepsPerDay) {
        if (targetStepsPerDay < 0) {
            System.out.println("Введённое значение не должно быть отрицательным");
        } else {
            this.targetStepsPerDay = targetStepsPerDay;
            System.out.println("Данные сохранены");
        }
    }

    // Печать статистики за определенный месяц
    public void printStatistic(Scanner scanner, int month) {
        int totalSteps = 0;
        int maxSteps = 0;
        int dayOfMaxSteps = 0;
        int bestSeries = 0;
        int tmpCurrentSeries = 0;

        for (int j = 0; j < monthToData[month].length; j++) {
            System.out.println((j + 1) + " день: " + monthToData[month][j+1]);
            totalSteps += steps;

            if (steps > maxSteps) {
                maxSteps = steps;
                dayOfMaxSteps = j + 1;
            }

            if (steps > targetStepsPerDay) {
                tmpCurrentSeries++;
            } else {
                bestSeries = Math.max(bestSeries, tmpCurrentSeries);
                tmpCurrentSeries = 0;
            }

            int avgSteps = totalSteps / 30; // 30 - количество дней в месяце

            System.out.println("Общее количество шагов за месяц: " + totalSteps);
            System.out.println("Максимальное количество шагов - " + maxSteps +
                    " было пройдено в день номер " + dayOfMaxSteps);
            System.out.println("Среднее количество шагов в день: " + avgSteps);
            Converter.convert(totalSteps);
            System.out.println("Лучшая серия: " + bestSeries + " дней");
        }

    }
}