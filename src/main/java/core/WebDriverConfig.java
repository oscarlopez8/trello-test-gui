package core;

import utils.GetProperties;

import java.util.Properties;

public class WebDriverConfig {

    // Path of gradle properties file.
    public static final String PATH_OF_GRADLE_PROPERTIES_FILE = "gradle.properties";

    // Name of property of gradle properties file.
    public static final String BROWSER = "browserName";

    private static WebDriverConfig webDriverConfig;
    private Properties properties;

    /**
     * This is constructor for init variables.
     */
    private WebDriverConfig() {
        initializes();
    }

    /**
     * This method ensure that only one instance is created according to the build pattern.
     *
     * @return an instance of 'WebDriverConfig' type.
     */
    public static WebDriverConfig getInstance() {
        if (webDriverConfig == null) {
            webDriverConfig = new WebDriverConfig();
        }
        return webDriverConfig;
    }

    /**
     * This method reads the file 'gradle.properties' ans return its values of object 'properties'.
     */
    private void initializes() {
        properties = GetProperties.getProperties(PATH_OF_GRADLE_PROPERTIES_FILE);
    }

    /**
     * Gets a Browser name.
     * @return Names of Browser
     */
    public String getBrowser() {
        //return System.getProperty(BROWSER).toLowerCase();
        return properties.getProperty(BROWSER).toLowerCase();
    }

    /**
     * Gives the implicitly wait properties read from 'gradle.properties'.
     *
     * @return a implicitly wait.
     */
    public long getImplicitWaitTime() {
        return Long.parseLong(properties.getProperty("implicitWait"));
    }

    /**
     * Gives the explicitly wait properties read from 'gradle.properties'.
     *
     * @return a explicitly wait.
     */
    public long getExplicitWaitTime() {
        return Long.parseLong(properties.getProperty("explicitWait"));
    }

    /**
     * Gives the wait sleep properties read from 'gradle.properties'.
     *
     * @return a explicitly wait.
     */
    public long getSleepWait() {
        return Long.parseLong(properties.getProperty("sleepTime"));
    }
}
