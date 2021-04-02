package ua.edu.kneu.irbisapi.services;

import org.springframework.stereotype.Service;
import ua.edu.kneu.irbisapi.dal.RecordDAO;
import ua.edu.kneu.irbisapi.dtl.author.AuthorDTO;
import ua.edu.kneu.irbisapi.dtl.author.AuthorMapper;

@Service
public class AuthorService extends AbstractRecordService<AuthorDTO> {
    public AuthorService(RecordDAO recordDAO, AuthorMapper recordMapper) {
        super(recordDAO, recordMapper);
    }
}
