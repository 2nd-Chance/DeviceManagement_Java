package device;

public class DeviceBuilder {

    private String uuid;
    private DeviceClass deviceClass;
    private String bluetoothMac;
    private int roomId = 0;

    protected String getUuid() {
        return uuid;
    }

    public DeviceBuilder setUuid(final String uuid) {
        this.uuid = uuid;
        return this;
    }

    protected DeviceClass getDeviceClass() {
        return deviceClass;
    }

    public DeviceBuilder setDeviceClass(final DeviceClass deviceClass) {
        this.deviceClass = deviceClass;
        return this;
    }

    protected String getBluetoothMac() {
        return bluetoothMac;
    }

    public DeviceBuilder setBluetoothMac(final String bluetoothMac) {
        this.bluetoothMac = bluetoothMac;
        return this;
    }

    protected int getRoomId() {
        return roomId;
    }

    public DeviceBuilder setRoomId(final int roomId) {
        this.roomId = roomId;
        return this;
    }

    public StaticDevice buildStatic() {
        return new StaticDevice(
            this.getUuid(),
            this.getDeviceClass(),
            this.getBluetoothMac(),
            this.getRoomId()
        );
    }

    public DynamicDevice buildDynamic() {
        return new DynamicDevice(
            this.getUuid(),
            this.getDeviceClass(),
            this.getBluetoothMac(),
            this.getRoomId()
        );
    }
}
