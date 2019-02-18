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
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class HttpSession {

    private CloseableHttpClient httpClient;
    private ApplicationManager app;

    public HttpSession (ApplicationManager app) {
        this.app = app;
        httpClient = HttpClients.custom().build();

    }

    public String getToken() throws IOException {


        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username", app.getProperty("loginAPI")));
        params.add(new BasicNameValuePair("password", app.getProperty("passwordAPI")));

        String result = post("/api/token-auth/", params);

        JSONObject jsonObj = new JSONObject(result);
        return jsonObj.getJSONObject("access").getString("token");

    }

    public JSONArray getDeleteReasons(String token) throws URISyntaxException, IOException {

        String result = get("api/reference/post_delete_reason/" , token);
        return new JSONArray(result);

    }


    public int getActiveDeleteReasons () throws IOException, URISyntaxException {

        int count = 0;
        boolean deleted = false;

        JSONArray arr = getDeleteReasons(getToken());

        for (int  i = 0; i < arr.length();i++) {

            JSONObject obj = (JSONObject) arr.get(i);
            deleted = obj.getBoolean("is_deleted");

            if (!deleted) {
                count = count + 1;
            }
        }

        return count;
    }

    private String post( String url, List params) throws IOException {

        HttpPost request = new HttpPost(app.getProperty("baseUrlAPI") + url);
        request.setEntity(new UrlEncodedFormEntity(params));
        CloseableHttpResponse response = httpClient.execute(request);
        String result = EntityUtils.toString(response.getEntity());

        return result;
    }

    private String get (String url, String token) throws URISyntaxException, IOException {

        URIBuilder builder = new URIBuilder(app.getProperty("baseUrlAPI") + url);
        HttpGet request = new HttpGet(builder.build());
        request.addHeader("Authorization", "Token " + token);
        CloseableHttpResponse response = httpClient.execute(request);
        String result = EntityUtils.toString(response.getEntity());

        return result;
    }


}


