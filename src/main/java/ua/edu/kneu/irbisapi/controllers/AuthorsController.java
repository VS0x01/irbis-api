package ua.edu.kneu.irbisapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.kneu.irbisapi.dtl.author.AuthorDTO;
import ua.edu.kneu.irbisapi.services.AuthorService;

import java.util.List;

@RestController
@RequestMapping("authors")
public class AuthorsController {
    private final AuthorService authorService;

    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorDTO> index() {
        return authorService.loadAllAuthors();
    }

    @GetMapping("{mfn}")
    public AuthorDTO show(@PathVariable int mfn) {
        return authorService.loadAuthorByMfn(mfn);
    }

}
