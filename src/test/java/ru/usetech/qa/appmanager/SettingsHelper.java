package ru.usetech.qa.appmanager;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SettingsHelper extends HttpSession{

    public SettingsHelper(ApplicationManager app) {
        super(app);
    }

    //================== отделы ============================================//

    // количество неудаленных отделов
    public int getActiveDepartmentsCount() throws Exception {
        return getDepartments().length();
    }

    // все неудаленные отделы
    private JSONArray getDepartments() throws Exception {
        String result = get("api/accounts/departments/" , getToken(), null);
        return new JSONArray(result);
    }

    //================== причины удаления =================================//

    // все причины удаления
    private JSONArray getDeleteReasons() throws Exception {

        String result = get("api/reference/post_delete_reason/" , getToken(), null);
        return new JSONArray(result);

    }

    // количество неудаленных причин удаления
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

    //================= пользовательские справочники инцидента =======================//

    private JSONArray getActiveClientReference() throws Exception {

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("ref_type","1"));

        String result = get("api/reference/client_reference_title/" , getToken(), params);
        return new JSONArray(result);

    }

    public int getClientReferenceIndex(String name) throws Exception {

        JSONArray arr = getActiveClientReference();

        for (int  i = 0; i < arr.length();i++) {

            JSONObject obj = (JSONObject) arr.get(i);
            String title = obj.getString("title");

            if (title.equals(name)) {
                return i;
            }
        }

        return -1;

    }
}
