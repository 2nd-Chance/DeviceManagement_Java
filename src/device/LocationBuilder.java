package device;

public class LocationBuilder {

    private int level = 1;
    private int x = 0;
    private int y = 0;

    protected int getLevel() {
        return level;
    }

    public LocationBuilder setLevel(final int level) {
        this.level = level;
        return this;
    }

    protected int getX() {
        return x;
    }

    public LocationBuilder setX(final int x) {
        this.x = x;
        return this;
    }

    protected int getY() {
        return y;
    }

    public LocationBuilder setY(final int y) {
        this.y = y;
        return this;
    }

    public Location build() {
        Location location = new Location();
        location.setLevel(this.getLevel());
        location.setX(this.getX());
        location.setY(this.getY());
        return location;
    }
}
