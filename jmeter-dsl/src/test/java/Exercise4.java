import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.Test;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

import java.io.IOException;

import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

//Training Login Flow and response extraction
public class Exercise4 {

    @Test
    public void testExercise4() throws IOException {
        TestPlanStats stats = testPlan(
                threadGroup(1,1,
                        httpSampler("https://httpbin.org/post")
                                .post("{\"token\": \"123456\"}", ContentType.APPLICATION_JSON)
                                .children(
                                        jsonExtractor("TOKEN", "json.token")
                                ),
                        httpSampler("https://httpbin.org/bearer")
                                .header("Authorization", "Bearer ${TOKEN}")

                        ),
                resultsTreeVisualizer()

        ).run();
    }



}
