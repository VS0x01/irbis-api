package ua.edu.kneu.irbisapi.service;

import org.springframework.stereotype.Service;
import ua.edu.kneu.irbisapi.dal.RecordDAO;
import ua.edu.kneu.irbisapi.dtl.author.AuthorDTO;
import ua.edu.kneu.irbisapi.dtl.author.AuthorMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService extends AbstractRecordService<AuthorDTO> {
    public AuthorService(RecordDAO recordDAO, AuthorMapper recordMapper) {
        super(recordDAO, recordMapper);
    }

    @Override
    public List<AuthorDTO> loadAllRecords() {
        return super.loadAllRecords()
                .stream()
                .filter(author -> author.workPlace != null || !Optional.ofNullable(author.description).orElse("").isEmpty())
                .collect(Collectors.toList());
    }
}
