package calculator.model.str;

import static calculator.model.delimiter.DelimiterConstant.CUSTOM_DELIMITER_PREFIX;
import static calculator.model.delimiter.DelimiterConstant.CUSTOM_DELIMITER_SUFFIX;

import calculator.model.positivenum.PositiveNum;
import java.util.Arrays;
import java.util.List;

public class Str {

    private String str;
    private boolean containCustomDelimiters = false;

    public Str(String str) {
        this.str = str;
        if (isContainCustomDelimiters(str)) {
            containCustomDelimiters = true;
        }
    }

    public String getStr() {
        return str;
    }

    public boolean isContainCustomDelimiters() {
        return containCustomDelimiters;
    }

    public List<PositiveNum> separateStr(String delimiters) {
        if (isContainCustomDelimiters()) {
            str = extractStrWithoutCustomDelimiter(str);
        }
        return Arrays.stream(str.split(delimiters))
                .map(PositiveNum::new)
                .toList();
    }

    private String extractStrWithoutCustomDelimiter(String str) {
        return str.substring(str.indexOf(CUSTOM_DELIMITER_SUFFIX) + 2);
    }

    private boolean isContainCustomDelimiters(String str) {
        return str.startsWith(CUSTOM_DELIMITER_PREFIX);
    }
}
