package ua.edu.kneu.irbisapi.dtl.work;

public class WorkDTO {
    public final int id;
    public final String authorName;
    public final String title;

    public WorkDTO(int id, String authorName, String title) {
        this.id = id;
        this.authorName = authorName;
        this.title = title;
    }
}
