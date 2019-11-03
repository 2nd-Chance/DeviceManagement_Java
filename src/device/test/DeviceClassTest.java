package device.test;

import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import device.DeviceClass;
import device.DeviceClass1;
import device.DeviceClass2;
import device.DeviceClass3;
import org.junit.Before;
import org.junit.Test;

public class DeviceClassTest {

    private DeviceClass deviceClass1;
    private String jsonString1;
    private DeviceClass deviceClass2;
    private String jsonString2;
    private DeviceClass deviceClass3;
    private String jsonString3;

    @Before
    public void setUp() throws Exception {
        deviceClass1 = new DeviceClass1("t1", "v1");
        deviceClass2 = new DeviceClass2("t2", "v2");
        deviceClass2.setAlertState(true);
        deviceClass3 = new DeviceClass3();
        deviceClass3.setAliveState(false);
        deviceClass3.setAlertState(true);

        jsonString1 = "{\"ci\":1,\"ar\":false,\"al\":true,\"st\":\"t1\",\"sv\":\"v1\"}";
        jsonString2 = "{\"ci\":2,\"ar\":true,\"al\":true,\"st\":\"t2\",\"sv\":\"v2\"}";
        jsonString3 = "{\"ci\":3,\"ar\":true,\"al\":false}";
    }

    @Test
    public void parse() {
        assertEquals(deviceClass1,
            DeviceClass.parse(new Gson().fromJson(jsonString1, JsonElement.class)));
        assertEquals(deviceClass2,
            DeviceClass.parse(new Gson().fromJson(jsonString2, JsonElement.class)));
        assertEquals(deviceClass3,
            DeviceClass.parse(new Gson().fromJson(jsonString3, JsonElement.class)));
    }

    @Test
    public void toJson() {
        assertEquals(jsonString1, new Gson().toJson(deviceClass1.toJson()));
        assertEquals(jsonString2, new Gson().toJson(deviceClass2.toJson()));
        assertEquals(jsonString3, new Gson().toJson(deviceClass3.toJson()));
    }
}
