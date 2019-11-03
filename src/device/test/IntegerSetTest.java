package device.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import device.IntegerSet;
import org.junit.Before;
import org.junit.Test;

public class IntegerSetTest {

    private IntegerSet integerSet;
    private String jsonString;

    @Before
    public void setUp() throws Exception {
        integerSet = new IntegerSet();
        integerSet.add(10);
        integerSet.add(20);
        integerSet.add(30);
        jsonString = "[20,10,30]";
    }

    @org.junit.Test
    public void parse() {
        assertEquals(integerSet,
            IntegerSet.parse(new Gson().fromJson(jsonString, JsonElement.class)));
    }

    @org.junit.Test
    public void toJson() {
        assertEquals(jsonString, new Gson().toJson(integerSet.toJson()));
    }
}
