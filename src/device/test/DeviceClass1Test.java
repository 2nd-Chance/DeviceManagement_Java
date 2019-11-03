package device.test;

import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import device.DeviceClass1;
import org.junit.Before;
import org.junit.Test;

public class DeviceClass1Test {

    DeviceClass1 deviceClass1;
    String jsonString;

    @Before
    public void setUp() throws Exception {
        deviceClass1 = new DeviceClass1("type1", "value1");
        jsonString = "{\"ci\":1,\"ar\":false,\"al\":true,\"st\":\"type1\",\"sv\":\"value1\"}";
    }

    @Test
    public void parse() {
        assertEquals(deviceClass1,
            DeviceClass1.parse(new Gson().fromJson(jsonString, JsonElement.class)));
    }

    @Test
    public void toJson() {
        assertEquals(jsonString, new Gson().toJson(deviceClass1.toJson()));
    }
}
