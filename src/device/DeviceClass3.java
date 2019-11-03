package device;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DeviceClass3 extends DeviceClass {

    public DeviceClass3() {
        this.setClassId(3);
    }

    public static DeviceClass3 parse(final JsonElement json) {
        final JsonObject jsonObject = json.getAsJsonObject();
        final boolean alertState = jsonObject.get(JsonEnum.ALERT_STATE.toString()).getAsBoolean();
        final boolean aliveState = jsonObject.get(JsonEnum.ALIVE_STATE.toString()).getAsBoolean();

        final DeviceClass3 deviceClass3 = new DeviceClass3();
        deviceClass3.setAlertState(alertState);
        deviceClass3.setAliveState(aliveState);
        return deviceClass3;
    }

    @Override
    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(JsonEnum.CLASS_ID.toString(), this.getClassId());
        jsonObject.addProperty(JsonEnum.ALERT_STATE.toString(), this.isAlertState());
        jsonObject.addProperty(JsonEnum.ALIVE_STATE.toString(), this.isAliveState());
        return jsonObject;
    }
}
