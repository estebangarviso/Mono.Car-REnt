package com.mono_car_rent.common.config;

import java.util.concurrent.atomic.AtomicReference;

public class ConfigService {
    private int id;
    private final ConfigRepository configRepository = ConfigRepository.getInstance();

    private ConfigService() {
        this.id = 1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Config getConfig() {
        return this.configRepository.findById(this.id).getValue();
    }

    public void update(ConfigUpdateDTO configUpdateDTO) {
        this.configRepository.update(this.id, configUpdateDTO);
    }

    //#region Singleton
    private static final AtomicReference<ConfigService> instance = new AtomicReference<>();
    public static ConfigService getInstance() {
        if (instance.get() == null) {
            instance.set(new ConfigService());
        }
        return instance.get();
    }
    //#endregion
}
