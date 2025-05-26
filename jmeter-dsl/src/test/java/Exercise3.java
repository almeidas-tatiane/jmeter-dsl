import org.junit.Test;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

import java.io.IOException;

import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

//Training CSV files
public class Exercise3 {
    @Test
    public void testExercise3() throws IOException{
        TestPlanStats stats = testPlan(
                csvDataSet("src/test/resources/users.csv"),
                threadGroup(7,1,
                        httpSampler("https://httpbin.org/get?user=${USER}")

                ),
                resultsTreeVisualizer()
        ).run();
    }
}
