package main;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import device.DeviceBuilder;
import device.DeviceClass1Builder;
import device.DeviceClass2Builder;
import device.DeviceClass3Builder;
import device.DynamicDevice;
import device.Location;
import device.Room;
import device.RoomBuilder;
import device.StaticDevice;

public class Main {

    public static void main(String[] args) {
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

        final Gson gson = new Gson();
        final Room room = new RoomBuilder()
            .setId(1)
            .setLocation(new Location(7, 5, -5))
            .setAlertState(true)
            .setAliveState(false)
            .addLink(2).addLink(3)
            .addStaticDevice(class3Device1)
            .addStaticDevice(class2Device2)
            .addDynamicDevice(class1Device3)
            .build();
        System.out.println("\n<ROOM>\n" + room);
        final String jsonString = gson.toJson(room.toJson());
        System.out.println("\n<JSON>\n" + jsonString);

        final JsonElement json = gson.fromJson(jsonString, JsonElement.class);
        final Room parsed = Room.parse(json);
        System.out.println("\n<PARSED>\n" + parsed);
    }

    private static void test1() {
        final String str = "{\"al\":0,\"ar\":1,\"dd\":[\"30\"],\"id\":1,\"lc\":{\"lv\":7,\"x\":5,\"y\":-5},\"lk\":[2,3],\"sd\":[\"10\",\"20\"]}";
        Room room = Room.parse(new Gson().fromJson(str, JsonElement.class));
        System.out.println(room);
    }
}
