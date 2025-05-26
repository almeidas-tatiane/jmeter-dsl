import static us.abstracta.jmeter.javadsl.JmeterDsl.*;
import java.io.IOException;
import java.time.Duration;
import org.junit.Test;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;


// Training simple request
public class Exercise1 {

    @Test
    public void testExercise1() throws IOException {
        TestPlanStats stats = testPlan(
                threadGroup(5,Duration.ofSeconds(10),
                        httpSampler("https://httpbin.org/get"))

        ).run();

    }

}
