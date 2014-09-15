package org.rwds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.junit.Test;

public class RemoteWeatherDataServiceTest {
    
    private static final String username = "<username>";
    private static final String password = "<password>";

    @Test
    public void test00() throws IOException {
        RemoteWeatherDataService service = new RemoteWeatherDataService(username, password);
        InputStream result = service.queryByPostleitzahl("97072");
        BufferedReader in = new BufferedReader(new InputStreamReader(result));
        String line = null;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
    }
    
    @Test
    public void test01() throws IOException {
        RemoteWeatherDataService service = new RemoteWeatherDataService(username, password);
        InputStream result = service.query("Aschaffenburg");
        BufferedReader in = new BufferedReader(new InputStreamReader(result));
        String line = null;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
    }
    
    @Test
    public void test02() throws IOException {
        RemoteWeatherDataService service = new RemoteWeatherDataService(username, password);
        InputStream result = service.queryByName("Aschaffenburg");
        BufferedReader in = new BufferedReader(new InputStreamReader(result));
        String line = null;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
    }
    
    @Test
    public void test03() throws IOException {
        RemoteWeatherDataService service = new RemoteWeatherDataService(username, password);
        InputStream result = service.forecast("DE0010967");
        BufferedReader in = new BufferedReader(new InputStreamReader(result));
        String line = null;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
    }
    
}
