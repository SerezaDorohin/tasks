package com.java.tasks.task3;

import java.math.BigInteger;

public class FractionUtils {
    public static BigInteger[] sum(BigInteger[] x, BigInteger[] y) {
        if(x == null || y == null){
            return null;
        }

        BigInteger DOWN = y[1].multiply(x[1]);
        BigInteger UP = x[0].multiply(DOWN.divide(x[1])).add(y[0].multiply(DOWN.divide(y[1])));

        BigInteger divide = (DOWN.gcd(UP));

        return new BigInteger[]{UP.divide(divide), DOWN.divide(divide)};
    }
}