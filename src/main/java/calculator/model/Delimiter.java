package calculator.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 리팩토링 가이드
 * https://chatgpt.com/s/t_69327cdbc6308191a5d5adb0ff69daed
 * https://chatgpt.com/s/t_69328447a64c8191b17cd6cd826a7f2b
 * https://chatgpt.com/s/t_69328ef746408191ab13a9c1390ea357
 */
public class Delimiter {

    private static final Set<String> DEFAULT_DELIMITERS = Set.of(",", ":");
    private final Set<String> delimiters;

    public Delimiter(String customDelimiters) {
        this.delimiters = new HashSet<>(DEFAULT_DELIMITERS);
        for (int i = 0; i < customDelimiters.length(); i++) {
            delimiters.add(String.valueOf(customDelimiters.charAt(i)));
        }
    }

    public String[] split(String expression) {
        String pattern = getDelimiters();
        return expression.split(pattern);
    }

    public String getDelimiters() {
        return String.join("|", delimiters);
    }
}
