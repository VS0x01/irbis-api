package ua.edu.kneu.irbisapi.dal.util;

import ua.edu.kneu.irbisapi.dal.util.converter.AllFormatRecordsConverter;
import ua.edu.kneu.irbisapi.dal.util.converter.DefaultFormatRecordsConverter;

public class FormatRecordsFactory {

    private FormatRecordsFactory() {
    }

    public static IFormatRecordsConverter getConverter(RecordFormats format) {
        switch (format) {
            case ALL:
                return new AllFormatRecordsConverter();
            default:
                return new DefaultFormatRecordsConverter(format);
        }
    }

}
