package ua.edu.kneu.irbisapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.kneu.irbisapi.dtl.work.WorkDTO;
import ua.edu.kneu.irbisapi.services.WorkService;

import java.util.List;

@RestController
@RequestMapping("works")
public class WorksController {
    private final WorkService workService;

    public WorksController(WorkService workService) {
        this.workService = workService;
    }

    @GetMapping
    public List<WorkDTO> index() {
        return workService.loadAllWorks();
    }

    @GetMapping("{mfn}")
    public WorkDTO show(@PathVariable int mfn) {
        return workService.loadWorkByMfn(mfn);
    }

}
