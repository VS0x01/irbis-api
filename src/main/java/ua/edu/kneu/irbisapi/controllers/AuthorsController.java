package ua.edu.kneu.irbisapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.kneu.irbisapi.dtl.author.AuthorDTO;
import ua.edu.kneu.irbisapi.services.AbstractRecordService;

@RestController
@RequestMapping("authors")
public class AuthorsController extends AbstractController<AuthorDTO> {
    public AuthorsController(AbstractRecordService<AuthorDTO> recordService) {
        super(recordService);
    }
}
