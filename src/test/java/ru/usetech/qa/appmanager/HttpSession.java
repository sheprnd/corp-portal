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
import java.util.ArrayList;
import java.util.List;

public class HttpSession {

    private CloseableHttpClient httpClient;
    private ApplicationManager app;

    public HttpSession (ApplicationManager app) {
        this.app = app;
        httpClient = HttpClients.custom().build();

    }

    private String post(String url, List params) throws IOException {

        HttpPost request = new HttpPost(app.getProperty("baseUrlAPI") + url);
        request.setEntity(new UrlEncodedFormEntity(params));
        CloseableHttpResponse response = httpClient.execute(request);
        String result = EntityUtils.toString(response.getEntity());

        return result;
    }

    private String get(String url, String token, List params) throws Exception {

        URIBuilder builder = new URIBuilder(app.getProperty("baseUrlAPI") + url);

        if (params!=null) {
            builder.setParameters(params);
        }

        HttpGet request = new HttpGet(builder.build());
        request.addHeader("Authorization", "Token " + token);
        CloseableHttpResponse response = httpClient.execute(request);
        String result = EntityUtils.toString(response.getEntity());

        return result;
    }

    private String getToken() throws IOException {


        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username", app.getProperty("loginAPI")));
        params.add(new BasicNameValuePair("password", app.getProperty("passwordAPI")));

        String result = post("/api/token-auth/", params);

        JSONObject jsonObj = new JSONObject(result);
        return jsonObj.getJSONObject("access").getString("token");

    }

    private JSONArray getDeleteReasons() throws Exception {

        String result = get("api/reference/post_delete_reason/" , getToken(), null);
        return new JSONArray(result);

    }


    public int getActiveDeleteReasons () throws Exception {

        int count = 0;
        boolean deleted = false;

        JSONArray arr = getDeleteReasons();

        for (int  i = 0; i < arr.length();i++) {

            JSONObject obj = (JSONObject) arr.get(i);
            deleted = obj.getBoolean("is_deleted");

            if (!deleted) {
                count = count + 1;
            }
        }

        return count;
    }

    public boolean areSimilarPostsExists(String id) throws Exception {

        JSONArray arr = getPost(id);

        if (arr.length() > 0) {

            JSONObject obj = (JSONObject) arr.get(0);

            if (!obj.isNull("hash")) {

                String hash = obj.getString("hash");
                int count = getSimilarPosts(id, hash);

                if (count > 0) {
                    return true;
                } else {
                    return false;
                }

            } else {

                 return false;
            }

        } else {

            return false;
        }

    }

    private int getSimilarPosts(String id, String hash) throws Exception {

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("page","1"));
        params.add(new BasicNameValuePair("page_size", "1"));
        params.add(new BasicNameValuePair("state","1"));
        params.add(new BasicNameValuePair("hash", hash));
        params.add(new BasicNameValuePair("id__ne", id));

        String result = get("api/posts/" , getToken(), params);
        JSONObject jsonObj =  new JSONObject(result);

        return jsonObj.getInt("count");

    }

    private JSONArray getPost(String id) throws Exception {

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("limit","1000"));
        params.add(new BasicNameValuePair("ids", id));

        String result = get("api/posts/" , getToken(), params);
        JSONObject jsonObj =  new JSONObject(result);

        return jsonObj.getJSONArray("results");

    }
}


