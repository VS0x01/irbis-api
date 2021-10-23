package ua.edu.kneu.irbisapi.dtl.work;

import ua.edu.kneu.irbisapi.dtl.author.AuthorDTO;

import java.util.List;

public class WorkDTOBuilder {
    private final WorkDTO workDTO;

    public WorkDTOBuilder(int id, String title) {
        this.workDTO = new WorkDTO(id, title);
    }

    public WorkDTOBuilder(WorkDTO workDTO) {
        this.workDTO = workDTO;
    }

    public WorkDTOBuilder setAuthorId(int authorId) {
        workDTO.authorId = authorId;
        return this;
    }

    public WorkDTOBuilder setAuthorName(String authorName) {
        workDTO.authorName = authorName;
        return this;
    }

    public WorkDTOBuilder setAnotherAuthors(List<AuthorDTO> anotherAuthors) {
        workDTO.anotherAuthors = anotherAuthors;
        return this;
    }

    public WorkDTOBuilder setContent(List<WorkDTO> content) {
        workDTO.content = content;
        return this;
    }

    public WorkDTOBuilder setDescription(String description) {
        workDTO.description = description;
        return this;
    }

    public WorkDTOBuilder setYear(int year) {
        workDTO.year = year;
        return this;
    }

    public WorkDTOBuilder setLinks(List<String> links) {
        workDTO.links = links;
        return this;
    }

    public WorkDTO build() {
        return workDTO;
    }
}
