package ua.edu.kneu.irbisapi.dtl.work;

import ua.edu.kneu.irbisapi.dtl.author.AuthorDTO;

import java.util.List;

public final class WorkDTO {
    public final int id;
    public final String title;
    public int authorId;
    public String authorName;
    public List<AuthorDTO> anotherAuthors;
    public List<WorkDTO> content;
    public String pages;
    public int year;

    public String description;

    public WorkDTO(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public WorkDTO(int id, int authorId, String authorName, String title, String pages) {
        this.id = id;
        this.authorId = authorId;
        this.authorName = authorName;
        this.title = title;
        this.pages = pages;
    }

    public WorkDTO(int id, int authorId, String authorName, List<AuthorDTO> anotherAuthors, String title, List<WorkDTO> content, String pages, int year) {
        this.id = id;
        this.authorId = authorId;
        this.authorName = authorName;
        this.anotherAuthors = anotherAuthors;
        this.title = title;
        this.content = content;
        this.pages = pages;
        this.year = year;
    }
}
