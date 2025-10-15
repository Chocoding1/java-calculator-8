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

    public static Delimiters getInstance() {
        if (instance == null) {
            return new Delimiters();
        }
        return instance;
    }
}
