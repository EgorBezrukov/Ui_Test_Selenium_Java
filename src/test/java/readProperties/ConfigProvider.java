package readProperties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config conf = readConf();

    static Config readConf() {
        return ConfigFactory.load("application.conf");
    }

    String URL = readConf().getString("url");
    String DEMO_LOGIN = readConf().getString("userParams.demo.login");
    String DEMO_PASSWORD = readConf().getString("userParams.demo.password");
    String SWAG_BASE_URL = readConf().getString("userParams.swagLabs.baseUrl");
    String SWAG_LOGIN = readConf().getString("userParams.swagLabs.login");
    String SWAG_PASSWORD = readConf().getString("userParams.swagLabs.password");
    String SWAG_PRODUCT_PAGE = readConf().getString("userParams.swagLabs.productPageUrl");


}
