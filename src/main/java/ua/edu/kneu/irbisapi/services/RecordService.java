package ua.edu.kneu.irbisapi.services;

import org.springframework.stereotype.Service;
import ua.edu.kneu.irbisapi.dal.IRecordMapper;
import ua.edu.kneu.irbisapi.dal.RecordDAO;

import java.util.List;

@Service
public class RecordService<DTO>{
    private final RecordDAO recordDAO;
    private final IRecordMapper<DTO> recordMapper;

    public RecordService(RecordDAO recordDAO, IRecordMapper<DTO> recordMapper) {
        this.recordDAO = recordDAO;
        this.recordMapper = recordMapper;
    }

    public List<DTO> loadAllRecords() {
        return recordMapper.map(recordDAO.getAll());
    }

    public DTO loadRecordByMfn(int mfn) {
        return recordMapper.map(recordDAO.get(mfn));
    }

}
