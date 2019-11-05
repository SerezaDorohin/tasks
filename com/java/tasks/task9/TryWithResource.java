package com.java.tasks.task9;

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

}

interface AutoCloseableFactory {
    public AutoCloseable create() throws Throwable;
}

interface TryBody {
    public void runBody() throws Throwable;
}