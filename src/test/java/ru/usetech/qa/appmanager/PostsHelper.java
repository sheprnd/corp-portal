package ru.usetech.qa.appmanager;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PostsHelper extends HttpSession {

    public PostsHelper(ApplicationManager app) {
        super(app);
    }

    // инфа о посте
    private JSONArray getPost(String id) throws Exception {

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("limit","1000"));
        params.add(new BasicNameValuePair("ids", id));

        String result = get("api/posts/" , getToken(), params);
        JSONObject jsonObj =  new JSONObject(result);

        return jsonObj.getJSONArray("results");

    }

    // количество постов с hash проверяемого поста
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

    // есть ли похожие посты для проверяемого поста
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



}
