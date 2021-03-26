package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Calculator {

    public int add(String numbers) throws NegativesNotAllowedRuntimeExeption {

        if (numbers.equals("")) {
            return 0;
        }
        if (hasDelimiter(numbers)) {
            numbers = handelDelimiter(numbers);
        }

        String[] numberArr = numbers.replace("\\n", ",").split(",");

        List<Integer> negativNumbers = new ArrayList<>();

        var ans = Stream.of(numberArr)
                .map(Integer::parseInt)
                .filter(t -> t <= 1000)
                .peek(t -> {
                    if (t < 0) negativNumbers.add(t);
                })
                .reduce(0, (result, t) -> result + t);

        if (negativNumbers.isEmpty()) {
            return ans;
        } else {
            throw new NegativesNotAllowedRuntimeExeption(negativNumbers.toString());
        }

    }

    private String handelDelimiter(String numbers){
            if (numbers.indexOf("[") != -1 && numbers.indexOf("]") != -1) {
                numbers = delimiterRefactor(numbers);
            } else {
                int index = numbers.indexOf("\\n");
                String delimiter = numbers.substring(2, index);
                numbers = numbers.substring(index + 2);
                numbers = numbers.replace(delimiter, ",");
            }
            return numbers;
    }

    private String delimiterRefactor(String numbers) {
        String numbersSubString = numbers.substring(2);
        boolean delimiterBrackets = true;
        while (delimiterBrackets) {
            int indexStart = numbersSubString.indexOf("[") + 1;
            int indexStop = numbersSubString.indexOf("]");
            String delimiter = numbersSubString.substring(indexStart, indexStop);
            numbersSubString = numbersSubString.substring(indexStop + 1);
            numbersSubString = numbersSubString.replace(delimiter, ",");

            if (numbersSubString.indexOf("[") == -1) {
                delimiterBrackets = false;
            }
        }

        int i = numbersSubString.indexOf("\\n");

        return numbersSubString.substring(i + 2);
    }

    private boolean hasDelimiter(String str) {
        if (str.length() < 4) return false;
        if (!str.substring(0, 2).equals("//")) return false;
        if (!str.contains("\\n")) return false;

        return true;
    }
}
