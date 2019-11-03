package device.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import device.Location;
import org.junit.Before;
import org.junit.Test;

public class LocationTest {

    Location location;
    String jsonString;

    @Before
    public void setUp() throws Exception {
        location = new Location(10, 20, 30);
        jsonString = "{\"lv\":10,\"x\":20,\"y\":30}";
    }

    @Test
    public void parse() {
        assertEquals(location,
            Location.parse(new Gson().fromJson(jsonString, JsonElement.class)));
    }

    @Test
    public void toJson() {
        assertEquals(jsonString, new Gson().toJson(location.toJson()));
    }
}
