package ua.edu.kneu.irbisapi.dtl.work;

import java.util.List;

import ua.edu.kneu.irbisapi.dtl.author.AuthorDTO;

public final class WorkDTO {
    public final int id;
    public final int authorId;
    public final String authorName;
    public final List<AuthorDTO> anotherAuthors;
    public final String title;
    public final List<WorkDTO> content;
    public final String pages;

    public WorkDTO(int id, int authorId, String authorName, List<AuthorDTO> anotherAuthors, String title, List<WorkDTO> content, String pages) {
        this.id = id;
        this.authorId = authorId;
        this.authorName = authorName;
        this.anotherAuthors = anotherAuthors;
        this.title = title;
        this.content = content;
        this.pages = pages;
    }
}
