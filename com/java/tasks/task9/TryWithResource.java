package com.java.tasks.task9;

import java.util.*;

/*
Для работы с двумя ресурами на Java7 реализован такой код:
public class AnswerTwoResourcesJava7 {
   public static void call(
           AutoCloseableFactory factoryA,
           AutoCloseableFactory factoryB,
           TryBody body) throws Throwable {
       try (AutoCloseable a = factoryA.create();
            AutoCloseable b = factoryB.create()
       ) {
           body.runBody();
       }
   }
}
Необходимо реализовать эту логику БЕЗ использования try-with-resources.
*/

public class TryWithResource {
    public static void twoResource(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB, TryBody body) throws Throwable {
        AutoCloseable a = factoryA.create();
        AutoCloseable b = factoryB.create();

        try {
            body.runBody();
        } catch (Throwable bodyEx) {
            try {
                a.close();
            } catch (Throwable closeEx) {
                bodyEx.addSuppressed(closeEx);
            }
            try {
                b.close();
            } catch (Throwable closeEx) {
                bodyEx.addSuppressed(closeEx);
            }
            throw bodyEx;
        }

        a.close();
        b.close();
    }
}

interface AutoCloseableFactory {
    public AutoCloseable create() throws Throwable;
}

interface TryBody {
    public void runBody() throws Throwable;
}

class Test{
    public static void main(String[] args) {
        //prepare
        final List<String> actualHistoryCall = new ArrayList<String>();
        final List<String> expectedExceptionTextAndOrder = new ArrayList<String>();
        expectedExceptionTextAndOrder.add("Error factoryB.createB");
        expectedExceptionTextAndOrder.add("Error closeA");
        List<String> expectedHistoryCall = Arrays.asList("factoryA.createA", "factoryB.createB", "A.close");

        final AutoCloseable resourceA = new AutoCloseable() {
            @Override
            public void close() throws Exception {
                actualHistoryCall.add("A.close");
                throw new Error(expectedExceptionTextAndOrder.get(1));
            }
        };

        final AutoCloseable resourceB = new AutoCloseable() {
            @Override
            public void close() throws Exception {
                actualHistoryCall.add("B.close");
            }
        };

        AutoCloseableFactory factoryA = new AutoCloseableFactory() {
            @Override
            public AutoCloseable create() throws Throwable {
                actualHistoryCall.add("factoryA.createA");
                return resourceA;
            }


        };

        AutoCloseableFactory factoryB = new AutoCloseableFactory() {
            @Override
            public AutoCloseable create() {
                actualHistoryCall.add("factoryB.createB");
                throw new Error(expectedExceptionTextAndOrder.get(0));
            }


        };

        TryBody tryBody = new TryBody() {
            @Override
            public void runBody() {
                actualHistoryCall.add("TryBody.runBody");
                //NOP
            }
        };

        //call and  check
        try {
            TryWithResource.twoResource(factoryA, factoryB, tryBody);
        } catch (Throwable e) {

            if (!expectedExceptionTextAndOrder.get(0).equals(e.getMessage()))
                throw new AssertionError("Not correct main exception");

            if (e.getSuppressed().length == 0)
                throw new AssertionError("Should be suppressed exceptions  ");

            if(!expectedExceptionTextAndOrder.get(1).equals(e.getSuppressed()[0].getMessage()))
                throw new AssertionError("Not correct suppressed exception should to be "+expectedExceptionTextAndOrder.get(1) +" but found " + e.getSuppressed()[0].getMessage());
        }

        if (!actualHistoryCall.equals(expectedHistoryCall))
            throw new AssertionError("Not correct order call should be " + expectedHistoryCall.toString() + " but found " + actualHistoryCall.toString());

        System.out.print("OK");
    }
}