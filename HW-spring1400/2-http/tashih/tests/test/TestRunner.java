import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MyTest.class);

        for (Failure failure : result.getFailures()) {
            System.err.println(failure.getDescription());
        }

        int all   = result.getRunCount();
        int fails = result.getFailureCount();
        int score = 100 - (fails * 100 / all);

        System.err.println(
                (
                result.wasSuccessful()?
                "complete, score : " :
                "not complete, score : ")
            + score);

        System.exit(result.getFailureCount());
    }
}
