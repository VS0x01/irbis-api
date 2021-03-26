package ua.edu.kneu.irbisapi.dal;

import org.springframework.stereotype.Component;
import ru.arsmagna.MarcRecord;

@Component
public class AuthorMapper implements IRecordMapper<AuthorDTO> {
    @Override
    public AuthorDTO map(MarcRecord record) {
        return new AuthorDTO(record.mfn, record.fm(210, 'g'), record.fm(210, 'a'));
    }
}
