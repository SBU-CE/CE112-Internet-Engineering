import main.HttpException;
import main.HttpRequest;
import main.HttpRequestMethod;
import main.HttpResponse;

import org.junit.*;

import static org.junit.Assert.*;

import java.util.*;

import java.io.IOException;

public class SampleTest {
    final static String url = "http://httpbin.org/anything";

    @Test
    public void oneParamConsTest() {
        HttpRequest httpRequest = new HttpRequest(url);
        assertEquals(HttpRequestMethod.GET, httpRequest.getHttpRequestMethod());
    }

    @Test
    public void twoParamConsTest() {
        HttpRequest httpRequest = new HttpRequest(url, HttpRequestMethod.POST);
    }

    @Test
    public void allConsTest() {
        HttpRequest httpRequest =
            new HttpRequest(url, HttpRequestMethod.POST,
                            new HashMap<String, String>(),
                            new HashMap<String, String>(),
                            new HashMap<String, String>()
                           );
    }

    @Test
    public void urlTest() {
        String actual = new HttpRequest(url).getUrl();
        assertEquals(url, actual);
    }

    @Test
    public void methodTwoParamTest() {
        HttpRequest httpRequest = new HttpRequest(url, HttpRequestMethod.POST);
        assertEquals(HttpRequestMethod.POST, httpRequest.getHttpRequestMethod());
    }

    @Test
    public void settersTest() {
        HttpRequest hr = new HttpRequest(url, HttpRequestMethod.POST);
        hr.setUrl("https://google.com");
        hr.setParams(new HashMap<String, String>());
        hr.setHeaders(new HashMap<String, String>());
        hr.setBody(new HashMap<String, String>());
        hr.setHttpRequestMethod(HttpRequestMethod.PUT);
    }

    @Test
    public void gettersTest() {
        HttpRequest hr = new HttpRequest(url, HttpRequestMethod.POST);
        String url = hr.getUrl();
        HashMap<String, String> hm = hr.getParams();
        hm = hr.getHeaders();
        hm = hr.getBody();
        HttpRequestMethod method = hr.getHttpRequestMethod();
    }

    @Test
    public void requestTest() {
        try {
            HttpRequest hr = new HttpRequest(url, HttpRequestMethod.POST);
            HttpResponse httpResponse = hr.request();
            //assertFalse(200 == httpResponse.getStatus());
        } catch (IOException | HttpException e) {
            // thats ok
        }
    }

}
