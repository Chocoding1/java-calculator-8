package calculator.model.delimiter;

import java.util.Set;

public class Delimiter {

    private static Delimiter instance;
    private final Set<String> delimiters = Set.of(",", ":");

    private Delimiter() {
    }

    public void addDelimiter(String delimiter) {
        delimiters.add(delimiter);
    }

    public String getDelimiters() {
        StringBuilder sb = new StringBuilder().append("[");

        for (String delimiter : delimiters) {
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
