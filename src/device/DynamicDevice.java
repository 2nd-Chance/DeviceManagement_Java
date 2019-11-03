package device;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DynamicDevice extends Device {

    public DynamicDevice(final String uuid, final DeviceClass deviceClass) {
        this(uuid, deviceClass, "");
    }

    public DynamicDevice(final String uuid, final DeviceClass deviceClass,
        final String bluetoothMac) {

        this(uuid, deviceClass, bluetoothMac, 0);
    }

    public DynamicDevice(final String uuid, final DeviceClass deviceClass,
        final String bluetoothMac, final int roomId) {

        super(uuid, deviceClass, bluetoothMac, roomId);
        this.setDeviceType("d");
    }

    public static DynamicDevice parse(final JsonElement json) {
        final JsonObject jsonObject = json.getAsJsonObject();
        final String uuid
            = jsonObject.get(JsonEnum.UUID.toString()).getAsString();
        final DeviceClass deviceClass
            = DeviceClass.parse(jsonObject.get(JsonEnum.DEVICE_CLASS.toString()));
        final String bluetooth
            = jsonObject.get(JsonEnum.BLUETOOTH_MAC.toString()).getAsString();
        final int roomId
            = jsonObject.get(JsonEnum.ROOM_ID.toString()).getAsInt();
        return new DynamicDevice(uuid, deviceClass, bluetooth, roomId);
    }
}
