package config;

import org.aeonbits.owner.ConfigFactory;

/**
 * Класс для читалки файлов .properties
 */
public class ConfigReader {
    /**
     * Читалка для test.properties
     */
    public static final TestDataConfig testDataConfig = ConfigFactory.create(TestDataConfig.class, System.getProperties());
}
