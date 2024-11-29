package org.example.serverappproject.domain.model;

public class Tag {
    private Long id;
    private String designation;

    public Tag(Long id, String designation) {
        this.id = id;
        this.designation = designation;
    }

    public Tag(String designation) {
        this.designation = designation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
