package steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {
    @BeforeAll
    public static void setUpAll() {
        // Базовые настройки Selenide для Java 11 + Selenide 6.19.1
        Configuration.baseUrl = System.getProperty("base.url", Configuration.baseUrl);
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.timeout = 12000;
        Configuration.pageLoadTimeout = 30000;
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        Configuration.reportsFolder = "target/selenide-report";
        Configuration.screenshots = true;
        Configuration.savePageSource = true;

        System.out.println("🔥 Selenide environment configured");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("🔥 Closing all browsers");
        closeWebDriver();
    }
}
