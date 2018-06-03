package mangolost;

//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//        Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
//        For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
//
//        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//        I can be placed before V (5) and X (10) to make 4 and 9.
//        X can be placed before L (50) and C (100) to make 40 and 90.
//        C can be placed before D (500) and M (1000) to make 400 and 900.
//        Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

/**
 *
 */
public class Solution0013 {

    /**
     *
     * @param c
     * @return
     */
    public int getRomanValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    /**
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return getRomanValue(s.charAt(0));
        }
        int result = 0;
        int sub = getRomanValue(s.charAt(0));
        int lastValue = sub;
        for (int i = 1; i < len; ++i) {
            char currentChar = s.charAt(i);
            int currentValue = getRomanValue(currentChar);
            if (currentValue == lastValue) {
                sub += currentValue;
            } else if (currentValue < lastValue) {
                result += sub;
                sub = currentValue;
            } else {
                sub = currentValue - sub;
            }
            lastValue = currentValue;
        }
        result += sub;
        return result;
    }

    public static void main(String[] args) {
        Solution0013 solution = new Solution0013();
        String x = "MCMXCIV";
        int y = solution.romanToInt(x);
        System.out.println(y);
    }
}
