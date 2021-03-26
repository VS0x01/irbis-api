package ua.edu.kneu.irbisapi.config;

public enum Databases {
    AUTHORS ("ATHRA"),
    WORKS ("WORKS");

    private String name;

    Databases(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
