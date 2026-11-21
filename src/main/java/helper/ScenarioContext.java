package helper;

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private Map<String, Object> contextMap;

    public ScenarioContext() {
        contextMap = new HashMap<>();
    }

    public <T> void setContext(String key, T value) {
        contextMap.put(key, value);
    }

    public <T> T getContext(String key, Class<T> type) {
        return type.cast(contextMap.get(key));
    }

    public boolean contains(String key) {
        return contextMap.containsKey(key);
    }

    public void clear() {
        contextMap.clear();
    }
}

