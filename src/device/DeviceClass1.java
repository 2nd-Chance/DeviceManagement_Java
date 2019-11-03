package device;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DeviceClass1 extends DeviceClass2 {

    public DeviceClass1() {
        this("", "");
    }

    public DeviceClass1(final String sensorType, final String sensorValue) {
        super(sensorType, sensorValue);
        this.setClassId(1);
    }

    public static DeviceClass1 parse(final JsonElement json) {
        final JsonObject jsonObject = json.getAsJsonObject();
        final boolean alertState = jsonObject.get(JsonEnum.ALERT_STATE.toString()).getAsBoolean();
        final boolean aliveState = jsonObject.get(JsonEnum.ALIVE_STATE.toString()).getAsBoolean();
        final String sensorType = jsonObject.get(JsonEnum.SENSOR_TYPE.toString()).getAsString();
        final String sensorValue = jsonObject.get(JsonEnum.SENSOR_VALUE.toString()).getAsString();

        final DeviceClass1 deviceClass1 = new DeviceClass1();
        deviceClass1.setAlertState(alertState);
        deviceClass1.setAliveState(aliveState);
        deviceClass1.setSensorType(sensorType);
        deviceClass1.setSensorValue(sensorValue);
        return deviceClass1;
    }

    public JsonObject toJson() {
        return super.toJson();
    }
}
