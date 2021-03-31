package ua.edu.kneu.irbisapi.services;

import org.springframework.stereotype.Service;
import ua.edu.kneu.irbisapi.dal.RecordDAO;
import ua.edu.kneu.irbisapi.dtl.IRecordMapper;
import ua.edu.kneu.irbisapi.dtl.author.AuthorDTO;

import java.util.List;

@Service
public class AuthorService {
    private final RecordDAO recordDAO;
    private final IRecordMapper<AuthorDTO> authorMapper;

    public AuthorService(RecordDAO recordDAO, IRecordMapper<AuthorDTO> authorMapper) {
        this.recordDAO = recordDAO;
        this.authorMapper = authorMapper;
    }

    public List<AuthorDTO> loadAllAuthors() {
        return authorMapper.map(recordDAO.getAll());
    }

    public AuthorDTO loadAuthorByMfn(int mfn) {
        return authorMapper.map(recordDAO.get(mfn));
    }

}
