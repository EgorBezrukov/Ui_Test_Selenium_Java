package readProperties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ?   ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                :   ConfigFactory.load("application.conf");
    }
    String URL = readConfig().getString("url");
    String DEMO_LOGIN = readConfig().getString("userParams.demo.login");
    String DEMO_PASSWORD = readConfig().getString("userParams.demo.password");


}
