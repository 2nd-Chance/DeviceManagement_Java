package device.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import device.DeviceClass2;
import device.StaticDevice;
import org.junit.Before;
import org.junit.Test;

public class StaticDeviceTest {

    StaticDevice staticDevice;
    String jsonString;

    @Before
    public void setUp() throws Exception {
        staticDevice = new StaticDevice("10", new DeviceClass2(), "BT", 5);
        jsonString = "{\"id\":\"10\",\"dt\":\"s\",\"cl\":{\"ci\":2,\"ar\":false,\"al\":true,\"st\":\"\",\"sv\":\"\"},\"bm\":\"BT\",\"rm\":5}";
    }

    @Test
    public void parse() {
        assertEquals(staticDevice,
            StaticDevice.parse(new Gson().fromJson(jsonString, JsonElement.class)));
    }

    @Test
    public void toJson() {
        assertEquals(jsonString, new Gson().toJson(staticDevice.toJson()));
    }
}
