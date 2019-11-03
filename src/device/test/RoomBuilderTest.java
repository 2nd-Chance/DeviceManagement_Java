package device.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import device.DeviceBuilder;
import device.DeviceClass1Builder;
import device.DeviceClass2Builder;
import device.DeviceClass3Builder;
import device.DynamicDevice;
import device.LocationBuilder;
import device.Room;
import device.RoomBuilder;
import device.StaticDevice;
import org.junit.Before;
import org.junit.Test;

public class RoomBuilderTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void build() {
        StaticDevice class3Device1 = new DeviceBuilder()
            .setUuid("10")
            .setDeviceClass(new DeviceClass3Builder()
                .build()
            )
            .setBluetoothMac("aa:bb:cc:dd:ee:ff")
            .setRoomId(11)
            .buildStatic();

        StaticDevice class2Device2 = new DeviceBuilder()
            .setUuid("20")
            .setDeviceClass(new DeviceClass2Builder()
                .setSensorType("type")
                .setSensorValue("value")
                .build()
            )
            .setBluetoothMac("ff:ee:dd:cc:bb:aa")
            .setRoomId(22)
            .buildStatic();

        DynamicDevice class1Device3 = new DeviceBuilder()
            .setUuid("30")
            .setDeviceClass(new DeviceClass1Builder()
                .setSensorType("type2")
                .setSensorValue("value2")
                .build()
            )
            .setBluetoothMac("cc:cc:cc:cc:cc:cc")
            .setRoomId(33)
            .buildDynamic();

        Room room = new RoomBuilder()
            .setId(1)
            .setLocation(new LocationBuilder()
                .setLevel(7)
                .setX(5)
                .setY(-5)
                .build()
            )
            .setAlertState(true)
            .setAliveState(false)
            .addLink(2)
            .addLink(3)
            .addStaticDevice(class3Device1)
            .addStaticDevice(class2Device2)
            .addDynamicDevice(class1Device3)
            .build();

        assertEquals("Room[id=1, location=Location[level=7, x=5, y=-5], "
                + "alertState=true, aliveState=false, links=[2, 3], "
                + "staticDevices=[20, 10], dynamicDevices=[30]]",
            room.toString());
    }
}
