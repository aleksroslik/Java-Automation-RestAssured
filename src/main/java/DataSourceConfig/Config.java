package DataSourceConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Config {

    protected static Logger logger = LoggerFactory.getLogger(Config.class);

    private static Config instance;
    private AppConfig appConfig;

    public Config() {
        appConfig = readConfig();
    }

    public static AppConfig getEnvironmentConfig() {
        return getInstance().appConfig;
    }

    private static Config getInstance() {
        if (instance == null) {
            logger.info("Config is null, loading instance of config.");
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
        logger.info("Environment Config loaded from yaml");
        return appConfig;
    }
}
