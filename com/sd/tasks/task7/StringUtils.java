package com.sd.tasks.task7;

/*
* Реализовать функцию, которая делает циклический сдвиг букв вправо,
* то есть rightShift("ABCDE", 1) = "EABCD" rightShift("ABCDE", 2) = "DEABC" rightShift("ABCDE", 3) = "CDEAB" rightShift("ABCDE", 4) = "BCDEA"
* Допустимо сдвигать на расстояние больше длины строки rightShift("ABCDE", 5) = "ABCDE" rightShift("ABCDE", 6) = "EABCD" rightShift("ABCDE", 7) = "DEABC"
* Допустимо сдвигать на отрицательное расстояние
* (выходит сдвиг влево) rightShift("ABCDE", -1) = "BCDEA" rightShift("ABCDE", -2) = "CDEAB" rightShift("ABCDE", -7) = "CDEAB".
* Сдвиг на расстояние 0 и сдвиги строк длиной 0 и 1 символ - разрешены.
* */

public class StringUtils {
    public static String rightShift(String arg, int delta) {
        int copyD = delta;

        if (delta == 0 || arg.equals("") || arg == "" || arg == null) {
            return arg;
        } else {
            char[] result = new char[arg.length()];
            char[] array = arg.toCharArray();

            if ((delta > arg.length() || delta < arg.length())) {
                copyD = delta - (delta / arg.length() * arg.length());
            }

            for (int i = 0; i < array.length; i++) {
                int tmp = copyD + i;
                if (tmp >= array.length) {
                    result[tmp - array.length] = array[i];
                } else if (tmp < 0) {
                    result[array.length + tmp] = array[i];
                } else {
                    result[tmp] = array[i];
                }
            }

            return new String(result);
        }
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(StringUtils.rightShift("ABCDE", 1).equals("EABCD"));
        System.out.println(StringUtils.rightShift("ABCDE", 2).equals("DEABC"));
        System.out.println(StringUtils.rightShift("ABCDE", 3).equals("CDEAB"));
        System.out.println(StringUtils.rightShift("ABCDE", 4).equals("BCDEA"));
        System.out.println(StringUtils.rightShift("ABCDE", 5).equals("ABCDE"));
        System.out.println(StringUtils.rightShift("ABCDE", 6).equals("EABCD"));
        System.out.println(StringUtils.rightShift("ABCDE", 7).equals("DEABC"));
        System.out.println(StringUtils.rightShift("ABCDE", -1).equals("BCDEA"));
        System.out.println(StringUtils.rightShift("ABCDE", -2).equals("CDEAB"));
        System.out.println(StringUtils.rightShift("ABCDE", -7).equals("CDEAB"));
        System.out.println(StringUtils.rightShift("", -10000).equals(""));

    }
}
