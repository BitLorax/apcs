package unit1.act_114;

class WeatherConditionals {
    static String getWeatherAdvice(int temperature, String description) {
        boolean windy = false;
        if (description.contains("windy")) windy = true;
        String opinion;
        if (temperature > 30 && !windy) {
            return "It's safe to go outside, " + temperature + " degreees and " + description + ".";
        }
        return "Too windy or cold! Enjoy watching the weather through the window!.";
    }
    static String getHikingAdvice(int temp, int windchill, int humidity, String description) {
        if (description.contains("tornado") || description.contains("storm") ||
        description.contains("snow") || description.contains("sleet") || description.contains("freezing") ||
        description.contains("rain") || description.contains("showers")) {
            return "Don't hike, is bad weather";
        }
        if (humidity >= 85) {
            return "Too wet, don't hike";
        }
        if ((windchill < 40 && description.contains("wind")) || temp < 40) {
            return "Too cold, don't hike";
        }
        return "Great day to hike";
    }
}
