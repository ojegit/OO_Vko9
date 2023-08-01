package com.example.oo_vko9;

import android.net.Uri;

public class User extends UserStorage {
    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;
    private Uri imageUri;

    //public User() {}
    public User(String firstName, String lastName, String email, String degreeProgram) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDegreeProgram() {
        return degreeProgram;
    }

    public Uri getImageUri() { return imageUri; }

    public void setImageUri(Uri uri) { this.imageUri = uri; }
}
