package ua.edu.kneu.irbisapi.dtl.work;

import java.util.List;

public final class WorkDTO {
    public final int id;
    public final int authorId;
    public final String authorName;
    public final String title;
    public final List<WorkDTO> content;
    public final String pages;

    public WorkDTO(int id, int authorId, String authorName, String title, List<WorkDTO> content, String pages) {
        this.id = id;
        this.authorId = authorId;
        this.authorName = authorName;
        this.title = title;
        this.content = content;
        this.pages = pages;
    }
}
