package ru.usetech.qa.appmanager;

import org.json.JSONArray;
import org.json.JSONObject;

public class SettingsHelper extends HttpSession{

    public SettingsHelper(ApplicationManager app) {
        super(app);
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
}
