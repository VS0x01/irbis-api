package ua.edu.kneu.irbisapi.dal.util.converter;

import ru.arsmagna.FastNumber;
import ru.arsmagna.MarcRecord;
import ua.edu.kneu.irbisapi.dal.util.IFormatRecordsConverter;
import ua.edu.kneu.irbisapi.dal.util.RecordFormats;

public class DefaultFormatRecordsConverter implements IFormatRecordsConverter {

    private final RecordFormats format;

    public DefaultFormatRecordsConverter(RecordFormats format) {
        this.format = format;
    }

    public String getFormat() {
        return format.getValue();
    }

    @Override
    public MarcRecord formatRecordToMarc(String line) {
        MarcRecord record = null;
        String[] parts = line.split("#");
        int mfn = FastNumber.parseInt32(parts[0]);
        if (mfn > 0) {
            record = new MarcRecord();
            record.mfn = mfn;
            record.description = parts[1].replaceAll("\r\n", "");
        }
        return record;
    }

}
