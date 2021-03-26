package ua.edu.kneu.irbisapi.dal;

import ru.arsmagna.MarcRecord;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface IRecordMapper<DTO> {
    DTO map(MarcRecord record);

    default List<DTO> map(Collection<MarcRecord> recordDAOCollection) {
        if (recordDAOCollection == null) {
            return null;
        }
        return recordDAOCollection.stream().map(this::map).collect(Collectors.toList());
    }
}
