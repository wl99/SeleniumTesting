package config;

import org.junit.jupiter.api.Test;

class ConfigTest {

    @Test
    void load() {
        Config config= Config.load("/config/config.yaml");
        assert config != null;
        System.out.println(config.baseUrl);
        System.out.println(config.getRemoteUrl());
        System.out.println(config.elementConfig.NAVBAR.get("searchInput"));
    }
}