package ua.edu.kneu.irbisapi.dal.util.converter;

import ru.arsmagna.MarcRecord;
import ua.edu.kneu.irbisapi.dal.util.IFormatRecordsConverter;
import ua.edu.kneu.irbisapi.dal.util.RecordFormats;

public class DefaultFormatRecordsConverter implements IFormatRecordsConverter {

    private final RecordFormats format;

    public String getFormat() {
        return format.getValue();
    }

    public DefaultFormatRecordsConverter(RecordFormats format) {
        this.format = format;
    }

    @Override
    public MarcRecord formatRecordToMarc(String line) {
        MarcRecord record = new MarcRecord();
        record.description = line;
        return record;
    }

}
