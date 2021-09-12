package ua.edu.kneu.irbisapi.dal.utils;

import ua.edu.kneu.irbisapi.dal.utils.converters.AllFormatRecordsConverter;
import ua.edu.kneu.irbisapi.dal.utils.converters.BriefFormatRecordsConverter;

public class FormatRecordsFabric {

    private FormatRecordsFabric() {
    }

    public static IFormatRecordsConverter getConverter(RecordFormats format) {
        switch (format) {
            case ALL:
                return new AllFormatRecordsConverter();
            case BRIEF:
                return new BriefFormatRecordsConverter();
            default:
                return new AllFormatRecordsConverter();
        }
    }
}