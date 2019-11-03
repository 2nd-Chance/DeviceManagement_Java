package device;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.HashSet;

public class StringSet extends HashSet<String> {

    public static StringSet parse(final JsonElement json) {
        final JsonArray jsonArray = json.getAsJsonArray();

        final StringSet set = new StringSet();
        for (int i = 0; i < jsonArray.size(); i++) {
            final String value = jsonArray.get(i).getAsString();
            set.add(value);
        }
        return set;
    }

    public JsonArray toJson() {
        return new Gson().toJsonTree(this).getAsJsonArray();
    }
}
