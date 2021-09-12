package ua.edu.kneu.irbisapi.dtl.work;

import org.springframework.stereotype.Component;
import ru.arsmagna.MarcRecord;
import ua.edu.kneu.irbisapi.dtl.IRecordMapper;
import ua.edu.kneu.irbisapi.dtl.author.AuthorDTO;
import ua.edu.kneu.irbisapi.dtl.author.AuthorDTOBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class WorkMapper implements IRecordMapper<WorkDTO> {
    @Override
    public WorkDTO map(MarcRecord record) {
        String authorId = Optional.ofNullable(record.fm(700, '3')).orElse("-1");
        authorId = authorId.isBlank() ? "-1" : authorId;

        final List<AuthorDTO> anotherAuthors = Arrays.stream(record.getField(701)).map(author -> {
            final String anotherAuthorId = Optional.ofNullable(author.getFirstSubFieldValue('3')).orElse("-1");
            AuthorDTOBuilder authorDTOBuilder = new AuthorDTOBuilder(anotherAuthorId.isBlank() ? -1 : Integer.parseInt(anotherAuthorId), author.getFirstSubFieldValue('B'), author.getFirstSubFieldValue('A'));
            return authorDTOBuilder.build();
        }).collect(Collectors.toList());

        List<WorkDTO> content = Arrays.stream(record.getField(330)).map(field -> {
            final String contentAuthorId = Optional.ofNullable(field.getFirstSubFieldValue('!')).orElse("-1");
            WorkDTOBuilder workDTOBuilder = new WorkDTOBuilder(new WorkDTO(-1, contentAuthorId.isBlank() ? -1 : Integer.parseInt(contentAuthorId),
                    field.getFirstSubFieldValue('F'), field.getFirstSubFieldValue('C'), field.getFirstSubFieldValue('4')));
            return workDTOBuilder.build();
        }).collect(Collectors.toList());

        WorkDTOBuilder workDTOBuilder = new WorkDTOBuilder(record.mfn, record.fm(200, 'a'));
        workDTOBuilder.setAuthorId(Integer.parseInt(authorId)).setAuthorName(record.fm(700, 'a')).setAnotherAuthors(anotherAuthors).setContent(content);
        workDTOBuilder.setDescription(record.description);
        return workDTOBuilder.build();
    }
}
