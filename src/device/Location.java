package device;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Objects;
import java.util.StringJoiner;

public class Location {

    private int level = 1;
    private int x = 0;
    private int y = 0;

    public Location() {
        this(0, 0);
    }

    public Location(final int x, final int y) {
        this(1, x, y);
    }

    public Location(final int level, final int x, final int y) {
        this.setLevel(level);
        this.setX(x);
        this.setY(y);
    }

    public enum JsonEnum {
        LEVEL("lv"), X("x"), Y("y");

        private final String string;

        JsonEnum(final String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return this.string;
        }
    }

    public static Location parse(final JsonElement json) {
        final JsonObject jsonObject = json.getAsJsonObject();
        final int level = jsonObject.get(JsonEnum.LEVEL.toString()).getAsInt();
        final int x = jsonObject.get(JsonEnum.X.toString()).getAsInt();
        final int y = jsonObject.get(JsonEnum.Y.toString()).getAsInt();
        return new Location(level, x, y);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location = (Location) o;
        return level == location.level &&
            x == location.x &&
            y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, x, y);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Location.class.getSimpleName() + "[", "]")
            .add("level=" + level)
            .add("x=" + x)
            .add("y=" + y)
            .toString();
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(final int level) {
        if (level == 0) {
            throw new RuntimeException("Level cannot be set to 0.");
        }
        this.level = level;
    }

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public JsonObject toJson() {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(JsonEnum.LEVEL.toString(), this.getLevel());
        jsonObject.addProperty(JsonEnum.X.toString(), this.getX());
        jsonObject.addProperty(JsonEnum.Y.toString(), this.getY());
        return jsonObject;
    }
}
