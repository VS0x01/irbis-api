package ua.edu.kneu.irbisapi.services;

import org.springframework.stereotype.Service;
import ua.edu.kneu.irbisapi.dal.RecordDAO;
import ua.edu.kneu.irbisapi.dtl.IRecordMapper;
import ua.edu.kneu.irbisapi.dtl.work.WorkDTO;

@Service
public class WorkService extends AbstractRecordService<WorkDTO> {
    public WorkService(RecordDAO recordDAO, IRecordMapper<WorkDTO> recordMapper) {
        super(recordDAO, recordMapper);
    }
}
