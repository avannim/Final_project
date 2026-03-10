package enums;

public enum APIEndpoints {

    CREATE_USER("regiatration"),
    LOGIN_USER("login"),

    CREATE_ADVERT("create-lisiting");

    private final String path;

    APIEndpoints(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
