package patterns.strings;

import java.util.ArrayList;
import java.util.List;

public class _5_ZigZagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        ZigZagConversionSolution solution = new ZigZagConversionSolution();
        String result = solution.convert(s, numRows);
        System.out.println(result);
    }
}

class ZigZagConversionSolution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());

        int currRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(currRow).append(c);

            // Flip direction if we reach the top or bottom
            if (currRow == 0 || currRow == numRows - 1)
                goingDown = !goingDown;

            currRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) result.append(row);

        return result.toString();
    }
}
