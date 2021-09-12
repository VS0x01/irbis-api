package ua.edu.kneu.irbisapi.dal.util;

import ua.edu.kneu.irbisapi.dal.util.converter.AllFormatRecordsConverter;
import ua.edu.kneu.irbisapi.dal.util.converter.BriefFormatRecordsConverter;

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
