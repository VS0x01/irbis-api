package ua.edu.kneu.irbisapi.dal;

import org.springframework.stereotype.Repository;
import ru.arsmagna.IrbisConnection;
import ru.arsmagna.IrbisException;
import ru.arsmagna.MarcRecord;
import ua.edu.kneu.irbisapi.IFormatRecordsConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class RecordDAO {
    private final IrbisConnection connection;
    private IFormatRecordsConverter format;

    public RecordDAO(IrbisConnection connection, IFormatRecordsConverter format) {
        this.connection = connection;
        this.format = format;
    }

    public MarcRecord[] getAll() {
        try {
            int maxMFN = connection.getMaxMfn(connection.database);
            String[] lines = connection.formatRecords(format.getFormat(), IntStream.range(1, maxMFN).toArray());
            List<MarcRecord> result = new ArrayList<>();

            for (String line :
                    lines) {
                MarcRecord record = format.formatRecordToMarc(line);
                if (record == null) continue;
                result.add(record);
            }

            return result.toArray(MarcRecord[]::new);
        } catch (IOException | IrbisException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MarcRecord get(int mfn) {
        try {
            MarcRecord record = connection.readRecord(connection.database, mfn);
            return record;
        } catch (IOException | IrbisException e) {
            e.printStackTrace();
        }
        return null;
    }

}
