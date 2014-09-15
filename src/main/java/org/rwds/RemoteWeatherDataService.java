/*
    The MIT License

    Copyright (c) 2014 Björn Raupach

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.
*/
package org.rwds;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class RemoteWeatherDataService {
    
    private static final String RWDS_HOST = "rwds2.wetter.com";
    
    private final String username;
    private final String password;

    public RemoteWeatherDataService(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public InputStream forecast(String citycode) throws IOException {
        String cs = MD5.digest(username, password, citycode);
        URL url = new URLBuilder(RWDS_HOST)
                        .addPathParameter("forecast")
                        .addPathParameter("weather")
                        .addPathParameter("user", username)
                        .addPathParameter("city", citycode)
                        .addPathParameter("cs", cs)
                        .toURL();
        return url.openStream();
    }
    
    public InputStream query(String query) throws IOException {
        String cs = MD5.digest(username, password, query);
        URL url = new URLBuilder(RWDS_HOST)
                        .addPathParameter("location")
                        .addPathParameter("index")
                        .addPathParameter("user", username)
                        .addPathParameter("search", query)
                        .addPathParameter("cs", cs)
                        .toURL();
        return url.openStream();
    }
    
    public InputStream queryByName(String name) throws IOException {
        String cs = MD5.digest(username, password, name);
        URL url = new URLBuilder(RWDS_HOST)
                        .addPathParameter("location")
                        .addPathParameter("name")
                        .addPathParameter("user", username)
                        .addPathParameter("search", name)
                        .addPathParameter("cs", cs)
                        .toURL();
        System.out.println(url);
        return url.openStream();
    }
    
    public InputStream queryByPostleitzahl(String plz) throws IOException {
        String cs = MD5.digest(username, password, plz);
        URL url = new URLBuilder(RWDS_HOST)
                        .addPathParameter("location")
                        .addPathParameter("plz")
                        .addPathParameter("user", username)
                        .addPathParameter("search", plz)
                        .addPathParameter("cs", cs)
                        .toURL();
        System.out.println(url);
        return url.openStream();
    }
    
    
    
    
    
}
