package ua.edu.kneu.irbisapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.kneu.irbisapi.dtl.work.WorkDTO;
import ua.edu.kneu.irbisapi.services.AbstractRecordService;

@RestController
@RequestMapping("works")
public class WorksController extends AbstractController<WorkDTO> {
    public WorksController(AbstractRecordService<WorkDTO> recordService) {
        super(recordService);
    }
}
