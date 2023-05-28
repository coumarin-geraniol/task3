import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameOptions {
    private final String[] options;

    public GameOptions(String[] options) {
        this.options = options;
    }

    public String getOption(int index) {
        return options[index];
    }

    public int getSize() {
        return options.length;
    }

    public boolean areUnique() {
        Set<String> set = new HashSet<>(Arrays.asList(options));
        return set.size() == options.length;
    }
    public String[] getMoves() {
        return options.clone();
    }
    public void printOptions() {
        System.out.println("Available moves:");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i+1) + " - " + options[i]);
        }
        System.out.println("0 - exit");
        System.out.println("? - help");
    }

    public boolean checkIfFirstBeatsSecond(int first, int second) {
        if (first == second) {
            return false;
        }
        int size = options.length;
        int difference = second - first;
        if (difference < 0) {
            difference += size;
        }
        return difference % 2 != 0;
    }
}
