package ua.edu.kneu.irbisapi.dtl.author;

import org.springframework.stereotype.Component;
import ru.arsmagna.MarcRecord;
import ua.edu.kneu.irbisapi.dtl.IRecordMapper;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AuthorMapper implements IRecordMapper<AuthorDTO> {
    @Override
    public AuthorDTO map(MarcRecord record) {
        Map<String, String> links = Arrays.stream(record.getField(951)).collect(Collectors.toMap(link -> {
                    final String linkName = link.getFirstSubFieldValue('t');
                    return linkName != null ? linkName : "Link";
                },
                link -> {
                    final String linkHref = link.getFirstSubFieldValue('i');
                    return linkHref != null ? linkHref : "";
                }));
        final int id = record.mfn;
        final String firstName = record.fm(210, 'g');
        final String lastName = record.fm(210, 'a');
        final String workPlace = record.fm(910, 'p');
        final String academicStatus = (record.getField(340).length > 0 ? record.getField(340)[0].getFirstSubFieldValue('A') : null);
        final String degree = (record.getField(340).length > 1 ? record.getField(340)[1].getFirstSubFieldValue('A') : null);

        AuthorDTOBuilder authorDTOBuilder = new AuthorDTOBuilder(new AuthorDTO(id, firstName, lastName, workPlace, academicStatus, degree, links, "dsf"));

        authorDTOBuilder.setDescription(record.description);

        return authorDTOBuilder.build();
    }
}
