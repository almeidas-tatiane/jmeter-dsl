
import org.junit.jupiter.api.Test;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

import java.io.IOException;

import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

// Training Assertions
public class Exercise5 {
    @Test
    public void testExercise5() throws IOException {
        TestPlanStats stats = testPlan(
                threadGroup(1, 1,
                        httpSampler("https://petstore.swagger.io/v2/pet/1")
                                .children(
                                        responseAssertion().containsSubstrings("doggie")
                                )
              ),
                resultsTreeVisualizer()
        ).run();






    }
}
