package config;

import com.codeborne.selenide.Selenide;

public class LocalStorageHelper {

    public void setItem(String key, String value) {
        Selenide.executeJavaScript(
                "window.localStorage.setItem(arguments[0], arguments[1]);",
                key,
                value
        );
    }

    public String getItem(String key) {
        return Selenide.executeJavaScript(
                "return window.localStorage.getItem(arguments[0]);",
                key
        );
    }

    public void removeItem(String key) {
        Selenide.executeJavaScript(
                "window.localStorage.removeItem(arguments[0]);",
                key
        );
    }

    public void clear() {
        Selenide.executeJavaScript("window.localStorage.clear();");
    }
}
