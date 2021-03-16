package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    public int add(String numbers) {
        if (numbers.equals("")) {
            return 0;
        }
        String[] numberArr = numbers.split(",");
        int ans = 0;
        for (String str : numberArr) {
            ans = ans + Integer.parseInt(str);
        }
        return ans;
    }
}
