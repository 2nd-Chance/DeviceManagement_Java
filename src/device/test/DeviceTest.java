package device.test;

import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import device.Device;
import device.DeviceClass;
import device.DeviceClass1;
import device.DeviceClass3;
import device.DynamicDevice;
import device.StaticDevice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeviceTest {

    private StaticDevice staticDevice;
    private String jsonStringStatic;
    private DynamicDevice dynamicDevice;
    private String jsonStringDynamic;

    @Before
    public void setUp() {
        DeviceClass deviceClass1 = new DeviceClass1("type", "value");
        DeviceClass deviceClass3 = new DeviceClass3();
        staticDevice = new StaticDevice("uuid1", deviceClass1, "bt1", 1);
        dynamicDevice = new DynamicDevice("uuid2", deviceClass3, "bt2", 2);

        jsonStringStatic = "{\"id\":\"uuid1\",\"dt\":\"s\",\"cl\":{\"ci\":1,\"ar\":0,\"al\":1,\"st\":\"type\",\"sv\":\"value\"},\"bm\":\"bt1\",\"rm\":1}";
        jsonStringDynamic = "{\"id\":\"uuid2\",\"dt\":\"d\",\"cl\":{\"ci\":3,\"ar\":0,\"al\":1},\"bm\":\"bt2\",\"rm\":2}";
    }

    @Test
    public void parse() {
        Assert.assertEquals(staticDevice,
            Device.parse(new Gson().fromJson(jsonStringStatic, JsonElement.class)));
        assertEquals(dynamicDevice,
            Device.parse(new Gson().fromJson(jsonStringDynamic, JsonElement.class)));
    }

    @Test
    public void toJson() {
        assertEquals(jsonStringStatic, new Gson().toJson(staticDevice.toJson()));
        assertEquals(jsonStringDynamic, new Gson().toJson(dynamicDevice.toJson()));
    }
}
