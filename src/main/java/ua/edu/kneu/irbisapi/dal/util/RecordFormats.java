package ua.edu.kneu.irbisapi.dal.util;

import ru.arsmagna.IrbisFormat;

public enum RecordFormats {
    ALL(IrbisFormat.ALL),
    BRIEF(IrbisFormat.BRIEF);

    private final String value;

    RecordFormats(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
