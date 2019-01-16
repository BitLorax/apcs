package unit1.act_114;

import java.io.IOException;

public class StringTester {
    public static void main(String[] args) throws IOException {
        String weatherCondition = "scattered thunderstorms";
        System.out.println(weatherCondition.length());
        int i = 0;
        while (weatherCondition.charAt(i) != ' ') { i++; }
        System.out.println(weatherCondition.substring(0, i));

        System.out.println(WeatherConditionals.getWeatherAdvice(32, "heavy snow"));
    }
}
