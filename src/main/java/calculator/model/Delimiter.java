package calculator.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Delimiter {

    private final Set<Character> delimiters;

    public Delimiter(String customDelimiters) {
        ArrayList<Character> delimiters = new ArrayList<>();
        delimiters.add(',');
        delimiters.add(':');
        for (int i = 0; i < customDelimiters.length(); i++) {
            delimiters.add(customDelimiters.charAt(i));
        }

        this.delimiters = new HashSet<Character>(delimiters);
    }
}
