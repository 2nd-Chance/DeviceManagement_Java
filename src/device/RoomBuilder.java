package device;

public class RoomBuilder {

    private int id;
    private Location location;
    private boolean alertState;
    private boolean aliveState;
    private IntegerSet links;
    private StringSet staticDevices;
    private StringSet dynamicDevices;

    public RoomBuilder() {
        links = new IntegerSet();
        staticDevices = new StringSet();
        dynamicDevices = new StringSet();
    }

    protected int getId() {
        return id;
    }

    public RoomBuilder setId(int id) {
        this.id = id;
        return this;
    }

    protected Location getLocation() {
        return location;
    }

    public RoomBuilder setLocation(final Location location) {
        this.location = location;
        return this;
    }

    protected boolean isAlertState() {
        return alertState;
    }

    public RoomBuilder setAlertState(final boolean alertState) {
        this.alertState = alertState;
        return this;
    }

    protected boolean isAliveState() {
        return aliveState;
    }

    public RoomBuilder setAliveState(final boolean aliveState) {
        this.aliveState = aliveState;
        return this;
    }

    protected IntegerSet getLinks() {
        return links;
    }

    public RoomBuilder setLinks(final IntegerSet links) {
        this.links = links;
        return this;
    }

    public RoomBuilder addLink(final int linkId) {
        this.getLinks().add(linkId);
        return this;
    }

    protected StringSet getStaticDevices() {
        return staticDevices;
    }

    public RoomBuilder setStaticDevices(final StringSet staticDevices) {
        this.staticDevices = staticDevices;
        return this;
    }

    public RoomBuilder addStaticDevice(final StaticDevice staticDevice) {
        this.getStaticDevices().add(staticDevice.getUuid());
        return this;
    }

    protected StringSet getDynamicDevices() {
        return dynamicDevices;
    }

    public RoomBuilder setDynamicDevices(final StringSet dynamicDevices) {
        this.dynamicDevices = dynamicDevices;
        return this;
    }

    public RoomBuilder addDynamicDevice(DynamicDevice dynamicDevice) {
        this.getDynamicDevices().add(dynamicDevice.getUuid());
        return this;
    }

    public Room build() {
        Room room = new Room(this.getId());
        room.setLocation(this.getLocation());
        room.setAlertState(this.isAlertState());
        room.setAliveState(this.isAliveState());
        room.setLinks(this.getLinks());
        room.setStaticDevices(this.getStaticDevices());
        room.setDynamicDevices(this.getDynamicDevices());
        return room;
    }
}
