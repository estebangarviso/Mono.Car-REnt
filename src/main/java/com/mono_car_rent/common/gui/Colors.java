package com.mono_car_rent.common.gui;

import java.awt.Color;
import com.mono_car_rent.common.config.ConfigRepository;

public class Colors {
    private final static ConfigRepository configRepository = ConfigRepository.getInstance();
    private static String currentTheme;
    // Main theme colors
    private static Color PRIMARY;
    private static Color PRIMARY_DARK;
    private static Color PRIMARY_LIGHT;
    private static Color ACCENT;
    
    // Neutral colors
    private static Color BACKGROUND;
    private static Color SURFACE;
    private static Color ERROR;
    
    // Text colors
    private static Color TEXT_PRIMARY;
    private static Color TEXT_SECONDARY;
    private static Color TEXT_DISABLED;

    private Colors() {}

    public static void init() {
        currentTheme = configRepository.findByKey("theme").getValue().getValue();
        if (currentTheme.equals("dark")) {
            useDarkTheme();
        } else {
            useLightTheme();
        }
    }

    public static void useDarkTheme() {
        // Primary Colors
        PRIMARY = new Color(33, 150, 243);        // Vibrant Blue
        PRIMARY_DARK = new Color(25, 118, 210);   // Deeper Blue
        PRIMARY_LIGHT = new Color(100, 181, 246); // Lighter Blue
        ACCENT = new Color(255, 64, 129);         // Pink Accent

        // Neutral Colors
        BACKGROUND = new Color(18, 18, 18);       // Almost Black
        SURFACE = new Color(33, 33, 33);          // Dark Grey Surface
        ERROR = new Color(211, 47, 47);           // Red for Errors

        // Text Colors
        TEXT_PRIMARY = new Color(255, 255, 255);   // White
        TEXT_SECONDARY = new Color(200, 200, 200); // Light Grey
        TEXT_DISABLED = new Color(120, 120, 120);  // Muted Grey

        // Save the theme
        if (!currentTheme.equals("dark")) configRepository.update("theme", "dark");
    }

    public static void useLightTheme() {
        // Primary Colors
        PRIMARY = new Color(33, 150, 243);        // Vibrant Blue
        PRIMARY_DARK = new Color(25, 118, 210);   // Deeper Blue
        PRIMARY_LIGHT = new Color(100, 181, 246); // Lighter Blue
        ACCENT = new Color(255, 64, 129);         // Pink Accent

        // Neutral Colors
        BACKGROUND = new Color(255, 255, 255);    // White
        SURFACE = new Color(245, 245, 245);       // Light Grey Surface
        ERROR = new Color(211, 47, 47);           // Red for Errors

        // Text Colors
        TEXT_PRIMARY = new Color(0, 0, 0);        // Black
        TEXT_SECONDARY = new Color(66, 66, 66);   // Dark Grey
        TEXT_DISABLED = new Color(120, 120, 120); // Muted Grey
        // Save the theme
        if (!currentTheme.equals("light")) configRepository.update("theme", "light");
    }
    
    // Helper methods
    private static Color withAlpha(Color color, int alpha) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
    }
    
    private static Color darker(Color color) {
        return color.darker();
    }

    private static Color brighter(Color color) {
        return color.brighter();
    }

    public static Color getPrimaryColor() {
        return PRIMARY;
    }

    public static Color getPrimaryDarkColor() {
        return PRIMARY_DARK;
    }

    public static Color getPrimaryLightColor() {
        return PRIMARY_LIGHT;
    }

    public static Color getAccentColor() {
        return ACCENT;
    }

    public static Color getBackgroundColor() {
        return BACKGROUND;
    }

    public static Color getSurfaceColor() {
        return SURFACE;
    }

    public static Color getErrorColor() {
        return ERROR;
    }

    public static Color getTextPrimaryColor() {
        return TEXT_PRIMARY;
    }

    public static Color getTextSecondaryColor() {
        return TEXT_SECONDARY;
    }

    public static Color getTextDisabledColor() {
        return TEXT_DISABLED;
    }

    public static Color getPrimaryColor(int alpha) {
        return withAlpha(PRIMARY, alpha);
    }

    public static Color getPrimaryDarkColor(int alpha) {
        return withAlpha(PRIMARY_DARK, alpha);
    }

    public static Color getPrimaryLightColor(int alpha) {
        return withAlpha(PRIMARY_LIGHT, alpha);
    }

    public static Color getAccentColor(int alpha) {
        return withAlpha(ACCENT, alpha);
    }

    public static Color getBackgroundColor(int alpha) {
        return withAlpha(BACKGROUND, alpha);
    }

    public static Color getSurfaceColor(int alpha) {
        return withAlpha(SURFACE, alpha);
    }

    public static Color getErrorColor(int alpha) {
        return withAlpha(ERROR, alpha);
    }

    public static Color getTextPrimaryColor(int alpha) {
        return withAlpha(TEXT_PRIMARY, alpha);
    }

    public static Color getTextSecondaryColor(int alpha) {
        return withAlpha(TEXT_SECONDARY, alpha);
    }

    public static Color getTextDisabledColor(int alpha) {
        return withAlpha(TEXT_DISABLED, alpha);
    }

    public static Color getDarkerPrimaryColor() {
        return darker(PRIMARY);
    }

    public static Color getDarkerPrimaryDarkColor() {
        return darker(PRIMARY_DARK);
    }

    public static Color getDarkerPrimaryLightColor() {
        return darker(PRIMARY_LIGHT);
    }

    public static Color getDarkerAccentColor() {
        return darker(ACCENT);
    }

    public static Color getDarkerBackgroundColor() {
        return darker(BACKGROUND);
    }

    public static Color getDarkerSurfaceColor() {
        return darker(SURFACE);
    }

    public static Color getDarkerErrorColor() {
        return darker(ERROR);
    }

    public static Color getDarkerTextPrimaryColor() {
        return darker(TEXT_PRIMARY);
    }

    public static Color getDarkerTextSecondaryColor() {
        return darker(TEXT_SECONDARY);
    }

    public static Color getDarkerTextDisabledColor() {
        return darker(TEXT_DISABLED);
    }

    public static Color getBrighterPrimaryColor() {
        return brighter(PRIMARY);
    }

    public static Color getBrighterPrimaryDarkColor() {
        return brighter(PRIMARY_DARK);
    }

    public static Color getBrighterPrimaryLightColor() {
        return brighter(PRIMARY_LIGHT);
    }

    public static Color getBrighterAccentColor() {
        return brighter(ACCENT);
    }

    public static Color getBrighterBackgroundColor() {
        return brighter(BACKGROUND);
    }

    public static Color getBrighterSurfaceColor() {
        return brighter(SURFACE);
    }

    public static Color getBrighterErrorColor() {
        return brighter(ERROR);
    }

    public static Color getBrighterTextPrimaryColor() {
        return brighter(TEXT_PRIMARY);
    }
}
