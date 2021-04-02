package ua.edu.kneu.irbisapi.dtl.work;

public class WorkDTO {
    public final String AuthorName;
    public final String title;

    public WorkDTO(String authorName, String title) {
        this.AuthorName = authorName;
        this.title = title;
    }
}
