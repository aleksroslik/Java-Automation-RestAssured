package DataSourceConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class Config {

    private static Config instance;
    private AppConfig appConfig;

    public Config() {
        appConfig = readConfig();
    }

    public static AppConfig getAppConfig() {
        return getInstance().appConfig;
    }

    private static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    private AppConfig readConfig() {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            this.appConfig = mapper.readValue(new File("src/main/resources/properties.yaml"), AppConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appConfig;
    }
}
