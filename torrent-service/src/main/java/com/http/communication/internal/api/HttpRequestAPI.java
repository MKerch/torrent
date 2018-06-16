/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.http.communication.internal.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class HttpRequestAPI {

    private HttpRequestBase req;
    private List<NameValuePair> params = new ArrayList<NameValuePair>();
    private DefaultHttpClient client;

    private HttpRequestAPI(HttpRequestBase req, Cookie[] cookies) {
        this.req = req;
        client = new DefaultHttpClient();
        for (Cookie c : cookies) {
            client.getCookieStore().addCookie(c);
        }
    }

    public void addParameter(String name, String value) {
        params.add(new BasicNameValuePair(name, value));
    }

    public String connect() {
        try {
            HttpEntity content = new UrlEncodedFormEntity(params, "windows-1251");
            if (req instanceof HttpPost) {
                ((HttpPost) req).setEntity(content);
            } else if (req instanceof HttpGet) {
                //пока ничего не делаем
            }
            HttpResponse clientResp = client.execute(req);
            StringBuilder page = new StringBuilder();
            int v = -1;
            InputStream in = clientResp.getEntity().getContent();
            do {
                v = in.read();
                if (v >= 0) {
                    page.append(new String(new byte[]{(byte) v}, "windows-1251"));
                }
            } while (v >= 0);
            req.abort();
            return page.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Cookie> getCookies() {
        List<Cookie> cookies = client.getCookieStore().getCookies();
        return cookies;
    }

    public static HttpRequestAPI getGetRequest(String href, Cookie... cookies) {
        HttpGet req = new HttpGet(href);
        return new HttpRequestAPI(req, cookies);
    }

    public static HttpRequestAPI getPostRequest(String href, Cookie... cookies) {
        HttpPost req = new HttpPost(href);
        return new HttpRequestAPI(req, cookies);
    }

}
