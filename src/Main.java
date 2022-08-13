import java.util.HashMap;
import java.util.Map;

public class Main {

    static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
            " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
            " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." +
            " Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
            " Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static char maxValue(Map<Character, Integer> map) {
        int max = 0;
        char result = ' ';
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                result = key;
            }
        }
        return result;
    }

    public static char minValue(Map<Character, Integer> map) {
        int min = Integer.MAX_VALUE;
        char result = ' ';
        for (char key : map.keySet()) {
            if (map.get(key) < min) {
                min = map.get(key);
                result = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String newText = text.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < newText.length(); i++) {
            char key = newText.charAt(i);
            if (!map.containsKey(key)) {
                if (key != ' ' && key != '.' && key != ',') {
                    map.put(key, 1);
                }
            } else {
                int value = map.get(key);
                value++;
                map.put(key, value);
            }
        }
        System.out.println("Встречается чаще всего буква - " + maxValue(map));
        System.out.println("Встречается реже всего буква - " + minValue(map));
    }
}
