package ua.edu.kneu.irbisapi.dtl.work;

import org.springframework.stereotype.Component;
import ru.arsmagna.MarcRecord;
import ua.edu.kneu.irbisapi.dtl.IRecordMapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkMapper implements IRecordMapper<WorkDTO> {
    @Override
    public WorkDTO map(MarcRecord record) {
        final String authorId = record.fm(700, '3');
        List<WorkDTO> content = Arrays.stream(record.getField(330)).map(field -> {
            final String contentAuthorId = field.getFirstSubFieldValue('!');
            return new WorkDTO(-1, contentAuthorId != null ? Integer.parseInt(contentAuthorId) : -1, field.getFirstSubFieldValue('F'), field.getFirstSubFieldValue('C'), null, field.getFirstSubFieldValue('4'));
        }).collect(Collectors.toList());
        return new WorkDTO(record.mfn, authorId != null ? Integer.parseInt(authorId) : -1, record.fm(700, 'a'), record.fm(200, 'a'), content, "");
    }
}
