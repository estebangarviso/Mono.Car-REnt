package com.mono_car_rent.common.config;

public class ConfigUpdateDTO {
    private Config.Theme theme;
    private Boolean isSideMenuOpen;

    public ConfigUpdateDTO() {}

    public ConfigUpdateDTO setTheme(Config.Theme theme) {
        this.theme = theme;
        return this;
    }

    public Config.Theme getTheme() {
        return theme;
    }

    public ConfigUpdateDTO setIsSideMenuOpen(Boolean isSideMenuOpen) {
        this.isSideMenuOpen = isSideMenuOpen;
        return this;
    }

    public Boolean getIsSideMenuOpen() {
        return isSideMenuOpen;
    }
}
