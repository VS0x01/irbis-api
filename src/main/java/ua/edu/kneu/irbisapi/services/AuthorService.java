package ua.edu.kneu.irbisapi.services;

import org.springframework.stereotype.Service;
import ua.edu.kneu.irbisapi.dal.RecordDAO;
import ua.edu.kneu.irbisapi.dtl.IRecordMapper;
import ua.edu.kneu.irbisapi.dtl.author.AuthorDTO;

@Service
public class AuthorService extends AbstractRecordService<AuthorDTO> {
    public AuthorService(RecordDAO recordDAO, IRecordMapper<AuthorDTO> recordMapper) {
        super(recordDAO, recordMapper);
    }
}
