package Base;

import DataSourceConfig.Config;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;

public class BaseTest {

    public static Map<String, String> config;

    @BeforeAll
    static void setUpProject() {
        config = Config.getAppConfig().getProperties();
    }

    public static RequestSpecification getRequestSpec() {
        return RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .setBaseUri(config.get("baseUri"))
                .setBasePath(config.get("studentPath"))
                .build();
    }
}
