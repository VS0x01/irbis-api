package ua.edu.kneu.irbisapi.dtl.author;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.arsmagna.MarcRecord;
import ua.edu.kneu.irbisapi.dtl.IRecordMapper;

@Component
public class AuthorMapper implements IRecordMapper<AuthorDTO> {
    @Override
    public AuthorDTO map(MarcRecord record) {
        return new AuthorDTO(record.mfn, record.fm(210, 'g'), record.fm(210, 'a'));
    }
}
