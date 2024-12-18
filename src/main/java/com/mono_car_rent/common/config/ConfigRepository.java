package com.mono_car_rent.common.config;

import com.google.gson.reflect.TypeToken;
import com.mono_car_rent.common.RepositoryResponse;
import com.mono_car_rent.common.AbstractRepository;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class ConfigRepository extends AbstractRepository<Config> {
    private ConfigRepository() {
        super("config.json", new TypeToken<ArrayList<Config>>() {});
    }

    /**
     * Finds a config by key.
     *
     * @param key the key to search
     * @return the config found or null
     */
    public RepositoryResponse<Config> findByKey(String key) {
        for (Config config : this.getAll()) {
            if (config.getKey().equals(key)) {
                return RepositoryResponse.<Config>builder()
                        .success(true)
                        .value(config)
                        .build();
            }
        }
        return RepositoryResponse.<Config>builder()
                .success(false)
                .build();
    }

    /**
     * Updates a config.
     *
     * @param key the key to update
     * @param value the value to update
     */
    public RepositoryResponse<Config> update(String key, String value) {
        RepositoryResponse<Config> found = this.findByKey(key);

        if (!found.isSuccess()) {
            return RepositoryResponse.<Config>builder()
                    .success(false)
                    .build();
        }

        Config config = found.getValue();
        config.setValue(value);

        return super.update(found.getIndex(), config);
    }

    //#region Singleton
    private static final AtomicReference<ConfigRepository> instance = new AtomicReference<>();
    public static ConfigRepository getInstance() {
        if (instance.get() == null) {
            instance.set(new ConfigRepository());
        }
        return instance.get();
    }
    //#endregion
}
