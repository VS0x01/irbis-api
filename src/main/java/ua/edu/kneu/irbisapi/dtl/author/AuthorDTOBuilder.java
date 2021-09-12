package ua.edu.kneu.irbisapi.dtl.author;

import java.util.Map;

public class AuthorDTOBuilder {
    private final AuthorDTO authorDTO;

    public AuthorDTOBuilder(int id, String firstName, String lastName) {
        this.authorDTO = new AuthorDTO(id, firstName, lastName);
    }

    public AuthorDTOBuilder(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }

    public AuthorDTOBuilder setWorkPlace(String workPlace) {
        authorDTO.workPlace = workPlace;
        return this;
    }

    public AuthorDTOBuilder setAcademicStatus(String academicStatus) {
        authorDTO.academicStatus = academicStatus;
        return this;
    }

    public AuthorDTOBuilder setDegree(String degree) {
        authorDTO.degree = degree;
        return this;
    }

    public AuthorDTOBuilder setLinks(Map<String, String> links) {
        authorDTO.links = links;
        return this;
    }

    public AuthorDTOBuilder setDescription(String description) {
        authorDTO.description = description;
        return this;
    }

    public AuthorDTO build() {
        return authorDTO;
    }
}
