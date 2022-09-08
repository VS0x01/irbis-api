package ua.edu.kneu.irbisapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.kneu.irbisapi.dtl.author.AuthorDTO;
import ua.edu.kneu.irbisapi.service.AuthorService;

@RestController
@RequestMapping("authors")
public class AuthorsController extends AbstractController<AuthorDTO> {
    public AuthorsController(AuthorService recordService) {
        super(recordService);
    }
}
