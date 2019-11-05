package com.sd.tasks.task4;

/*
Реализовать метод, который преобразует BigInteger в битовую строку (String из '0' и '1')
toBitStr(new BigInteger("2")) = "10" toBitStr(new BigInteger("8")) = "1000" toBitStr(new BigInteger("10")) = "1010"
toBitStr(new BigInteger("140")) = "10001100"
*/

import java.math.BigInteger;

public class BigIntegerUtils {
    public static void main(String[] args) {
        toBitStr(new BigInteger("1"));
    }

    public static String toBitStr(BigInteger arg) {
        String result = "";
        BigInteger a;
        BigInteger nulBigInteger = new BigInteger("0");
        int pow = arg.bitLength() - 1;

        if ( pow < 0 ) {
            return "0";
        }

        a = (new BigInteger("2")).pow(pow);

        while (a.compareTo(nulBigInteger) > 0) {
            result += (a.and(arg).compareTo(nulBigInteger) > 0) ? "1" : "0";
            a = a.shiftRight(1);
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(BigIntegerUtils.toBitStr(new BigInteger(String.valueOf(0))));   // EXPECTED 0
        System.out.println(BigIntegerUtils.toBitStr(new BigInteger(String.valueOf(2))));   // EXPECTED 10
        System.out.println(BigIntegerUtils.toBitStr(new BigInteger(String.valueOf(8))));   // EXPECTED 1000
        System.out.println(BigIntegerUtils.toBitStr(new BigInteger(String.valueOf(10))));  // EXPECTED 1010
        System.out.println(BigIntegerUtils.toBitStr(new BigInteger(String.valueOf(140)))); // EXPECTED 10001100
        System.out.println(BigIntegerUtils.toBitStr(new BigInteger(String.valueOf(1))));   // EXPECTED 1
        System.out.println(BigIntegerUtils.toBitStr(new BigInteger("1024").pow(10))); // EXPECTED 10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
    }
}