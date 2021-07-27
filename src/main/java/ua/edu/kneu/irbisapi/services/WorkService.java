package ua.edu.kneu.irbisapi.services;

import org.springframework.stereotype.Service;
import ua.edu.kneu.irbisapi.dal.RecordDAO;
import ua.edu.kneu.irbisapi.dtl.work.WorkDTO;
import ua.edu.kneu.irbisapi.dtl.work.WorkMapper;

import java.util.List;

@Service
public class WorkService extends AbstractRecordService<WorkDTO> {
    public WorkService(RecordDAO recordDAO, WorkMapper recordMapper) {
        super(recordDAO, recordMapper);
    }

    public List<WorkDTO> findWork(int authorId) {
        String req = "\"AN=" + authorId + "\"";
        return recordMapper.map(recordDAO.search(req));
    }

}
