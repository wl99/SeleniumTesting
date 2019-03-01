package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class Config {
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public ElementConfig getElementConfig() {
        return elementConfig;
    }

    public void setElementConfig(ElementConfig elementConfig) {
        this.elementConfig = elementConfig;
    }

    public String url = "";
    public int time = 6;
    public int timeout = 10;
    public ElementConfig elementConfig = new ElementConfig();


    public static void write(String filePath) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            mapper.writeValue(new File(filePath), new Config());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Config load(String filePath) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Config conf = new Config();
        try {
            conf = mapper.readValue(Config.class.getResource(filePath), Config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conf;
    }

//    public static Config load(String path) {
//        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        try {
//            Config config = mapper.readValue(Config.class.getResource(path), Config.class);
//            return config;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
