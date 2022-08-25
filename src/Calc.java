import java.io.IOException;
import java.util.Scanner;

public class Calc {

    static String result;
    static Scanner sc;
    static String input;
    static String scope;

    static String[] string;

    static String symbol1;

    static String symbol2;

    static char mAct;

    public static void main(String[] args) throws IOException {
        sc = new Scanner(System.in);
        System.out.println("Введите выражение");
        input = sc.nextLine().toUpperCase();
        System.out.println("Вы ввели выражение: " + "<< " + input + " >>");
        scope = calc(input);
        System.out.println("Результат выражения равен: " + "<< " + scope + " >>");
    }

    public static String calc(String input) throws IOException {
        // Разделение строки посимвольно "с пробелом"
        string = input.split(" ");
        if (string.length > 3) {
            throw new IOException("throws Exception //т.к. формат математической " +
                    "операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        if ((string.length == 1) || (string.length == 2)) {
            throw new IOException("throws Exception //т.к. строка не является математической операцией");
        }

        // Строковое представление первого числа
        symbol1 = string[0];

        // Строковое представление второго числа
        symbol2 = string[2];

        // Знак матматического действия
        mAct = string[1].charAt(0);

        System.out.println("Первое число: " + symbol1);
        System.out.println("Второе число: " + symbol2);

        if (Expressions.isValidArab(symbol1, symbol2)) {
            System.out.println("Вы ввели символы АРАБСКОЙ системы счета");
            Expressions.choice(symbol1, symbol2);
        } else if (Expressions.isValidRoman(symbol1, symbol2)) {
            Expressions.choice(symbol1, symbol2);
            System.out.println("Вы ввели символы РИМСКОЙ системы счета");
            return Expressions.toArab(result);
        } else if(Expressions.isAnotherValid(symbol1, symbol2)) {
            throw new IOException("throws Exception //т.к. используются " +
                    "одновременно разные системы счисления");
        } else {
            throw new IOException("Так как введенные числа вне числового диапазона");
        }
        return  result;
    }
}

