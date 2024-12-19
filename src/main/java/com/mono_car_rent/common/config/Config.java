package com.mono_car_rent.common.config;

public class Config {
    private  int id;
    private Theme theme;
    private boolean isSideMenuOpen;

    public Config() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public boolean isSideMenuOpen() {
        return isSideMenuOpen;
    }

    public void setSideMenuOpen(boolean isSideMenuOpen) {
        this.isSideMenuOpen = isSideMenuOpen;
    }

    public enum Theme {
        LIGHT, DARK
    }
}