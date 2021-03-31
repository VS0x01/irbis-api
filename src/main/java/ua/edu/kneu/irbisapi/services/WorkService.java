package ua.edu.kneu.irbisapi.services;

import org.springframework.stereotype.Service;
import ua.edu.kneu.irbisapi.dal.RecordDAO;
import ua.edu.kneu.irbisapi.dtl.IRecordMapper;
import ua.edu.kneu.irbisapi.dtl.work.WorkDTO;

import java.util.List;

@Service
public class WorkService {
    private final RecordDAO recordDAO;
    private final IRecordMapper<WorkDTO> workMapper;

    public WorkService(RecordDAO recordDAO, IRecordMapper<WorkDTO> workMapper) {
        this.recordDAO = recordDAO;
        this.workMapper = workMapper;
    }

    public List<WorkDTO> loadAllWorks() {
        return workMapper.map(recordDAO.getAll());
    }

    public WorkDTO loadWorkByMfn(int mfn) {
        return workMapper.map(recordDAO.get(mfn));
    }

}
