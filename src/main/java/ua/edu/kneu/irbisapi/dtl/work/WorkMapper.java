package ua.edu.kneu.irbisapi.dtl.work;

import org.springframework.stereotype.Component;
import ru.arsmagna.MarcRecord;
import ua.edu.kneu.irbisapi.dtl.IRecordMapper;
import ua.edu.kneu.irbisapi.dtl.author.AuthorDTO;
import ua.edu.kneu.irbisapi.dtl.author.AuthorDTOBuilder;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class WorkMapper implements IRecordMapper<WorkDTO> {
    @Override
    public WorkDTO map(MarcRecord record) {
        int authorId = -1;
        Map<Integer, Character> yearFields = new HashMap<>();
        yearFields.put(210, 'D');
        yearFields.put(463, 'J');
        int year = obtainYearFromOneOfTheFields(record, yearFields);
        try {
            authorId = Integer.parseInt(Optional.ofNullable(record.fm(700, '3')).orElse("-1"));
        } catch(NumberFormatException e) {
            System.out.printf("Record: %s, exception: %s\n", record.mfn, e);
        }

        final List<AuthorDTO> anotherAuthors = Arrays.stream(record.getField(701)).map(author -> {
            final String anotherAuthorId = Optional.ofNullable(author.getFirstSubFieldValue('3')).orElse("-1");
            AuthorDTOBuilder authorDTOBuilder = new AuthorDTOBuilder(anotherAuthorId.isBlank() ? -1 : Integer.parseInt(anotherAuthorId), author.getFirstSubFieldValue('B'), author.getFirstSubFieldValue('A'));
            return authorDTOBuilder.build();
        }).collect(Collectors.toList());

        final List<WorkDTO> content = Arrays.stream(record.getField(330)).map(field -> {
            final String contentAuthorId = Optional.ofNullable(field.getFirstSubFieldValue('!')).orElse("-1");
            WorkDTOBuilder workDTOBuilder = new WorkDTOBuilder(new WorkDTO(-1, contentAuthorId.isBlank() ? -1 : Integer.parseInt(contentAuthorId),
                    field.getFirstSubFieldValue('F'), field.getFirstSubFieldValue('C'), field.getFirstSubFieldValue('4')));
            return workDTOBuilder.build();
        }).collect(Collectors.toList());

        WorkDTOBuilder workDTOBuilder = new WorkDTOBuilder(record.mfn, record.fm(200, 'a'));
        workDTOBuilder
                .setAuthorId(authorId)
                .setAuthorName(record.fm(700, 'a'))
                .setAnotherAuthors(anotherAuthors)
                .setContent(content)
                .setDescription(record.description)
                .setYear(year).setLinks(Arrays.asList(record.fma(951, 'I')));
        return workDTOBuilder.build();
    }

    private static int obtainYearFromOneOfTheFields(MarcRecord record, Map<Integer, Character> field) {
        AtomicInteger year = new AtomicInteger(-1);

        field.forEach((Integer key, Character value) -> {
            try {
                int parsedYear = Integer.parseInt(Optional.ofNullable(record.fm(key, value)).orElse("-1"));
                if(parsedYear != -1) year.set(parsedYear);
            } catch(NumberFormatException e) {
                System.out.printf("Record: %s, exception: %s\n", record.mfn, e);
            }
        });

        return year.get();
    }
}
