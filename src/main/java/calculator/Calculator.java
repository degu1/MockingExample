package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    public int add(String numbers) {
        if (numbers.equals("")) {
            return 0;
        }

        if (hasDelimiter(numbers)) {
            int index = numbers.indexOf("\\n");
            String delimiter = numbers.substring(2, index);
            numbers = numbers.substring(index + 2);
            numbers = numbers.replace(delimiter, ",");
        }

        String[] numberArr = numbers.replace("\\n", ",").split(",");
        int ans = 0;
        for (String str : numberArr) {
            ans = ans + Integer.parseInt(str);
        }
        return ans;
    }

    private boolean hasDelimiter(String str) {
        if (str.length() < 4) return false;
        if (!str.substring(0, 2).equals("//")) return false;
        if (!str.contains("\\n")) return false;
        return true;
    }
}
