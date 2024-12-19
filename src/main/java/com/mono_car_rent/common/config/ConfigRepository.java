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
     * @param id the id to search
     * @return the config found or null
     */
    protected RepositoryResponse<Config> findById(int id) {
        for (Config config : this.getAll()) {
            if (config.getId() == id) {
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
     * @param id the id to update
     * @param value the value to update
     */
    public RepositoryResponse<Config> update(int id, ConfigUpdateDTO configUpdateDTO) {
        RepositoryResponse<Config> found = this.findById(id);

        if (!found.isSuccess()) {
            return RepositoryResponse.<Config>builder()
                    .success(false)
                    .build();
        }

        Config config = found.getValue();
        if (configUpdateDTO.getTheme() != null) {
            config.setTheme(configUpdateDTO.getTheme());
        }
        if (configUpdateDTO.getIsSideMenuOpen() != null) {
            config.setSideMenuOpen(configUpdateDTO.getIsSideMenuOpen());
        }

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
