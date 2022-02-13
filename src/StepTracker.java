import java.util.HashMap;
import java.util.ArrayList;
public class StepTracker {
    int targetSteps = 10000;
    Converter converter = new Converter();
    HashMap<Integer, MonthData> monthToData = new HashMap<>();
    int keyMonth;

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    static class MonthData {
        int[] days = new int[30];
    }

    void enteringSteps(int day, int steps) {
        if (steps >= 0) {
            MonthData monthData = monthToData.get(keyMonth);
            monthData.days[day - 1] = steps;
        } else {
            System.out.println("Число шагов не может быть отрицательным.");

        }
    }

    void statistics() {
        int allSteps = 0;
        int bestSeries = 0;
        int series = 0;
        int maxSteps = 0;
        ArrayList<Integer> ALSeries = new ArrayList<>();

        MonthData monthData = monthToData.get(keyMonth);
        for (int i = 0; i < monthData.days.length; i++) {
            int steps = monthData.days[i];
            System.out.print((i + 1) + " день: " + steps + " | ");
            allSteps += steps;
            if (maxSteps<steps){
                maxSteps=steps;
            }
            if (steps>=targetSteps){
                bestSeries++;
            }else{
                ALSeries.add(bestSeries);
                bestSeries = 0;
            }
        }
        for(int maxSeries : ALSeries){
            if (maxSeries>series){
                series = maxSeries;
            }
        }
        System.out.println("");
        System.out.println("• Максимальное пройденное количество шагов в месяце: "+maxSteps);
        System.out.println("• Общее количество шагов за месяц: " + allSteps);
        System.out.println("• Среднее количество шагов за месяц: " + (allSteps / 30));
        converter.convert(allSteps);
        System.out.println("• Лучшая серия: "+series+" подряд.");
    }

    void newStepGoal(int newTarget) {
        if (newTarget >= 0) {
            targetSteps = newTarget;
        } else {
            System.out.println("Целевое значение не может быть отрицательным");
        }
    }

    boolean newMonth(String month,boolean isMonth) {
        HashMap<String, Integer> monthInNumbers = new HashMap<>();
        monthInNumbers.put("Январь",0);
        monthInNumbers.put("Февраль",1);
        monthInNumbers.put("Март",2);
        monthInNumbers.put("Апрель",3);
        monthInNumbers.put("Май",4);
        monthInNumbers.put("Июнь",5);
        monthInNumbers.put("Июль",6);
        monthInNumbers.put("Август",7);
        monthInNumbers.put("Сентябрь",8);
        monthInNumbers.put("Октябрь",9);
        monthInNumbers.put("Ноябрь",10);
        monthInNumbers.put("Декабрь",11);
        if (isMonth = monthInNumbers.containsKey(month)){
            keyMonth = monthInNumbers.get(month);
        }
        return isMonth;
    }
}