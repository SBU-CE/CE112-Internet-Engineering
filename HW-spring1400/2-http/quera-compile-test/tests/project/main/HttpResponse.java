package main;

import java.util.List;
import java.util.Map;

public class HttpResponse {
    private int status;
    private Map<String, List<String>> headers;
    private String body;

    public HttpResponse(int status, Map<String, List<String>> headers, String body) {
        this.status = status;
        this.headers = headers;
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }
}
