package main;

public class HttpException extends Exception{
    private final HttpResponse httpResponse;

    public HttpException(String message, HttpResponse httpResponse) {
        super(message);
        this.httpResponse = httpResponse;
    }

    public HttpResponse getHttpResponse() {
        return httpResponse;
    }
}
