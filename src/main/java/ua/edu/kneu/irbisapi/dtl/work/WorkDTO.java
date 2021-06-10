package ua.edu.kneu.irbisapi.dtl.work;

import java.util.List;

public class WorkDTO {
    public final int id;
    public final String authorName;
    public final String title;
    public final List<WorkDTO> content;

    public WorkDTO(int id, String authorName, String title, List<WorkDTO> content) {
        this.id = id;
        this.authorName = authorName;
        this.title = title;
        this.content = content;
    }
}
