package ua.edu.kneu.irbisapi.dtl.work;

import org.springframework.stereotype.Component;
import ru.arsmagna.MarcRecord;
import ua.edu.kneu.irbisapi.dtl.IRecordMapper;

import java.util.ArrayList;

@Component
public class WorkMapper implements IRecordMapper<WorkDTO> {
    @Override
    public WorkDTO map(MarcRecord record) {
        return new WorkDTO(record.mfn, record.fm(700, 'a'), record.fm(200, 'a'), new ArrayList<WorkDTO>()); //TODO: map content from record.fma(330)
    }
}
