package ua.edu.kneu.irbisapi.dal.util.converter;

import ru.arsmagna.IrbisEncoding;
import ru.arsmagna.IrbisFormat;
import ru.arsmagna.IrbisText;
import ru.arsmagna.MarcRecord;
import ua.edu.kneu.irbisapi.dal.util.IFormatRecordsConverter;

import java.io.IOException;

public class AllFormatRecordsConverter implements IFormatRecordsConverter {

    @Override
    public String getFormat() {
        return IrbisFormat.ALL;
    }

    @Override
    public MarcRecord formatRecordToMarc(String line) throws IOException {
        MarcRecord record = null;
        line = line.replaceAll("\r\n", new String(IrbisEncoding.encode(IrbisEncoding.utf(), IrbisText.IRBIS_DELIMITER),
                IrbisEncoding.utf()).substring(0, 1));
        String[] split = line.split(new String(IrbisEncoding.encode(IrbisEncoding.utf(), IrbisText.IRBIS_DELIMITER),
                IrbisEncoding.utf()).substring(0, 1));
        if (Integer.parseInt(split[0].split("#")[0]) >= 0) {
            record = new MarcRecord();
            record.parseSingle(split);
        }
        return record;
    }

}
