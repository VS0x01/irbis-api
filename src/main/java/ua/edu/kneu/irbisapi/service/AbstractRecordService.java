package ua.edu.kneu.irbisapi.service;

import ua.edu.kneu.irbisapi.dal.RecordDAO;
import ua.edu.kneu.irbisapi.dtl.IRecordMapper;

import java.util.List;

public abstract class AbstractRecordService<DTO> {
    protected final RecordDAO recordDAO;
    protected final IRecordMapper<DTO> recordMapper;

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
