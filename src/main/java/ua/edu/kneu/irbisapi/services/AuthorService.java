package ua.edu.kneu.irbisapi.services;

import org.springframework.stereotype.Service;
import ua.edu.kneu.irbisapi.dal.AuthorDTO;
import ua.edu.kneu.irbisapi.dal.AuthorMapper;
import ua.edu.kneu.irbisapi.dal.RecordDAO;

import java.util.List;

@Service
public class AuthorService {
    private final RecordDAO recordDAO;
    private final AuthorMapper authorMapper;

    public AuthorService(RecordDAO recordDAO, AuthorMapper authorMapper) {
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
