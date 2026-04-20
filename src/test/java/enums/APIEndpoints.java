package enums;

public enum APIEndpoints {

    CREATE_USER("api/signup"),
    LOGIN_USER("api/signin"),

    CREATE_ADVERT("api/create-lisiting"),
    SEARCH_ADVERT("api/offers/1/"),
    DELETE_ADVERT("api/listings/");

    private final String path;

    APIEndpoints(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
