package ru.usetech.qa.appmanager;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpSession {

    private CloseableHttpClient httpClient;
    private ApplicationManager app;
    private String baseUrl;

    public HttpSession (ApplicationManager app) {
        this.app = app;
        this.baseUrl = app.getProperty("baseUrlAPI");
        httpClient = HttpClients.custom().build();
    }

    public int post(String url, String token, List params) throws IOException {

        HttpPost request = new HttpPost(baseUrl + url);
        request.setEntity(new UrlEncodedFormEntity(params));
        request.addHeader("Authorization", "Token " + token);
        CloseableHttpResponse response = httpClient.execute(request);
        int code = response.getStatusLine().getStatusCode();

        return code;
    }

    public String get(String url, String token, List params) throws Exception {

        URIBuilder builder = new URIBuilder(baseUrl + url);

        if (params!=null) {
            builder.setParameters(params);
        }

        HttpGet request = new HttpGet(builder.build());
        request.addHeader("Authorization", "Token " + token);
        CloseableHttpResponse response = httpClient.execute(request);
        String result = EntityUtils.toString(response.getEntity());

        return result;
    }

    public String getToken() throws IOException {

        HttpPost request = new HttpPost( baseUrl + "api/token-auth/");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username", app.getProperty("loginAPI")));
        params.add(new BasicNameValuePair("password", app.getProperty("passwordAPI")));
        request.setEntity(new UrlEncodedFormEntity(params));
        CloseableHttpResponse response = httpClient.execute(request);
        String result = EntityUtils.toString(response.getEntity());
        JSONObject jsonObj = new JSONObject(result);
        return jsonObj.getJSONObject("access").getString("token");

    }




}


