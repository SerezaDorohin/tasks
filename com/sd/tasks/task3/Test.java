package com.sd.tasks.task3;

import java.math.BigInteger;
import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        BigInteger[] x = {new BigInteger("1"), new BigInteger("2")};
        BigInteger[] y = {new BigInteger("1"), new BigInteger("3")};
        BigInteger[] expected = {new BigInteger("5"), new BigInteger("6")};
        BigInteger[] actual = FractionUtils.sum(x, y);
        if (!Arrays.equals(expected, actual)) {
            throw new AssertionError();
        }
        System.out.print("OK");
    }
}