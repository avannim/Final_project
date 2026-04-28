package utils;

import utils.faker.AdvertFaker;
import utils.faker.AdvertFakerProvider;

public class FakerUtils {

    private static final AdvertFaker faker = new AdvertFaker();

    public static AdvertFakerProvider advert() {
        return faker.advert();
    }
}