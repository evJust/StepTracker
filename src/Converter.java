public class Converter {
    void convert(int allSteps){
        int kilometers = (int) (allSteps * 0.00075);
        System.out.println("• Пройдено: "+kilometers+" км.");
        int calories = (int) (allSteps * 0.05);
        System.out.println("• Сожжено: "+calories+" Ккал.");
    }
}
