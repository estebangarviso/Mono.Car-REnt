package com.mono_car_rent.common.gui;

import java.awt.*;

public class Fonts {
    public static final String FONT_NAME = "Lato";
    public static final String FONT_HEADERS_NAME = "Open Sans";

    public static final int FONT_SIZE_EXTRA_SMALL = 10;
    public static final int FONT_SIZE_SMALL = 12;
    public static final int FONT_SIZE_MEDIUM = 14;
    public static final int FONT_SIZE_LARGE = 16;
    public static final int FONT_SIZE_XLARGE = 18;

    private Fonts() {
    }
    public  static Font getFontRegularXS() {
        return new Font(FONT_NAME, Font.PLAIN, FONT_SIZE_EXTRA_SMALL);
    }
    public static Font getFontRegularSM() {
        return new Font(FONT_NAME, Font.PLAIN, FONT_SIZE_SMALL);
    }

    public static Font getFontRegularMD() {
        return new Font(FONT_NAME, Font.PLAIN, FONT_SIZE_MEDIUM);
    }

    public static Font getFontRegularLG() {
        return new Font(FONT_NAME, Font.PLAIN, FONT_SIZE_LARGE);
    }

    public static Font getFontRegularXL() {
        return new Font(FONT_NAME, Font.PLAIN, FONT_SIZE_XLARGE);
    }

    public static Font getFontBoldXS() {
        return new Font(FONT_NAME, Font.BOLD, FONT_SIZE_EXTRA_SMALL);
    }
    public static Font getFontBoldSM() {
        return new Font(FONT_NAME, Font.BOLD, FONT_SIZE_SMALL);
    }

    public static Font getFontBoldMD() {
        return new Font(FONT_NAME, Font.BOLD, FONT_SIZE_MEDIUM);
    }

    public static Font getFontBoldLG() {
        return new Font(FONT_NAME, Font.BOLD, FONT_SIZE_LARGE);
    }

    public static Font getFontBoldXL() {
        return new Font(FONT_NAME, Font.BOLD, FONT_SIZE_XLARGE);
    }

    public static Font getHeadersFontRegularXS() {
        return new Font(FONT_HEADERS_NAME, Font.PLAIN, FONT_SIZE_EXTRA_SMALL);
    }
    public static Font getHeadersFontRegularSM() {
        return new Font(FONT_HEADERS_NAME, Font.PLAIN, FONT_SIZE_SMALL);
    }

    public static Font getHeadersFontRegularMD() {
        return new Font(FONT_HEADERS_NAME, Font.PLAIN, FONT_SIZE_MEDIUM);
    }

    public static Font getHeadersFontRegularLG() {
        return new Font(FONT_HEADERS_NAME, Font.PLAIN, FONT_SIZE_LARGE);
    }

    public static Font getHeadersFontRegularXL() {
        return new Font(FONT_HEADERS_NAME, Font.PLAIN, FONT_SIZE_XLARGE);
    }

    public static Font getHeadersFontBoldSM() {
        return new Font(FONT_HEADERS_NAME, Font.BOLD, FONT_SIZE_SMALL);
    }

    public static Font getHeadersFontBoldMD() {
        return new Font(FONT_HEADERS_NAME, Font.BOLD, FONT_SIZE_MEDIUM);
    }

    public static Font getHeadersFontBoldLG() {
        return new Font(FONT_HEADERS_NAME, Font.BOLD, FONT_SIZE_LARGE);
    }

    public static Font getHeadersFontBoldXL() {
        return new Font(FONT_HEADERS_NAME, Font.BOLD, FONT_SIZE_XLARGE);
    }
}
