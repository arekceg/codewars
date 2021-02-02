package arekceg;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadedCounting {

    public static void countInThreads(Counter counter) {
        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        ExecutorService executor3 = Executors.newSingleThreadExecutor();
        try {
            for (int i = 1; i <= 100; i++) {
                if (i % 3 == 0) {
                    int finalI = i;
                    executor1.submit(() -> counter.count(finalI)).get();
                } else if (i % 3 == 1) {
                    int finalI = i;
                    executor2.submit(() -> counter.count(finalI)).get();
                } else {
                    int finalI = i;
                    executor3.submit(() -> counter.count(finalI)).get();
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
