package device.test;

import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import device.DeviceClass2;
import org.junit.Before;
import org.junit.Test;

public class DeviceClass2Test {

    private DeviceClass2 deviceClass2;
    private String jsonString;

    @Before
    public void setUp() throws Exception {
        deviceClass2 = new DeviceClass2("type", "value");
        deviceClass2.setAliveState(false);
        jsonString = "{\"ci\":2,\"ar\":false,\"al\":false,\"st\":\"type\",\"sv\":\"value\"}";
    }

    @Test
    public void parse() {
        assertEquals(deviceClass2,
            DeviceClass2.parse(new Gson().fromJson(jsonString, JsonElement.class)));
    }

    @Test
    public void toJson() {
        assertEquals(jsonString, new Gson().toJson(deviceClass2.toJson()));
    }
}
