package device;

public class DeviceClass1Builder extends DeviceClass2Builder {

    @Override
    public DeviceClass1 build() {
        DeviceClass1 deviceClass1 = new DeviceClass1();
        deviceClass1.setAlertState(this.isAlertState());
        deviceClass1.setAliveState(this.isAliveState());
        deviceClass1.setSensorType(this.getSensorType());
        deviceClass1.setSensorValue(this.getSensorValue());
        return deviceClass1;
    }
}
