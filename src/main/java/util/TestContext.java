package util;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private final Map<String, Object> current = new HashMap<>();

    public Object getContext(String key) {
        return current.get(key);
    }

    public void setContext(String key, Object value) {
        this.current.put(key,value);
    }
}
