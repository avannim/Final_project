package utils.faker;

import net.datafaker.providers.base.AbstractProvider;
import net.datafaker.providers.base.BaseProviders;

import java.util.List;

public class AdvertFakerProvider extends AbstractProvider<BaseProviders> {

    private static final List<String> cities = List.of(
            "Москва", "Санкт-Петербург", "Новосибирск",
            "Екатеринбург", "Казань"
    );

    private static final List<String> categories = List.of(
            "Авто", "Книги", "Садоводство", "Хобби", "Технологии"
    );

    private static final List<String> conditions = List.of(
            "Новый", "Б/У"
    );

    public AdvertFakerProvider(BaseProviders faker) {
        super(faker);
    }

    public String city() {
        return cities.get(faker.random().nextInt(cities.size()));
    }

    public String category() {
        return categories.get(faker.random().nextInt(categories.size()));
    }

    public String condition() {
        return conditions.get(faker.random().nextInt(conditions.size()));
    }
}