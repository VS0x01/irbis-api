package ua.edu.kneu.irbisapi.dal;

public class AuthorDTO {
    public final int id;
    public final String firstName;
    public final String lastName;

    public AuthorDTO(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
