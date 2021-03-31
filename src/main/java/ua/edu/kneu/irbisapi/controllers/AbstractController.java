package ua.edu.kneu.irbisapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.edu.kneu.irbisapi.services.AbstractRecordService;

import java.util.List;

public abstract class AbstractController<DTO> {
    private final AbstractRecordService<DTO> recordService;

    public AbstractController(AbstractRecordService<DTO> recordService) {
        this.recordService = recordService;
    }

    @GetMapping
    public List<DTO> index() {
        return recordService.loadAllRecords();
    }

    @GetMapping("{mfn}")
    public DTO show(@PathVariable int mfn) {
        return recordService.loadRecordByMfn(mfn);
    }

}
