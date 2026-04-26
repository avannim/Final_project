package utils.faker;

import net.datafaker.providers.base.BaseFaker;

import java.util.Locale;

public class AdvertFaker extends BaseFaker {

    public AdvertFaker() {
        super(Locale.forLanguageTag("ru"));
    }

    public AdvertFakerProvider advert() {
        return getProvider(AdvertFakerProvider.class, AdvertFakerProvider::new);
    }
}