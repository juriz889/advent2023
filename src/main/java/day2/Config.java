package day2;

import java.util.Map;

public final class Config {
    private final Map<Color, Integer> config;

    public Config(Map<Color, Integer> config) {
        this.config = config;
    }

    public int getConfig(Color color) {
        return config.get(color);
    }
}
