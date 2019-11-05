package com.sd.tasks.task5;

/*
Предположим, что мы работаем с полиномами и храним их в виде последовательности коэффициентов. То есть полином f = 1 * x*x*x + 2*x*x + 3*x + 4 представляем в виде [1, 2, 3, 4] точнее
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
Реализовать вычисление полинома в точке, то есть нам, скажем,
дают полином f = 2*x*x*x - 3*x в виде [2, 0, -3, 0] и точку 100, а мы должны вычислить 2*100*100*100 - 3*100 = 2000000 - 300 = 1999700
*/

import java.math.BigInteger;

public class PolyUtils {
    public static BigInteger eval(BigInteger[] poly, BigInteger arg) {
        if(poly == null || arg == null) {
            return null;
        }

        BigInteger result = new BigInteger(String.valueOf(0));
        int length_poly = poly.length;

        for(int pos = 0; pos < length_poly; pos++) {
            result = result.add(poly[pos].multiply(arg.pow((length_poly - 1) - pos)));
        }

        return result;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(PolyUtils.eval(new BigInteger[]{new BigInteger("1")}, new BigInteger("10"))); // EXPECTED 1
    }
}