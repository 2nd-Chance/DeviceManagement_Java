package device;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class DeviceClass {

    private int classId = 0;
    private boolean alertState = false;
    private boolean aliveState = true;

    protected DeviceClass() {
    }

    public enum JsonEnum {
        CLASS_ID("ci"), ALERT_STATE("ar"), ALIVE_STATE("al");

        private final String string;

        JsonEnum(final String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return this.string;
        }
    }

    public static DeviceClass parse(final JsonElement json) {
        final JsonObject jsonObject = json.getAsJsonObject();
        int classID = jsonObject.get(JsonEnum.CLASS_ID.toString()).getAsInt();

        if (classID == 1) {
            return DeviceClass1.parse(json);
        } else if (classID == 2) {
            return DeviceClass2.parse(json);
        } else if (classID == 3) {
            return DeviceClass3.parse(json);
        } else {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeviceClass)) {
            return false;
        }
        DeviceClass that = (DeviceClass) o;
        return classId == that.classId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DeviceClass.class.getSimpleName() + "[", "]")
            .add("classID=" + classId)
            .add("alertState=" + alertState)
            .add("aliveState=" + aliveState)
            .toString();
    }

    public int getClassId() {
        return classId;
    }

    protected void setClassId(final int classId) {
        this.classId = classId;
    }

    public boolean isAlertState() {
        return alertState;
    }

    public void setAlertState(final boolean alertState) {
        this.alertState = alertState;
    }

    public boolean isAliveState() {
        return aliveState;
    }

    public void setAliveState(final boolean aliveState) {
        this.aliveState = aliveState;
    }

    public abstract JsonObject toJson();
}
