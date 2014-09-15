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
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class URLBuilder {
    
    public static final String EMTPY = "";

    private final String host;
    private final List<PathParameter> pathParameter;
    private final List<QueryParameter> queryParameter;

    public URLBuilder(String host) {
        this.host = host;
        this.pathParameter = new LinkedList<URLBuilder.PathParameter>();
        this.queryParameter = new LinkedList<URLBuilder.QueryParameter>();
    }

    public URLBuilder addQueryParameter(String name, Object value) {
        if (value != null) {
            return addQueryParameter(new QueryParameter(name, value));
        } else {
            return this;
        }
    }

    private URLBuilder addQueryParameter(QueryParameter parameter) {
        queryParameter.add(parameter);
        return this;
    }
    
    public URLBuilder addPathParameter(String name, String value) {
        return addPathParameter(new PathParameter(name, value));
    }
    
    public URLBuilder addPathParameter(String name) {
        return addPathParameter(new PathParameter(name));
    }
    
    private URLBuilder addPathParameter(PathParameter parameter) {
        pathParameter.add(parameter);
        return this;
    }

    public URI toURI() {
        String path = EMTPY;
        if (!pathParameter.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("/");
            for (PathParameter parameter : pathParameter) {
                sb.append(parameter).append("/");
            }
            sb.deleteCharAt(sb.length() - 1); // chop last slash
            path = sb.toString();
        }
        
        String query = null;
        if (!queryParameter.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (QueryParameter parameter : queryParameter) {
                sb.append(parameter).append("&");
            }
            sb.deleteCharAt(sb.length() - 1); // chop last ampersand
            query = sb.toString();
        }

        URI uri = null;
        try {
            uri = new URI("http", null, host, -1, path, query, null);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return uri;
    }

    public URL toURL() {
        try {
            return toURI().toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public class QueryParameter {

        final String name;
        final Object value;

        public QueryParameter(String name, Object value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public Object getValue() {
            return value;
        }

        @Override
        public String toString() {
            return new StringBuilder()
                    .append(name)
                    .append("=")
                    .append(value)
                    .toString();
        }
        
    }

    public class PathParameter {

        final String name;
        final String value;
        
        public PathParameter(String name) {
            this(name,EMTPY);
        }

        public PathParameter(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public Object getValue() {
            return value;
        }
        
        @Override
        public String toString() {
            if (value.isEmpty()) {
                return name;
            } else {
                return new StringBuilder()
                    .append(name)
                    .append("/")
                    .append(value)
                    .toString();
            }
        }

    }

}
