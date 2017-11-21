package myserver;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zy on 17-6-29.
 */
public class HttpRequest {

    private String url;
    private String method;
    private String httpversion;

    private HashMap<String, String> headers;
    private String content;
    private String headString;

    public HttpRequest(String text) throws Exception{
        this.parse(text);

    }

    private void parse(String text) throws Exception {

        int index = text.indexOf("\r\n");
        String methodUrl = text.substring(0,index);
        String left = text.substring(index+2);
        String[] a = methodUrl.split(" ");
        this.method = a[0];
        this.url = a[1];
        this.httpversion = a[2];

        this.headString = left.substring(0, left.indexOf("\r\n\r\n"));

        this.content = left.substring(left.indexOf("\r\n\r\n")+4);


    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHttpversion() {
        return httpversion;
    }

    public void setHttpversion(String httpversion) {
        this.httpversion = httpversion;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeadString() {
        return headString;
    }

    public void setHeadString(String headString) {
        this.headString = headString;
    }
}
