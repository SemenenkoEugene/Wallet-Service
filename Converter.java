public class Converter {

    private static final double SIZE_STEP = 0.75;
    private static final double CALORIE_SIZE = 50.0;
    private static final int CONSTANT = 1000;

    public static void convert(int step) {
        System.out.println("Пройденная дистанция: " + (step * SIZE_STEP)/ CONSTANT + " км.");
        System.out.println("Количество сожженных калорий: " + (step * CALORIE_SIZE) + " калорий");
    }
}
