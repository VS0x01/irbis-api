package ua.edu.kneu.irbisapi.dtl.work;

import org.springframework.stereotype.Component;
import ru.arsmagna.MarcRecord;
import ua.edu.kneu.irbisapi.dtl.IRecordMapper;
import ua.edu.kneu.irbisapi.dtl.author.AuthorDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkMapper implements IRecordMapper<WorkDTO> {
    @Override
    public WorkDTO map(MarcRecord record) {
        final String authorId = record.fm(700, '3');
        final List<AuthorDTO> anotherAuthors = Arrays.stream(record.getField(701)).map(author -> {
            final String anotherAuthorId = author.getFirstSubFieldValue('3');
            return new AuthorDTO(anotherAuthorId != null ? Integer.parseInt(anotherAuthorId) : -1,
                    author.getFirstSubFieldValue('B'), author.getFirstSubFieldValue('A'), "", null, null, null);
        }).collect(Collectors.toList());
        List<WorkDTO> content = Arrays.stream(record.getField(330)).map(field -> {
            final String contentAuthorId = field.getFirstSubFieldValue('!');
            return new WorkDTO(-1, contentAuthorId != null ? Integer.parseInt(contentAuthorId) : -1,
                    field.getFirstSubFieldValue('F'), null, field.getFirstSubFieldValue('C'), null,
                    field.getFirstSubFieldValue('4'));
        }).collect(Collectors.toList());
        return new WorkDTO(record.mfn, authorId != null ? Integer.parseInt(authorId) : -1, record.fm(700, 'a'), anotherAuthors,
                record.fm(200, 'a'), content, "");
    }
}
