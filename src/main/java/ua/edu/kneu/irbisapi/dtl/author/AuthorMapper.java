package ua.edu.kneu.irbisapi.dtl.author;

import org.springframework.stereotype.Component;
import ru.arsmagna.MarcRecord;
import ua.edu.kneu.irbisapi.dtl.IRecordMapper;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class AuthorMapper implements IRecordMapper<AuthorDTO> {
    @Override
    public AuthorDTO map(MarcRecord record) {
        List<String> linkNames = Arrays.asList(record.fma(951, 't'));
        List<String> linkRefs = Arrays.asList(record.fma(951, 'i'));
        Iterator<String> linkNamesIterator = linkNames.iterator();
        Iterator<String> linkRefsIterator = linkRefs.iterator();

        return new AuthorDTO(record.mfn,
                record.fm(210, 'g'),
                record.fm(210, 'a'),
                IntStream.range(0, linkNames.size())
                        .boxed()
                        .collect(Collectors.toMap(
                                i -> linkNamesIterator.next(),
                                i -> linkRefsIterator.next())
                        )
        );
    }
}
