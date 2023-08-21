import org.junit.Test;

public class TestThreadRabbitRun {
    @Test
    public void test1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.printf("兔子跑");
            }
        }).start();
    }

    @Test

    public void test2() {
        Runnable a = () -> System.out.println("兔子跑");
        Thread thread = new Thread(a);
        thread.start();
    }
}

