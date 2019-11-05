package com.sd.tasks.task6;

/*
Предположим, что мы работаем с полиномами и храним их в виде последовательности коэффициентов.
То есть полином f = 1 * x*x*x + 2*x*x + 3*x + 4 представляем в виде [1, 2, 3, 4] точнее
new BigInteger[] {
   new BigInteger("1"),
   new BigInteger("2"),
   new BigInteger("3"),
   new BigInteger("4"),
}
Полином f = 10 * x*x - 100 представляем в виде [10, 0, -100] точнее
new BigInteger[] {
   new BigInteger("10"),
   new BigInteger("0"),
   new BigInteger("-100"),
}
Реализовать произведение полиномов, то есть нам дают полиномы f1 = x + 1 в виде [1, 1] и f2 = x + 1
в виде [1, 1] то мы должны вычислить (x + 1) * (x + 1) = x*x + 2*x + 1 в виде [1, 2, 1] Есть нам дают полиномы f1 = 10*x*x + 1
в виде [10, 0, 1] и f2 = -x в виде [-1, 0] то мы должны вычислить (10*x*x + 1) * (-x) = -10*x*x*x -x в виде [-10, 0, -1, 0]
*/

import java.math.BigInteger;
import java.util.Arrays;

public class PolyUtils {
    public static BigInteger[] mul(BigInteger[] x, BigInteger[] y) {
        if(x == null || y == null) {
            return null;
        }

        BigInteger[] result = new BigInteger[(x.length + y.length) - 1];

        for (int i = 0; i < result.length; i++){
            result[i] = new BigInteger("0");
        }

        for(int i = 0; i < x.length; i++) {
            for(int f = 0; f < y.length; f++) {
                int index = i + f;
                result[index] = result[index].add(x[i].multiply(y[f]));
            }
        }

        return result;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(PolyUtils.mul(new BigInteger[]{new BigInteger("1")}, new BigInteger[]{new BigInteger("1")}))); // EXPECTED 1
    }
}