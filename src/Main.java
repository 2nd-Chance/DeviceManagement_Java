import com.google.gson.Gson;
import com.google.gson.JsonElement;
import device.Room;

public class Main {

    public static void main(String[] args) {
        final String str = "{\"al\":0,\"ar\":1,\"dd\":[\"30\"],\"id\":1,\"lc\":{\"lv\":7,\"x\":5,\"y\":-5},\"lk\":[2,3],\"sd\":[\"10\",\"20\"]}";
        Room room = Room.parse(new Gson().fromJson(str, JsonElement.class));
        System.out.println(room);
    }
}
