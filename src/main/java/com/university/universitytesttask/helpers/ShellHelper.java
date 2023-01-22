package com.university.universitytesttask.helpers;

import lombok.AllArgsConstructor;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;

@AllArgsConstructor
public class ShellHelper {

    private final int SUCCESS_COLOR_IDX = 2;

    private final int ERROR_COLOR_IDX = 1;

    public String getColored(String message, int colorIdx) {
        return (new AttributedStringBuilder()).append(message, AttributedStyle.DEFAULT.foreground(colorIdx)).toAnsi();
    }

    public String getSuccessMessage(String message) {
        return getColored(message, SUCCESS_COLOR_IDX);
    }

    public String getErrorMessage(String message) {
        return getColored(message, ERROR_COLOR_IDX);
    }
}
