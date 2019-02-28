package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Config {
    public String url = "";
    public int time = 6;
    public int timeout = 10;

    public static Config load(String path) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            Config config = mapper.readValue(Config.class.getResource(path), Config.class);
            return config;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
