package device.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import device.DeviceClass3;
import device.DynamicDevice;
import org.junit.Before;
import org.junit.Test;

public class DynamicDeviceTest {

    DynamicDevice dynamicDevice;
    String jsonString;

    @Before
    public void setUp() throws Exception {
        dynamicDevice = new DynamicDevice("10", new DeviceClass3(), "BT", 5);
        jsonString = "{\"id\":\"10\",\"dt\":\"d\",\"cl\":{\"ci\":3,\"ar\":false,\"al\":true},\"bm\":\"BT\",\"rm\":5}";
    }

    @Test
    public void parse() {
        assertEquals(dynamicDevice,
            DynamicDevice.parse(new Gson().fromJson(jsonString, JsonElement.class)));
    }

    @Test
    public void toJson() {
        assertEquals(jsonString, new Gson().toJson(dynamicDevice.toJson()));
    }
}
