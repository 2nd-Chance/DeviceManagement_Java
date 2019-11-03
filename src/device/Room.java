package device;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Objects;
import java.util.StringJoiner;

public class Room {

    private int id;
    private Location location;
    private boolean alertState;
    private boolean aliveState;
    private IntegerSet links;
    private StringSet staticDevices;
    private StringSet dynamicDevices;

    public Room(final int id) {
        this(id, new Location());
    }

    public Room(final int id, final Location location) {
        this(id, location, false, true);
    }

    public Room(final int id, final Location location, final boolean alertState,
        final boolean aliveState) {
        this.setId(id);
        this.setLocation(location);
        this.setAlertState(alertState);
        this.setAliveState(aliveState);

        this.setLinks(new IntegerSet());
        this.setStaticDevices(new StringSet());
        this.setDynamicDevices(new StringSet());
    }

    public enum JsonEnum {
        ID("id"), LOCATION("lc"), ALERT_STATE("ar"), ALIVE_STATE("al"),
        LINKS("lk"), STATIC_DEVICE("sd"), DYNAMIC_DEVICE("dd");

        private final String string;

        JsonEnum(final String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return this.string;
        }

    }

    public static Room parse(final JsonElement json) {
        final JsonObject jsonObject = json.getAsJsonObject();
        final int id = jsonObject.get(JsonEnum.ID.toString()).getAsInt();
        final Location location = Location.parse(jsonObject.get(JsonEnum.LOCATION.toString()));
        final boolean alertState = jsonObject.get(JsonEnum.ALERT_STATE.toString()).getAsBoolean();
        final boolean aliveState = jsonObject.get(JsonEnum.ALIVE_STATE.toString()).getAsBoolean();
        final IntegerSet links = IntegerSet.parse(jsonObject.get(JsonEnum.LINKS.toString()));
        final StringSet staticDevices
            = StringSet.parse(jsonObject.get(JsonEnum.STATIC_DEVICE.toString()));
        final StringSet dynamicDevices
            = StringSet.parse(jsonObject.get(JsonEnum.DYNAMIC_DEVICE.toString()));

        final Room room = new Room(id, location, alertState, aliveState);
        room.setLinks(links);
        room.setStaticDevices(staticDevices);
        room.setDynamicDevices(dynamicDevices);
        return room;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        return id == room.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Room.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("location=" + location)
            .add("alertState=" + alertState)
            .add("aliveState=" + aliveState)
            .add("links=" + links)
            .add("staticDevices=" + staticDevices)
            .add("dynamicDevices=" + dynamicDevices)
            .toString();
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    protected void setLocation(final Location location) {
        this.location = location;
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

    public IntegerSet getLinks() {
        return links;
    }

    protected void setLinks(final IntegerSet links) {
        this.links = links;
    }

    public StringSet getStaticDevices() {
        return staticDevices;
    }

    protected void setStaticDevices(final StringSet staticDevices) {
        this.staticDevices = staticDevices;
    }

    public StringSet getDynamicDevices() {
        return dynamicDevices;
    }

    protected void setDynamicDevices(final StringSet dynamicDevices) {
        this.dynamicDevices = dynamicDevices;
    }

    public JsonObject toJson() {
        final JsonObject json = new JsonObject();
        json.addProperty(JsonEnum.ID.toString(), this.getId());
        json.add(JsonEnum.LOCATION.toString(), this.getLocation().toJson());
        json.addProperty(JsonEnum.ALERT_STATE.toString(), this.isAlertState());
        json.addProperty(JsonEnum.ALIVE_STATE.toString(), this.isAliveState());
        json.add(JsonEnum.LINKS.toString(), this.getLinks().toJson());
        json.add(JsonEnum.STATIC_DEVICE.toString(), this.getStaticDevices().toJson());
        json.add(JsonEnum.DYNAMIC_DEVICE.toString(), this.getDynamicDevices().toJson());
        return json;
    }
}
