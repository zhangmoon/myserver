package tomcat;

import java.io.IOException;

/**
 * Created by zy on 17-11-21.
 */
public class StaticResourceProcessor {
    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
