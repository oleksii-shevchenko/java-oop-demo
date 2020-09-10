package ua.ipt.kpi.anonymous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class AnonymousDemo {
    public static void main(String[] args) throws Exception {
        Service service = new RandomService();

        String sessionId = "Session : " + ThreadLocalRandom.current().nextInt();

        System.out.println("Staring interaction");
        for (int i = 0; i < 10; i++) {
            service.computeAsync("Simple request [id=" + i + "]", new Callback() {
                @Override
                public void onSuccess(String result) {
                    System.out.println("Success : " + result + " " + sessionId);
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println("Error : " +  t.getMessage() + " " + sessionId);
                }
            });
        }
        System.out.println("Continue in async");
        Thread.sleep(20_000);
    }
}

interface Service {
    void computeAsync(String request, Callback callback);
}

interface Callback {
    void onSuccess(String result);

    void onError(Throwable t);
}

class RandomService implements Service {
    @Override
    public void computeAsync(String request, Callback callback) {
        CompletableFuture.delayedExecutor(ThreadLocalRandom.current().nextInt(16), TimeUnit.SECONDS)
                .execute(() -> {
                    if (ThreadLocalRandom.current().nextBoolean()) {
                        callback.onSuccess("Response [" + request + "]");
                    } else {
                        callback.onError(new RuntimeException("Exception [" + request + "]"));
                    }
                });
    }
}