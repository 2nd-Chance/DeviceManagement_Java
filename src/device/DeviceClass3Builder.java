package device;

public class DeviceClass3Builder extends DeviceClassBuilder {

    @Override
    public DeviceClass build() {
        DeviceClass3 deviceClass3 = new DeviceClass3();
        deviceClass3.setAlertState(this.isAlertState());
        deviceClass3.setAliveState(this.isAliveState());
        return deviceClass3;
    }
}
