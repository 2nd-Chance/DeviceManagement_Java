package device.test;

import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import device.DeviceClass1;
import device.DeviceClass2;
import device.DeviceClass3;
import device.DynamicDevice;
import device.Location;
import device.Room;
import device.StaticDevice;
import org.junit.Before;

public class RoomTest {

    private Room room;
    private String jsonString;

    @Before
    public void setUp() throws Exception {
        DeviceClass3 deviceClass3 = new DeviceClass3();
        StaticDevice device1 = new StaticDevice("10", deviceClass3);
        device1.setBluetoothMac("aa:bb:cc:dd:ee:ff");
        device1.setRoomId(11);

        DeviceClass2 deviceClass2 = new DeviceClass2("type", "value");
        StaticDevice device2 = new StaticDevice("20", deviceClass2);
        device2.setBluetoothMac("ff:ee:dd:cc:bb:aa");
        device2.setRoomId(22);

        DeviceClass1 deviceClass1 = new DeviceClass1("type2", "value2");
        DynamicDevice device3 = new DynamicDevice("30", deviceClass1);
        device1.setBluetoothMac("cc:cc:cc:cc:cc:cc");
        device1.setRoomId(33);

        final Location location = new Location(7, 5, -5);
        room = new Room(10, location, true, false);
        room.getLinks().add(2);
        room.getLinks().add(3);
        room.getStaticDevices().add(device1.getUuid());
        room.getStaticDevices().add(device2.getUuid());
        room.getStaticDevices().add(device3.getUuid());

        jsonString = "{\"id\":10,\"lc\":{\"lv\":7,\"x\":5,\"y\":-5},\"ar\":true,\"al\":false,\"lk\":[2,3],\"sd\":[\"30\",\"20\",\"10\"],\"dd\":[]}";
    }

    @org.junit.Test
    public void parse() {
        assertEquals(room,
            Room.parse(new Gson().fromJson(jsonString, JsonElement.class)));
    }

    @org.junit.Test
    public void toJson() {
        assertEquals(jsonString, new Gson().toJson(room.toJson()));
    }
}
