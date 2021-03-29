package ua.edu.kneu.irbisapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.kneu.irbisapi.dal.AuthorDTO;
import ua.edu.kneu.irbisapi.dal.AuthorMapper;
import ua.edu.kneu.irbisapi.services.RecordService;

import java.util.List;

@RestController
@RequestMapping("authors")
public class AuthorsController {
    private final RecordService<AuthorDTO> authorService;

    public AuthorsController(RecordService<AuthorDTO> authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorDTO> index() {
        return authorService.loadAllRecords();
    }

    @GetMapping("{mfn}")
    public AuthorDTO show(@PathVariable int mfn) {
        return authorService.loadRecordByMfn(mfn);
    }

}
