package device;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.HashSet;

public class IntegerSet extends HashSet<Integer> {

    public static IntegerSet parse(final JsonElement json) {
        final JsonArray jsonArray = json.getAsJsonArray();

        final IntegerSet set = new IntegerSet();
        for (int i = 0; i < jsonArray.size(); i++) {
            final int value = jsonArray.get(i).getAsInt();
            set.add(value);
        }
        return set;
    }

    public JsonArray toJson() {
        return new Gson().toJsonTree(this).getAsJsonArray();
    }
}
