package org.solvd.persistance;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum Config {

    URL("url"),
    DRIVER("driver"),
    USERNAME("username"),
    PASSWORD("password"),
    POOL_SIZE("poolSize", String.valueOf(1));

    private static final String CONFIG_FILE_NAME = "config.properties";
    private static final Properties PROPERTIES;

    static {
        PROPERTIES = loadProperties();
    }

    private final String key;
    private String defaultVal;

    Config(String key, String defaultVal) {
        this(key);
        this.defaultVal = defaultVal;
    }

    Config(String key) {
        this.key = key;
    }

    public String getValue() {
        return PROPERTIES.getProperty(key, defaultVal);
    }

    private static Properties loadProperties() {
        Properties config = new Properties();

        try {
            InputStream conf = Config.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
            config.load(conf);
        } catch (IOException e) {
            throw new RuntimeException("Could not prepare config properties", e);
        }
        return config;
    }
}
