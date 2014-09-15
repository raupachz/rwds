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

import org.junit.Test;
import static org.junit.Assert.*;

public class MD5Test {
    
    @Test
    public void test01() {
        String plain = "The quick brown fox jumps over the lazy dog";
        String digest = MD5.digest(plain);
        assertEquals("9e107d9d372bb6826bd81d3542a419d6", digest);
        
    }
    
    @Test
    public void test02() {
        String plain = "";
        String digest = MD5.digest(plain);
        assertEquals("d41d8cd98f00b204e9800998ecf8427e", digest);
    }
    
    @Test
    public void test03() {
        String plain = "e2nohggbDE4iKM$2S97072";
        String digest = MD5.digest(plain);
        assertEquals("bfee531987aac30a276bdf1e3f753dd9", digest);
        
        String n = "DE23234";
    }
    
}
