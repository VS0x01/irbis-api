package ua.edu.kneu.irbisapi;

import ru.arsmagna.IrbisEncoding;
import ru.arsmagna.IrbisFormat;
import ru.arsmagna.IrbisText;
import ru.arsmagna.MarcRecord;

import java.io.IOException;

public class AllFormatRecordsConverter implements IFormatRecordsConverter {
    @Override
    public String getFormat() {
        return IrbisFormat.ALL;
    }

    @Override
    public MarcRecord formatRecordToMarc(String line) throws IOException {
        MarcRecord record = null;
        String[] splitted = line.split(new String(IrbisEncoding.encode(IrbisEncoding.utf(), IrbisText.IRBIS_DELIMITER),
                IrbisEncoding.utf()).substring(0, 1));
        if (Integer.parseInt(splitted[0].split("#")[0]) >= 0) {
            record = new MarcRecord();
            record.parseSingle(splitted);
        }
        return record;
    }
}
