package ua.edu.kneu.irbisapi.dtl.author;

import java.util.Map;

public class AuthorDTO {
    public final int id;
    public final String firstName;
    public final String lastName;
    public final Map<String, String> links;

    public AuthorDTO(int id, String firstName, String lastName, Map<String, String> links) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.links = links;
    }

}
