import org.junit.jupiter.api.Test;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

import java.io.IOException;
import java.time.Duration;

import static us.abstracta.jmeter.javadsl.JmeterDsl.*;
import static us.abstracta.jmeter.javadsl.dashboard.DashboardVisualizer.dashboardVisualizer;

// Training Ramp Up
public class Exercise6 {

    @Test
    public void testExercise6() throws IOException {
        TestPlanStats stats = testPlan(
                threadGroup()
                        .rampTo(50, Duration.ofSeconds(60))
                        .children(
                                httpSampler("https://httpbin.org/delay/1")
                        ),
                dashboardVisualizer()
        ).run();
    }

}