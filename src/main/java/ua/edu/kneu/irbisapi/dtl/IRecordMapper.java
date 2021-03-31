package ua.edu.kneu.irbisapi.dtl;

import org.springframework.stereotype.Component;
import ru.arsmagna.MarcRecord;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public interface IRecordMapper<DTO> {
    DTO map(MarcRecord record);

    default List<DTO> map(Collection<MarcRecord> recordDAOCollection) {
        if (recordDAOCollection == null) {
            return null;
        }
        return recordDAOCollection.stream().map(this::map).collect(Collectors.toList());
    }
}
