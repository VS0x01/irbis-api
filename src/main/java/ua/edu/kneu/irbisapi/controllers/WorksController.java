package ua.edu.kneu.irbisapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.kneu.irbisapi.dtl.work.WorkDTO;
import ua.edu.kneu.irbisapi.services.WorkService;

import java.util.List;

@RestController
@RequestMapping("works")
public class WorksController extends AbstractController<WorkDTO> {
    public WorksController(WorkService recordService) {
        super(recordService);
    }

    @GetMapping("search")
    public List<WorkDTO> search(@RequestParam int authorId) {
        return ((WorkService) recordService).findWork(authorId);
    }
}
