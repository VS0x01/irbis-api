package ua.edu.kneu.irbisapi.dal.util.converter;

import ru.arsmagna.FastNumber;
import ru.arsmagna.IrbisFormat;
import ru.arsmagna.MarcRecord;
import ua.edu.kneu.irbisapi.dal.util.IFormatRecordsConverter;

public class BriefFormatRecordsConverter implements IFormatRecordsConverter {

    @Override
    public String getFormat() {
        return IrbisFormat.BRIEF;
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
