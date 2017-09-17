package com.githubapi.client.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesCache {
    private static final PropertiesCache INSTANCE = new PropertiesCache();
    private final Properties propConfig = new Properties();

    private PropertiesCache() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("api.properties");
        try {
            propConfig.load(in);
        } catch (IOException e) {
            System.out.println("Cannot read properties from config file. Exception: " + e);
        }
    }

    public static String getProperty(String key) {
        return INSTANCE.propConfig.getProperty(key);
    }
}
