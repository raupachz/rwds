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

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Test;
import static org.junit.Assert.*;

public class URLBuilderTest {
    
    @Test
    public void test00() throws MalformedURLException {
        URL url = new URLBuilder("rwds2.wetter.com").toURL();
        URL expected = new URL("http://rwds2.wetter.com");
        assertEquals(expected, url);
    }
    
    @Test
    public void test01() throws MalformedURLException {
        URL url = new URLBuilder("rwds2.wetter.com")
                        .addPathParameter("location")
                        .toURL();
        URL expected = new URL("http://rwds2.wetter.com/location");
        assertEquals(expected, url);
    }
    
    @Test
    public void test02() throws MalformedURLException {
        URL url = new URLBuilder("rwds2.wetter.com")
                        .addPathParameter("location")
                        .addPathParameter("user","test")
                        .toURL();
        URL expected = new URL("http://rwds2.wetter.com/location/user/test");
        assertEquals(expected, url);
    }
    
}
