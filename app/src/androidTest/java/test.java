import com.udacity.gradle.builditbigger.AsyncTaskFinishedInterface;
import com.udacity.gradle.builditbigger.FetchJokeAsyncTask;

import org.junit.Test;

public class test {
    @Test
    public void verifyAsyncTask() {

        class TestClass implements AsyncTaskFinishedInterface {
            @Override
            public String jokeRetrieved(String joke) {
                if (joke == null || joke.isEmpty()) {
                    throw new AssertionError("The AsyncTask did not retrieve a joke ...");

                }
                return null;
            }
        }

        TestClass testClass = new TestClass();
        new FetchJokeAsyncTask().execute(testClass);
    }
}
