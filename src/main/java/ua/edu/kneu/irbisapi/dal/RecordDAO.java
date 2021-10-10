package ua.edu.kneu.irbisapi.dal;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import ru.arsmagna.IrbisConnection;
import ru.arsmagna.IrbisException;
import ru.arsmagna.MarcRecord;
import ua.edu.kneu.irbisapi.dal.util.IFormatRecordsConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
@RequestScope
public class RecordDAO {
    private final IrbisConnection connection;
    private IFormatRecordsConverter format;

    public RecordDAO(IrbisConnection connection) {
        this.connection = connection;
    }

    public void setFormat(IFormatRecordsConverter format) {
        this.format = format;
    }

    public List<MarcRecord> getAll() {
        try {
            int maxMFN = connection.getMaxMfn(connection.database);
            return get(IntStream.range(1, maxMFN).toArray());
        } catch (IOException | IrbisException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<MarcRecord> get(int[] mfns) {
        try {
            List<MarcRecord> result = new ArrayList<>();
            if (mfns.length == 1) {
                result.add(get(mfns[0]));
                return result;
            }

            String[] lines = connection.formatRecords(format.getFormat(), mfns);

            for (String line :
                    lines) {
                MarcRecord record = format.formatRecordToMarc(line);
                if (record == null) continue;
                result.add(record);
            }

            return result;
        } catch (IOException | IrbisException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MarcRecord get(int mfn) {
        try {
            return format.formatRecordToMarc(mfn + "#" + connection.formatRecord(format.getFormat(), mfn));
        } catch (IOException | IrbisException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<MarcRecord> search(String req) {
        try {
            return get(connection.search(req));
        } catch (IOException | IrbisException e) {
            e.printStackTrace();
        }
        return null;
    }

}
