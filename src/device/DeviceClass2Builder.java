package device;

public class DeviceClass2Builder extends DeviceClass3Builder {

    private String sensorType;
    private String sensorValue;

    protected String getSensorType() {
        return sensorType;
    }

    public DeviceClass2Builder setSensorType(String sensorType) {
        this.sensorType = sensorType;
        return this;
    }

    protected String getSensorValue() {
        return sensorValue;
    }

    public DeviceClass2Builder setSensorValue(String sensorValue) {
        this.sensorValue = sensorValue;
        return this;
    }

    @Override
    public DeviceClass2 build() {
        DeviceClass2 deviceClass2 = new DeviceClass2();
        deviceClass2.setAlertState(this.isAlertState());
        deviceClass2.setAliveState(this.isAliveState());
        deviceClass2.setSensorType(this.getSensorType());
        deviceClass2.setSensorValue(this.getSensorValue());
        return deviceClass2;
    }
}
