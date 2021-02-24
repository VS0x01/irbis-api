package ua.edu.kneu.irbisapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.arsmagna.MarcRecord;
import ua.edu.kneu.irbisapi.dal.RecordDAO;

@RestController
@RequestMapping("authors")
public class AuthorsController {
    private final RecordDAO recordDAO;

    public AuthorsController(RecordDAO recordDAO) {
        this.recordDAO = recordDAO;
    }

    @GetMapping
    public MarcRecord[] index() {
        return recordDAO.getAll();
    }

    @GetMapping("{mfn}")
    public MarcRecord show(@PathVariable int mfn) {
        return recordDAO.get(mfn);
    }

}
