package test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class MainTest {
    public static void main(String[] args) {
        try {
            Appiumconfig appiumTest = new Appiumconfig();
            appiumTest.runTest();
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}