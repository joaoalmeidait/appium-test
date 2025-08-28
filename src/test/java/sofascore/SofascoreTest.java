package sofascore;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class SofascoreTest {
    public static void main (String[] args) {
        try {
            SofascoreConfig appiumTest = new SofascoreConfig();
            appiumTest.runTest();
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
