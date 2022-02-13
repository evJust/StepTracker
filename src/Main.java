import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добрый день!");
        System.out.println("Я - «Счётчик калорий» v1.0");
        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        boolean isMonth = true;
        while (userInput != 0) {
            switch (userInput){
                case 1:
                    System.out.println("Укажите название месяца:");
                    String month = scanner.next();
                    isMonth = stepTracker.newMonth(month, isMonth);
                    if (isMonth) {
                        System.out.println("Укажите число(1-30):");
                        int day = scanner.nextInt();
                        System.out.println("Укажите количество пройденых шагов:");
                        int steps = scanner.nextInt();
                        stepTracker.enteringSteps(day, steps);
                    }else{
                        System.out.println("Месяц указан не верно!");
                    }
                    break;
                case 2:
                    System.out.println("Укажите месяц:");
                    month = scanner.next();
                    isMonth = stepTracker.newMonth(month, isMonth);
                    if (isMonth) {
                        stepTracker.statistics();
                    }else{
                        System.out.println("Месяц указан не верно!");
                    }
                    break;
                case 3:
                    System.out.println("Укажите новое целевое количество шагов в день:");
                    int newTarget = scanner.nextInt();
                    stepTracker.newStepGoal(newTarget);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Такая функция отсутствует!");
            }

            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена.");
        System.out.println("Всего доброго!");
    }

    private static void printMenu () {
            System.out.println(" ");
            System.out.println("Какой функцией вы желаете воспользоваться?");
            System.out.println(" ");
            System.out.println("1 - Ввести количество шагов за определённый день.");
            System.out.println("2 - Напечатать статистику за определённый месяц.");
            System.out.println("3 - Изменить цель по количеству шагов в день.");
            System.out.println("0 - Завершить процесс.");
        }

}