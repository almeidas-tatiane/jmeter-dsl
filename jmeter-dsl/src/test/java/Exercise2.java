import org.apache.http.entity.ContentType;
import org.junit.Test;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

import java.io.IOException;
import java.time.Duration;

import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

public class Exercise2 {
    @Test
    public void testExercise2() throws IOException{
        TestPlanStats stats= testPlan(
                threadGroup(10,Duration.ofSeconds(5),
                                httpSampler("https://httpbin.org/post")
                                        .post("{\"username\": \"teste\", \"password\": \"123456\"}", ContentType.APPLICATION_JSON)
                        ),
                        resultsTreeVisualizer()
                        ).run();

    }

}
