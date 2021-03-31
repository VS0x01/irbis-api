package ua.edu.kneu.irbisapi.services;

import ua.edu.kneu.irbisapi.dal.RecordDAO;
import ua.edu.kneu.irbisapi.dtl.IRecordMapper;

import java.util.List;

public abstract class AbstractRecordService<DTO> {
    private final RecordDAO recordDAO;
    private final IRecordMapper<DTO> recordMapper;

    public AbstractRecordService(RecordDAO recordDAO, IRecordMapper<DTO> recordMapper) {
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
