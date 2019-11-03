package device;

public abstract class DeviceClassBuilder {

    private boolean alertState = false;
    private boolean aliveState = true;

    public boolean isAlertState() {
        return alertState;
    }

    public DeviceClassBuilder setAlertState(final boolean alertState) {
        this.alertState = alertState;
        return this;
    }

    public boolean isAliveState() {
        return aliveState;
    }

    public DeviceClassBuilder setAliveState(final boolean aliveState) {
        this.aliveState = aliveState;
        return this;
    }

    public abstract DeviceClass build();
}
