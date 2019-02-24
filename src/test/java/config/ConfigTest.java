package config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {

    @Test
    void load() {
        Config config= Config.load("/config/config.yaml");
        assert config != null;
        System.out.println(config.url);
    }
}