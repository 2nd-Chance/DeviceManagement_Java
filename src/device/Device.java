package device;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Objects;
import java.util.StringJoiner;

public class Device {

    private String uuid;
    private String deviceType;
    private DeviceClass deviceClass;
    private String bluetoothMac;
    private int roomId;

    protected Device(final String uuid, final DeviceClass deviceClass) {
        this(uuid, deviceClass, "");
    }

    protected Device(final String uuid, final DeviceClass deviceClass,
        final String bluetoothMac) {

        this(uuid, deviceClass, bluetoothMac, 0);
    }

    protected Device(final String uuid, final DeviceClass deviceClass,
        final String bluetoothMac, int roomId) {

        this.setUuid(uuid);
        this.setDeviceClass(deviceClass);
        this.setBluetoothMac(bluetoothMac);
        this.setRoomId(roomId);
    }

    public static Device parse(final JsonElement json) {
        final JsonObject jsonObject = json.getAsJsonObject();
        final String deviceType = jsonObject.get(JsonEnum.DEVICE_TYPE.toString()).getAsString();

        if (deviceType.equals("s")) {
            return StaticDevice.parse(json);
        } else if (deviceType.equals("d")) {
            return DynamicDevice.parse(json);
        } else {
            return null;
        }
    }

    public enum JsonEnum {
        UUID("id"), DEVICE_TYPE("dt"), DEVICE_CLASS("cl"), BLUETOOTH_MAC("bm"), ROOM_ID("rm");

        private final String string;

        JsonEnum(final String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return this.string;
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Device)) {
            return false;
        }
        Device device = (Device) o;
        return Objects.equals(uuid, device.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Device.class.getSimpleName() + "[", "]")
            .add("uuid='" + uuid + "'")
            .add("deviceType='" + deviceType + "'")
            .add("deviceClass=" + deviceClass)
            .add("bluetoothMac='" + bluetoothMac + "'")
            .add("roomId=" + roomId)
            .toString();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(final String deviceType) {
        this.deviceType = deviceType;
    }

    public DeviceClass getDeviceClass() {
        return deviceClass;
    }

    protected void setDeviceClass(final DeviceClass deviceClass) {
        if (deviceClass == null) {
            throw new NullPointerException("Device class cannot be null");
        }

        this.deviceClass = deviceClass;
    }

    public String getBluetoothMac() {
        return bluetoothMac;
    }

    public void setBluetoothMac(final String bluetoothMac) {
        this.bluetoothMac = bluetoothMac;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(final int roomId) {
        this.roomId = roomId;
    }

    public JsonObject toJson() {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(JsonEnum.UUID.toString(), this.getUuid());
        jsonObject.addProperty(JsonEnum.DEVICE_TYPE.toString(), this.getDeviceType());
        jsonObject.add(JsonEnum.DEVICE_CLASS.toString(), this.getDeviceClass().toJson());
        jsonObject.addProperty(JsonEnum.BLUETOOTH_MAC.toString(), this.getBluetoothMac());
        jsonObject.addProperty(JsonEnum.ROOM_ID.toString(), this.getRoomId());
        return jsonObject;
    }
}
