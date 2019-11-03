package device.test;

import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import device.DeviceClass3;
import org.junit.Before;
import org.junit.Test;

public class DeviceClass3Test {

    private DeviceClass3 deviceClass3;
    private String jsonString;

    @Before
    public void setUp() throws Exception {
        deviceClass3 = new DeviceClass3();
        deviceClass3.setAlertState(true);
        deviceClass3.setAliveState(false);
        jsonString = "{\"ci\":3,\"ar\":true,\"al\":false}";
    }

    @Test
    public void parse() {
        assertEquals(deviceClass3,
            DeviceClass3.parse(new Gson().fromJson(jsonString, JsonElement.class)));
    }

    @Test
    public void toJson() {
        assertEquals(jsonString, new Gson().toJson(deviceClass3.toJson()));
    }
}
