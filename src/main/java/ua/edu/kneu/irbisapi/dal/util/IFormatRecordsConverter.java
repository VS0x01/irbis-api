package ua.edu.kneu.irbisapi.dal.util;

import ru.arsmagna.MarcRecord;

import java.io.IOException;

public interface IFormatRecordsConverter {
    String getFormat();

    MarcRecord formatRecordToMarc(String line) throws IOException;
}
