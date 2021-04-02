package ua.edu.kneu.irbisapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.kneu.irbisapi.dtl.author.AuthorDTO;
import ua.edu.kneu.irbisapi.services.AuthorService;

@RestController
@RequestMapping("authors")
public class AuthorsController extends AbstractController<AuthorDTO> {
    public AuthorsController(AuthorService recordService) {
        super(recordService);
    }
}
