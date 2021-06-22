import main.HttpException;
import main.HttpRequest;
import main.HttpRequestMethod;
import main.HttpResponse;

import org.junit.*;
import org.junit.rules.*;

import static org.junit.Assert.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.CoreMatchers.containsString;

import java.util.*;

import java.io.IOException;

public class MyTest {
    final static String anythingUrl = "http://httpbin.org/anything";
    final static String url = anythingUrl;

    @Rule
    public Timeout timeout = new Timeout(30, java.util.concurrent.TimeUnit.SECONDS);

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
    public void requestTest() throws Exception {
        HttpRequest hr = new HttpRequest(url, HttpRequestMethod.GET);
        HttpResponse httpResponse = hr.request();
        assertEquals(200, httpResponse.getStatus());
    }
    @Test
    public void statusOK() throws Exception {
        HttpRequest hr = new HttpRequest(anythingUrl, HttpRequestMethod.GET);
        HttpResponse httpResponse = hr.request();
        assertTrue(httpResponse.getStatus()<300);
        assertTrue(httpResponse.getStatus()>100);
    }

    @Test
    public void status200() throws Exception {
        final int code = 200;
        HttpRequest hr = new HttpRequest(anythingUrl, HttpRequestMethod.GET);
        HttpResponse httpResponse = hr.request();
        assertEquals(code, httpResponse.getStatus());
    }

    @Test
    public void status301() throws Exception {
        final int code = 301;
        // it redirects to www.google.com
        HttpRequest hr = new HttpRequest("http://www.stackoverflow.com/", HttpRequestMethod.GET);
        HttpResponse httpResponse = hr.request();
        assertEquals(code, httpResponse.getStatus());
    }

    //@Test(expected=HttpException.class)
    public void status406() throws Exception {
        final int code = 406;
        // banned by google
        HttpRequest hr = new HttpRequest("http://ifconfig.com/", HttpRequestMethod.GET);
        HttpResponse httpResponse = hr.request();
    }
    //@Test(expected=HttpException.class)
    public void status503() throws Exception {
        final int code = 503;
        // by now its giving 503, let's hope it remains :))
        HttpRequest hr = new HttpRequest("http://www.ifconfig.co", HttpRequestMethod.GET);
        HttpResponse httpResponse = hr.request();
    }


    @Test
    public void queryParam1() throws Exception {
        HttpRequest hr = new HttpRequest(anythingUrl, HttpRequestMethod.GET);
        hr.setParams(new HashMap<>(Map.of(
                        "arg1", "value1"
                        )));
        HttpResponse httpResponse = hr.request();
        assertThat(httpResponse.getBody(), containsString("\"arg1\": \"value1\""));
    }

    @Test
    public void queryParam2() throws Exception {
        HttpRequest hr = new HttpRequest(anythingUrl, HttpRequestMethod.GET);
        hr.setParams(new HashMap<>(Map.of(
                        "arg1", "value1",
                        "arg2", "value2"
                        )));
        HttpResponse httpResponse = hr.request();
        assertThat(httpResponse.getBody(), containsString("\"arg1\": \"value1\""));
        assertThat(httpResponse.getBody(), containsString("\"arg2\": \"value2\""));
    }

    @Test
    public void responseHeader() throws Exception {
        HttpRequest hr = new HttpRequest(anythingUrl, HttpRequestMethod.GET);
        HttpResponse httpResponse = hr.request();
        assertThat(httpResponse.getHeaders().get("Content-Type"), contains("application/json"));
    }

    @Test
    public void setDataForGet() throws Exception {
        HttpRequest hr = new HttpRequest(anythingUrl, HttpRequestMethod.GET);
        hr.setBody(new HashMap<>(Map.of("dummy-key", "dummy-value")));
        HttpResponse httpResponse = hr.request();
        assertThat(httpResponse.getBody(), containsString("data\": \"\""));
    }

    @Test
    public void postData() throws Exception {
        HttpRequest hr = new HttpRequest(anythingUrl, HttpRequestMethod.POST);
        hr.setBody(new HashMap<>(Map.of("keyy", "vall")));
        hr.setHeaders(new HashMap<>(Map.of("Content-Type", "application/json"))); 
        HttpResponse httpResponse = hr.request();
        assertThat(httpResponse.getBody(), containsString("keyy"));
        assertThat(httpResponse.getBody(), containsString("vall"));
    }

    @Test
    public void postData2() throws Exception {
        HttpRequest hr = new HttpRequest(anythingUrl, HttpRequestMethod.POST);
        hr.setBody(new HashMap<>(Map.of("keyy", "vall", "somerandomkey", "somerandomvalue")));
        hr.setHeaders(new HashMap<>(Map.of("Content-Type", "application/json"))); 
        HttpResponse httpResponse = hr.request();
        assertThat(httpResponse.getBody(), containsString("keyy"));
        assertThat(httpResponse.getBody(), containsString("vall"));
        assertThat(httpResponse.getBody(), containsString("somerandomkey"));
        assertThat(httpResponse.getBody(), containsString("somerandomvalue"));
    }
}
