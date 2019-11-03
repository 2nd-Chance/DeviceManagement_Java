package device;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DeviceClass2 extends DeviceClass3 {

    private String sensorType;
    private String sensorValue;

    public DeviceClass2() {
        this("", "");
    }

    public DeviceClass2(final String sensorType, final String sensorValue) {
        this.setClassId(2);
        this.setSensorType(sensorType);
        this.setSensorValue(sensorValue);
    }

    public enum JsonEnum {
        CLASS_ID("ci"), ALERT_STATE("ar"), ALIVE_STATE("al"),
        SENSOR_TYPE("st"), SENSOR_VALUE("sv");

        private final String string;

        JsonEnum(final String string) {
            this.string = string;
        }

        public String toString() {
            return this.string;
        }
    }

    public static DeviceClass2 parse(final JsonElement json) {
        final JsonObject jsonObject = json.getAsJsonObject();
        final boolean alertState = jsonObject.get(JsonEnum.ALERT_STATE.toString()).getAsBoolean();
        final boolean aliveState = jsonObject.get(JsonEnum.ALIVE_STATE.toString()).getAsBoolean();
        final String sensorType = jsonObject.get(JsonEnum.SENSOR_TYPE.toString()).getAsString();
        final String sensorValue = jsonObject.get(JsonEnum.SENSOR_VALUE.toString()).getAsString();

        final DeviceClass2 deviceClass2 = new DeviceClass2();
        deviceClass2.setAlertState(alertState);
        deviceClass2.setAliveState(aliveState);
        deviceClass2.setSensorType(sensorType);
        deviceClass2.setSensorValue(sensorValue);
        return deviceClass2;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(String sensorValue) {
        this.sensorValue = sensorValue;
    }

    public JsonObject toJson() {
        JsonObject jsonObject = super.toJson();
        jsonObject.addProperty(JsonEnum.SENSOR_TYPE.toString(), this.getSensorType());
        jsonObject.addProperty(JsonEnum.SENSOR_VALUE.toString(), this.getSensorValue());
        return jsonObject;
    }
}
