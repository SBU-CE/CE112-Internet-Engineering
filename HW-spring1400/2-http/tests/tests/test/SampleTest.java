import main.HttpException;
import main.HttpRequest;
import main.HttpRequestMethod;
import main.HttpResponse;

import org.junit.*;

import static org.junit.Assert.*;

import java.io.IOException;

public class SampleTest {
    private HttpRequest httpRequest;
    final static String url = "http://httpbin.org/anything";

    @Before
    public void setUp() {
        httpRequest = new HttpRequest(url);
    }

    @Test
    public void createHttpRequestWithUrlAndMethod() {
        assertEquals(url, this.httpRequest.getUrl());
        assertEquals(HttpRequestMethod.GET, this.httpRequest.getHttpRequestMethod());
    }

    @Test
    public void successfulGetRequest() throws Exception{
            HttpResponse httpResponse = this.httpRequest.request();
            assertEquals(200, httpResponse.getStatus());
    }
}
