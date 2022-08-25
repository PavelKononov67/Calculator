import java.io.IOException;
import java.lang.StringBuilder;
import java.lang.String;

class Expressions extends Calc {
    // Метод сложения чисел
    public static String plus(String symbol1, String symbol2) {
        return String.valueOf(Integer.parseInt(symbol1) +
                                    Integer.parseInt(symbol2));
    }

    // Метод вычитания чисел
    public static String minus(String symbol1, String symbol2) {
        return String.valueOf(Integer.parseInt(symbol1) -
                                    Integer.parseInt(symbol2));
    }

    // Метод деления чисел
    public static String division(String symbol1, String symbol2) {
        return String.valueOf(Integer.parseInt(symbol1) /
                                    Integer.parseInt(symbol2));
    }

    // Метод умножения чисел
    public static String multiplication(String symbol1, String symbol2) {
        return String.valueOf(Integer.parseInt(symbol1) *
                                    Integer.parseInt(symbol2));
    }


    static String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}; // length = 10;

    static String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"}; // length = 10;

    // Метод определения математического действия
    static void choice(String symbol1, String symbol2) {
        switch (mAct) {
            case ('+') -> result = Expressions.plus(symbol1, symbol2);
            case ('-') -> result = Expressions.minus(symbol1, symbol2);
            case ('/') -> result = Expressions.division(symbol1, symbol2);
            case ('*') -> result = Expressions.multiplication(symbol1, symbol2);
        }
    }

    // Проверка на валидность арабских чисел
    static boolean isValidArab(String symbol1, String symbol2) {
        for (String s : arab) {
            for (String value : arab) {
                if ((symbol1.equals(s) && symbol2.equals(value))) {
                    return true;
                }
            }
        }
        return false;
    }

    // Проверка на валидность римских чисел
    static boolean isValidRoman(String symbol1, String symbol2) {
        for(int i = 0; i < roman.length; i++) {
            for(int j = 0; j < roman.length; j++) {
                if ((symbol1.equals(roman[i]) && symbol2.equals(roman[j]))) {
                    Expressions.symbol1 = arab[i];
                    Expressions.symbol2 = arab[j];
                    return true;
                }
            }
        }
        return false;
    }

    // Метод проверки обратной валидации
    static boolean isAnotherValid(String symbol1, String symbol2) {
        for (String x: arab) {
            for (String y : roman) {
                if (((symbol1.equals(x)) && (symbol2.equals(y))) ||
                        ((symbol1.equals(y)) && (symbol2.equals(x)))) {
                    return true;
                }
            }
        }
        return false;
    }

    // Метод перевода из арабского в римское
    static String toArab(String result) throws IOException {
        StringBuilder str = new StringBuilder();
        String[] rom = {"C","XC","L","XL", "X", "IX", "V", "IV","I"};
        int[] ar = {100,90,50,40,10, 9, 5, 4, 1};
        int num = Integer.parseInt(result);
        if (num < 1) {
            throw new IOException("throws Exception //т.к. в римской системе нет отрицательных чисел");
        }
        for(int k = 0; k < ar.length; k++) {
            while(num >= ar[k]) {
                if ((num >= ar[k])) {
                    str.append(rom[k]);
                    num = num - ar[k];
                }
            }
        }
        return str.toString();
    }
}