import org.example.lambda.impl.Fly;
import org.junit.Test;

public class FlyTest {
    @Test
    public void test() {
        Fly f = () -> {
            System.out.println("飞机飞");
        };
        f.fly();
    }
}
