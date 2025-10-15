package calculator.model.delimiter;

import java.util.Set;

public class Delimiters {

    private static Delimiters instance;
    private final Set<String> delimiters = Set.of(",", ":");

    private Delimiters() {
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

    public static Delimiters getInstance() {
        if (instance == null) {
            return new Delimiters();
        }
        return instance;
    }
}
