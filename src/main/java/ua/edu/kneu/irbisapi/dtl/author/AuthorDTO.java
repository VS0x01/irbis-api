package ua.edu.kneu.irbisapi.dtl.author;

import java.util.Map;

public final class AuthorDTO {
    public final int id;
    public final String firstName;
    public final String lastName;
    public String workPlace;
    public String academicStatus;
    public String degree;
    public Map<String, String> links;

    public String description;

    public AuthorDTO(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AuthorDTO(int id, String firstName, String lastName, String workPlace, String academicStatus, String degree,
                     Map<String, String> links) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.workPlace = workPlace;
        this.academicStatus = academicStatus;
        this.degree = degree;
        this.links = links;
    }

    public AuthorDTO(int id, String firstName, String lastName, String workPlace, String academicStatus, String degree,
                     Map<String, String> links, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.workPlace = workPlace;
        this.academicStatus = academicStatus;
        this.degree = degree;
        this.links = links;
        this.description = description;
    }

}
