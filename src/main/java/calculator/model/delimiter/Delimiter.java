package calculator.model.delimiter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Delimiter {

    private static Delimiter instance;
    private final Set<Character> delimiters = new HashSet<>(List.of(',', ':'));

    private Delimiter() {
    }

    public void addDelimiter(Character delimiter) {
        delimiters.add(delimiter);
    }

    public String getDelimiters() {
        StringBuilder sb = new StringBuilder().append("[");

        for (Character delimiter : delimiters) {
            sb.append(delimiter);
        }
        sb.append("]");

        return sb.toString();
    }

    public static Delimiter getInstance() {
        if (instance == null) {
            return new Delimiter();
        }
        return instance;
    }
}
